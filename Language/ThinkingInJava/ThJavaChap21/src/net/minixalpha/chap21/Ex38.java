package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

class House {
	private final int id;
	private boolean footing = false, steel = false, concrete = false,
			concreteFoundation = false, plumb = false, concreteSlab = false,
			structure = false;

	public House(int idn) {
		id = idn;
	}

	// Empty Car object:
	public House() {
		id = -1;
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void addFooting() {
		footing = true;
	}

	public synchronized void addSteel() {
		steel = true;
	}

	public synchronized void addConcrete() {
		concrete = true;
	}

	public synchronized void addExhaout() {
		concreteFoundation = true;
	}

	public synchronized void addPlumb() {
		plumb = true;
	}

	public synchronized void addConcreteSlab() {
		concreteSlab = true;
	}

	public synchronized void addStructure() {
		structure = true;
	}

	public synchronized String toString() {
		return "House " + id + " [" + " footing: " + footing + " steel: "
				+ steel + " concrete: " + concrete + " concreteFoundation: "
				+ concreteFoundation + " plumb: " + plumb + " concreteSlab: "
				+ concreteSlab + " structure:" + structure + " ]";
	}
}

class HouseQueue extends LinkedBlockingQueue<House> {
}

class ChassisBuilder38 implements Runnable {
	private HouseQueue houseQueue;
	private int counter = 0;

	public ChassisBuilder38(HouseQueue cq) {
		houseQueue = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(500);
				// Make chassis:
				House c = new House(counter++);
				System.out.println("ChassisBuilder38 created " + c);
				// Insert into queue
				houseQueue.put(c);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted: ChassisBuilder38");
		}
		System.out.println("ChassisBuilder38 off");
	}
}

class MakingHouse implements Runnable {
	protected HouseQueue chassisQueue, finishingQueue;
	protected House house;
	protected CyclicBarrier barrier = null;
	protected Robot2Pool38 robotPool;

	public MakingHouse(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		chassisQueue = cq;
		finishingQueue = fq;
		robotPool = rp;
	}

	public House house() {
		return house;
	}

	public CyclicBarrier barrier() {
		return barrier;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class Footing extends MakingHouse {
	CyclicBarrier barrier = new CyclicBarrier(2);

	public Footing(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		super(cq, fq, rp);
	}

	public CyclicBarrier barrier() {
		return barrier;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(FootingRobot2.class, this);
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);

			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class SteelConcrete extends MakingHouse {
	CyclicBarrier barrier = new CyclicBarrier(3);

	public CyclicBarrier barrier() {
		return barrier;
	}

	public SteelConcrete(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		super(cq, fq, rp);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(SteelRobot2.class, this);
				robotPool.hire(ConcreteRobot2.class, this);
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class ConcreteFoundation extends MakingHouse {
	CyclicBarrier barrier = new CyclicBarrier(2);

	public CyclicBarrier barrier() {
		return barrier;
	}

	public ConcreteFoundation(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		super(cq, fq, rp);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(ConcreteFoundationRobot2.class, this);
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class Plumbing extends MakingHouse {
	CyclicBarrier barrier = new CyclicBarrier(2);

	public CyclicBarrier barrier() {
		return barrier;
	}

	public Plumbing(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		super(cq, fq, rp);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(PlumbRobot2.class, this);
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class ConcreteSlab extends MakingHouse {
	CyclicBarrier barrier = new CyclicBarrier(2);

	public CyclicBarrier barrier() {
		return barrier;
	}

	public ConcreteSlab(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		super(cq, fq, rp);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(ConcreteSlabRobot2.class, this);
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class HouseStructure extends MakingHouse {
	CyclicBarrier barrier = new CyclicBarrier(2);

	public CyclicBarrier barrier() {
		return barrier;
	}

	public HouseStructure(HouseQueue cq, HouseQueue fq, Robot2Pool38 rp) {
		super(cq, fq, rp);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				house = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(StructureRobot2.class, this);
				barrier.await(); // Until the robots finish
				// Put house into finishingQueue for further work
				finishingQueue.put(house);
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Assembler via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println("Assembler off");
	}
}

class Reporter38 implements Runnable {
	private HouseQueue houseQueue;

	public Reporter38(HouseQueue cq) {
		houseQueue = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(houseQueue.take());
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Reporter38 via interrupt");
		}
		System.out.println("Reporter38 off");
	}
}

abstract class Robot2 implements Runnable {
	private Robot2Pool38 pool;

	public Robot2(Robot2Pool38 p) {
		pool = p;
	}

	protected MakingHouse assembler;

	public Robot2 assignAssembler(MakingHouse assembler) {
		this.assembler = assembler;
		return this;
	}

	private boolean engage = false;

	public synchronized void engage() {
		engage = true;
		notifyAll();
	}

	// The part of run() that's different for each robot:
	abstract protected void performService();

	public void run() {
		try {
			powerDown(); // Wait until needed
			while (!Thread.interrupted()) {
				performService();
				assembler.barrier().await(); // Synchronize
				// We're done with that job...
				powerDown();
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting " + this + " via interrupt");
		} catch (BrokenBarrierException e) {
			// This one we want to know about
			throw new RuntimeException(e);
		}
		System.out.println(this + " off");
	}

	private synchronized void powerDown() throws InterruptedException {
		engage = false;
		assembler = null; // Disconnect from the Assembler
		// Put ourselves back in the available pool:
		pool.release(this);
		while (engage == false)
			// Power down
			wait();
	}

	public String toString() {
		return getClass().getName();
	}
}

class FootingRobot2 extends Robot2 {
	public FootingRobot2(Robot2Pool38 pool) {
		super(pool);
	}

	protected void performService() {
		System.out.println(this + " installing footing");
		assembler.house().addFooting();
	}
}

class SteelRobot2 extends Robot2 {
	public SteelRobot2(Robot2Pool38 pool) {
		super(pool);
	}

	protected void performService() {
		System.out.println(this + " installing Steel");
		assembler.house().addSteel();
	}
}

class ConcreteRobot2 extends Robot2 {
	public ConcreteRobot2(Robot2Pool38 pool) {
		super(pool);
	}

	protected void performService() {
		System.out.println(this + " installing Concrete");
		assembler.house().addConcrete();
	}
}

class ConcreteFoundationRobot2 extends Robot2 {

	public ConcreteFoundationRobot2(Robot2Pool38 p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing ConcreteFoundation System");
		assembler.house().addExhaout();
	}

}

class PlumbRobot2 extends Robot2 {

	public PlumbRobot2(Robot2Pool38 p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing Plumb System");
		assembler.house().addPlumb();
	}

}

class ConcreteSlabRobot2 extends Robot2 {

	public ConcreteSlabRobot2(Robot2Pool38 p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing ConcreteSlab System");
		assembler.house().addConcreteSlab();
	}

}

class StructureRobot2 extends Robot2 {

	public StructureRobot2(Robot2Pool38 p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing StructureRobot2 System");
		assembler.house().addStructure();
	}

}

class Robot2Pool38 {
	// Quietly prevents identical entries:
	private Set<Robot2> pool = new HashSet<Robot2>();

	public synchronized void add(Robot2 r) {
		pool.add(r);
		notifyAll();
	}

	public synchronized void hire(Class<? extends Robot2> robotType,
			MakingHouse d) throws InterruptedException {
		for (Robot2 r : pool)
			if (r.getClass().equals(robotType)) {
				pool.remove(r);
				r.assignAssembler(d);
				r.engage(); // Power it up to do the task
				return;
			}
		wait(); // None available
		hire(robotType, d); // Try again, recursively
	}

	public synchronized void release(Robot2 r) {
		add(r);
	}
}

class HouseBuilder {
	public static void main(String[] args) throws Exception {

		ExecutorService exec = Executors.newCachedThreadPool();
		Robot2Pool38 robotPool = new Robot2Pool38();
		exec.execute(new FootingRobot2(robotPool));
		exec.execute(new SteelRobot2(robotPool));
		exec.execute(new ConcreteRobot2(robotPool));
		exec.execute(new ConcreteFoundationRobot2(robotPool));
		exec.execute(new PlumbRobot2(robotPool));
		exec.execute(new ConcreteSlabRobot2(robotPool));
		exec.execute(new StructureRobot2(robotPool));

		HouseQueue basicHouseQueue = new HouseQueue(), footingQueue = new HouseQueue(), steelConcreteQueue = new HouseQueue(), finishingQueue = new HouseQueue();
		HouseQueue concreteFoundationQueue = new HouseQueue();
		HouseQueue plumbQueue = new HouseQueue();
		HouseQueue concreteSlabQueue = new HouseQueue();
		HouseQueue structureQueue = new HouseQueue();

		// exec.execute(new MakingHouse(basicHouseQueue, footingQueue,
		// robotPool));
		exec.execute(new Footing(footingQueue, steelConcreteQueue, robotPool));
		exec.execute(new SteelConcrete(steelConcreteQueue,
				concreteFoundationQueue, robotPool));
		exec.execute(new ConcreteFoundation(concreteFoundationQueue,
				plumbQueue, robotPool));

		exec.execute(new Plumbing(plumbQueue, concreteSlabQueue, robotPool));
		exec.execute(new ConcreteSlab(concreteSlabQueue, structureQueue,
				robotPool));
		exec.execute(new HouseStructure(structureQueue, finishingQueue,
				robotPool));

		exec.execute(new Reporter38(finishingQueue));
		// Start everything running by producing chassis:
		exec.execute(new ChassisBuilder38(footingQueue));
		TimeUnit.SECONDS.sleep(7);
		exec.shutdownNow();
	}
}

public class Ex38 {
	public static void main(String[] args) throws Exception {
		HouseBuilder.main(args);
	}
}
