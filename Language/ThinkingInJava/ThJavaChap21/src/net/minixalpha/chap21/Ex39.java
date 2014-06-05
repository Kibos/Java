package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.*;

class FastSimulation {
	static final int N_ELEMENTS = 100;
	static final int N_GENES = 30;
	static final int N_EVOLVERS = 50;
	static final int[][] GRID = new int[N_ELEMENTS][N_GENES];
	static Random rand = new Random(47);
	static final Lock lock = new ReentrantLock();

	static class Evolver implements Runnable {
		public void run() {
			while (!Thread.interrupted()) {
				// Randomly select an element to work on:
				int element = rand.nextInt(N_ELEMENTS);
				for (int i = 0; i < N_GENES; i++) {
					int previous = element - 1;
					if (previous < 0)
						previous = N_ELEMENTS - 1;
					int next = element + 1;
					if (next >= N_ELEMENTS)
						next = 0;

					lock.lock();
					int oldvalue = GRID[element][i];
					// Perform some kind of modeling calculation:
					int newvalue = oldvalue + GRID[previous][i] + GRID[next][i];
					newvalue /= 3; // Average the three values
					if (oldvalue == GRID[element][i]) {
						GRID[element][i] = newvalue;
					} else {
						System.out
								.println("Old value changed from " + oldvalue);
					}
					lock.unlock();
				}
			}
		}
	}

	static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < N_ELEMENTS; i++)
			for (int j = 0; j < N_GENES; j++)
				GRID[i][j] = new Integer(rand.nextInt(1000));
		for (int i = 0; i < N_EVOLVERS; i++)
			exec.execute(new Evolver());
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}

class FastSimulation2 {
	  static final int N_ELEMENTS = 100000;
	  static final int N_GENES = 30;
	  static final int N_EVOLVERS = 50;
	  static final AtomicInteger[][] GRID =
	    new AtomicInteger[N_ELEMENTS][N_GENES];
	  static Random rand = new Random(47);
	  static class Evolver implements Runnable {
	    public void run() {
	      while(!Thread.interrupted()) {
	        // Randomly select an element to work on:
	        int element = rand.nextInt(N_ELEMENTS);
	        for(int i = 0; i < N_GENES; i++) {
	          int previous = element - 1;
	          if(previous < 0) previous = N_ELEMENTS - 1;
	          int next = element + 1;
	          if(next >= N_ELEMENTS) next = 0;
	          int oldvalue = GRID[element][i].get();
	          // Perform some kind of modeling calculation:
	          int newvalue = oldvalue +
	            GRID[previous][i].get() + GRID[next][i].get();
	          newvalue /= 3; // Average the three values
	          if(!GRID[element][i]
	            .compareAndSet(oldvalue, newvalue)) {
	            // Policy here to deal with failure. Here, we
	            // just report it and ignore it; our model
	            // will eventually deal with it.
	            System.out.println("Old value changed from " + oldvalue);
	          }
	        }
	      }
	    }
	  }
	  public static void main(String[] args) throws Exception {
	    ExecutorService exec = Executors.newCachedThreadPool();
	    for(int i = 0; i < N_ELEMENTS; i++)
	      for(int j = 0; j < N_GENES; j++)
	        GRID[i][j] = new AtomicInteger(rand.nextInt(1000));
	    for(int i = 0; i < N_EVOLVERS; i++)
	      exec.execute(new Evolver());
	    TimeUnit.SECONDS.sleep(5);
	    exec.shutdownNow();
	  }
	} 

public class Ex39 {
	public static void main(String[] args) throws Exception {
		//FastSimulation.main(args);
		FastSimulation2.main(args);
	}
}
