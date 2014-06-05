package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.*;

class ReadWriteHashMap<K, V> implements Map<K, V> {
	private HashMap<K, V> map;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	public ReadWriteHashMap(Map<? extends K, ? extends V> m) {
		map = new HashMap<>(m);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public V get(Object key) {
		Lock wlock = lock.writeLock();
		wlock.lock();
		try {
			return map.get(key);
		} finally {
			wlock.unlock();
		}
	}

	@Override
	public V put(K key, V value) {
		Lock rlock = lock.readLock();
		rlock.lock();

		try {
			return map.put(key, value);
		} finally {
			rlock.unlock();
		}
	}

	@Override
	public V remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		map.putAll(m);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return map.entrySet();
	}

}

abstract class MapTest extends Tester<Map<Integer, Integer>> {
	MapTest(String testId, int nReaders, int nWriters) {
		super(testId, nReaders, nWriters);
	}

	class Reader extends TestTask {
		long result = 0;

		void test() {
			for (long i = 0; i < testCycles; i++)
				for (int index = 0; index < containerSize; index++)
					result += testContainer.get(index);
		}

		void putResults() {
			readResult += result;
			readTime += duration;
		}
	}

	class Writer extends TestTask {
		void test() {
			for (long i = 0; i < testCycles; i++)
				for (int index = 0; index < containerSize; index++)
					testContainer.put(index, writeData[index]);
		}

		void putResults() {
			writeTime += duration;
		}
	}

	void startReadersAndWriters() {
		for (int i = 0; i < nReaders; i++)
			exec.execute(new Reader());
		for (int i = 0; i < nWriters; i++)
			exec.execute(new Writer());
	}
}

class SynchronizedHashMapTest extends MapTest {
	Map<Integer, Integer> containerInitializer() {
		return Collections.synchronizedMap(new HashMap<Integer, Integer>(
				MapData.map(new CountingGenerator.Integer(),
						new CountingGenerator.Integer(), containerSize)));
	}

	SynchronizedHashMapTest(int nReaders, int nWriters) {
		super("Synched HashMap", nReaders, nWriters);
	}
}

class ConcurrentHashMapTest extends MapTest {
	Map<Integer, Integer> containerInitializer() {
		return new ConcurrentHashMap<Integer, Integer>(MapData.map(
				new CountingGenerator.Integer(),
				new CountingGenerator.Integer(), containerSize));
	}

	ConcurrentHashMapTest(int nReaders, int nWriters) {
		super("ConcurrentHashMap", nReaders, nWriters);
	}
}

class ReadWriteMapTest extends MapTest {

	ReadWriteMapTest(int nReaders, int nWriters) {
		super("ReadWriteMap", nReaders, nWriters);
	}

	@Override
	Map<Integer, Integer> containerInitializer() {
		return new ReadWriteHashMap<Integer, Integer>(MapData.map(
				new CountingGenerator.Integer(),
				new CountingGenerator.Integer(), containerSize));
	}

}

class MapComparisons {
	public static void main(String[] args) {
		Tester.initMain(args);
		new SynchronizedHashMapTest(10, 0);
		new SynchronizedHashMapTest(9, 1);
		new SynchronizedHashMapTest(5, 5);

		new ConcurrentHashMapTest(10, 0);
		new ConcurrentHashMapTest(9, 1);
		new ConcurrentHashMapTest(5, 5);

		new ReadWriteMapTest(10, 0);
		new ReadWriteMapTest(9, 1);
		new ReadWriteMapTest(5, 5);

		Tester.exec.shutdown();
	}
}

public class Ex40 {
	public static void main(String[] args) {
		MapComparisons.main(args);
	}
}

/*
 Type                             Read time     Write time
Synched HashMap 10r 0w         19250119603              0
Synched HashMap 10r 0w         16647737548              0
Synched HashMap 10r 0w         17868148536              0
Synched HashMap 10r 0w         17439155636              0
Synched HashMap 10r 0w         16940205387              0
Synched HashMap 10r 0w         16683948682              0
Synched HashMap 10r 0w         17705990539              0
Synched HashMap 10r 0w         17468520688              0
Synched HashMap 10r 0w         17986659113              0
Synched HashMap 10r 0w         17318881251              0
Synched HashMap 9r 1w          16042057226     1712744685
readTime + writeTime =         17754801911
Synched HashMap 9r 1w          16828830755     1589786175
readTime + writeTime =         18418616930
Synched HashMap 9r 1w          16521844792     1901532382
readTime + writeTime =         18423377174
Synched HashMap 9r 1w          16524865149     1929990820
readTime + writeTime =         18454855969
Synched HashMap 9r 1w          15614515497     1276922993
readTime + writeTime =         16891438490
Synched HashMap 9r 1w          17002970129     1761734502
readTime + writeTime =         18764704631
Synched HashMap 9r 1w          15902396598     1864908102
readTime + writeTime =         17767304700
Synched HashMap 9r 1w          16654900626     1838962485
readTime + writeTime =         18493863111
Synched HashMap 9r 1w          16216057670     1779905464
readTime + writeTime =         17995963134
Synched HashMap 9r 1w          15488638605     1696978573
readTime + writeTime =         17185617178
Synched HashMap 5r 5w           9358488747     9309850506
readTime + writeTime =         18668339253
Synched HashMap 5r 5w           9301716515     8044560829
readTime + writeTime =         17346277344
Synched HashMap 5r 5w           9110408874     9338185110
readTime + writeTime =         18448593984
Synched HashMap 5r 5w           9080889634     8531090112
readTime + writeTime =         17611979746
Synched HashMap 5r 5w           9640208850    10119282133
readTime + writeTime =         19759490983
Synched HashMap 5r 5w           8756739737     8792514815
readTime + writeTime =         17549254552
Synched HashMap 5r 5w           9402745550     9395281687
readTime + writeTime =         18798027237
Synched HashMap 5r 5w           8693127029     8169513381
readTime + writeTime =         16862640410
Synched HashMap 5r 5w           8448480143     7643473234
readTime + writeTime =         16091953377
Synched HashMap 5r 5w           9634631605     9537965469
readTime + writeTime =         19172597074
ConcurrentHashMap 10r 0w        2091536649              0
ConcurrentHashMap 10r 0w        1265181855              0
ConcurrentHashMap 10r 0w        1788645119              0
ConcurrentHashMap 10r 0w        1264487961              0
ConcurrentHashMap 10r 0w        1630508043              0
ConcurrentHashMap 10r 0w        1661141837              0
ConcurrentHashMap 10r 0w        1054353769              0
ConcurrentHashMap 10r 0w        1685172387              0
ConcurrentHashMap 10r 0w        1258424744              0
ConcurrentHashMap 10r 0w        1642739218              0
ConcurrentHashMap 9r 1w         1715079125      340257375
readTime + writeTime =          2055336500
ConcurrentHashMap 9r 1w         1002676444      226476492
readTime + writeTime =          1229152936
ConcurrentHashMap 9r 1w         1036090910      224114810
readTime + writeTime =          1260205720
ConcurrentHashMap 9r 1w         1209402828      251944050
readTime + writeTime =          1461346878
ConcurrentHashMap 9r 1w         1119303993      233558123
readTime + writeTime =          1352862116
ConcurrentHashMap 9r 1w         1591297120      274673055
readTime + writeTime =          1865970175
ConcurrentHashMap 9r 1w         1608562470      290987914
readTime + writeTime =          1899550384
ConcurrentHashMap 9r 1w         1432242951      256025152
readTime + writeTime =          1688268103
ConcurrentHashMap 9r 1w         1149107087      234732710
readTime + writeTime =          1383839797
ConcurrentHashMap 9r 1w          935437595      188698367
readTime + writeTime =          1124135962
ConcurrentHashMap 5r 5w          528096836     3380103848
readTime + writeTime =          3908200684
ConcurrentHashMap 5r 5w          727450603     3383740199
readTime + writeTime =          4111190802
ConcurrentHashMap 5r 5w          667363432     3547776573
readTime + writeTime =          4215140005
ConcurrentHashMap 5r 5w          650694201     3738316584
readTime + writeTime =          4389010785
ConcurrentHashMap 5r 5w          638534626     3754604479
readTime + writeTime =          4393139105
ConcurrentHashMap 5r 5w          787578083     3871052388
readTime + writeTime =          4658630471
ConcurrentHashMap 5r 5w          772440892     3535457824
readTime + writeTime =          4307898716
ConcurrentHashMap 5r 5w          889517856     3635050087
readTime + writeTime =          4524567943
ConcurrentHashMap 5r 5w          957350371     3763041451
readTime + writeTime =          4720391822
ConcurrentHashMap 5r 5w          690604301     3306807664
readTime + writeTime =          3997411965
ReadWriteMap 10r 0w            12911238513              0
ReadWriteMap 10r 0w            12910080985              0
ReadWriteMap 10r 0w             8785103895              0
ReadWriteMap 10r 0w             8620802341              0
ReadWriteMap 10r 0w             8562775688              0
ReadWriteMap 10r 0w             8595122381              0
ReadWriteMap 10r 0w             9050808837              0
ReadWriteMap 10r 0w             8377963811              0
ReadWriteMap 10r 0w             8365899924              0
ReadWriteMap 10r 0w             8333072145              0
ReadWriteMap 9r 1w              6824942832     1008827243
readTime + writeTime =          7833770075
ReadWriteMap 9r 1w              7495771760      977672019
readTime + writeTime =          8473443779
ReadWriteMap 9r 1w              7040453958      993147100
readTime + writeTime =          8033601058
ReadWriteMap 9r 1w              7160959672      974372719
readTime + writeTime =          8135332391
ReadWriteMap 9r 1w              6984212552      961963813
readTime + writeTime =          7946176365
ReadWriteMap 9r 1w              7074960094      917351640
readTime + writeTime =          7992311734
ReadWriteMap 9r 1w              6993854110      959008055
readTime + writeTime =          7952862165
ReadWriteMap 9r 1w              7371051652      975105284
readTime + writeTime =          8346156936
ReadWriteMap 9r 1w              6853187064      980366914
readTime + writeTime =          7833553978
ReadWriteMap 9r 1w              6583318566      913601167
readTime + writeTime =          7496919733
ReadWriteMap 5r 5w              8351060074    10230468422
readTime + writeTime =         18581528496
ReadWriteMap 5r 5w              5653126273     8212017174
readTime + writeTime =         13865143447
ReadWriteMap 5r 5w              5250536400     8648689198
readTime + writeTime =         13899225598
ReadWriteMap 5r 5w              5350384300     8155507561
readTime + writeTime =         13505891861
ReadWriteMap 5r 5w              6299109476     9286378810
readTime + writeTime =         15585488286
ReadWriteMap 5r 5w              5917787581    10037046255
readTime + writeTime =         15954833836
ReadWriteMap 5r 5w              5080991999     9035476855
readTime + writeTime =         14116468854
ReadWriteMap 5r 5w              6567778141     8064506102
readTime + writeTime =         14632284243
ReadWriteMap 5r 5w              7211656234    11094320437
readTime + writeTime =         18305976671
ReadWriteMap 5r 5w              4720788155     9583947503
readTime + writeTime =         14304735658
*/
