package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

class Car37 {
	private final int id;
	private boolean engine = false, driveTrain = false, wheels = false,
			exhaust = false, body = false, fender = false;

	public Car37(int idn) {
		id = idn;
	}

	// Empty Car object:
	public Car37() {
		id = -1;
	}

	public synchronized int getId() {
		return id;
	}

	public synchronized void addEngine() {
		engine = true;
	}

	public synchronized void addDriveTrain() {
		driveTrain = true;
	}

	public synchronized void addWheels() {
		wheels = true;
	}

	public synchronized void addExhaout() {
		exhaust = true;
	}

	public synchronized void addBody() {
		body = true;
	}

	public synchronized void addFender() {
		fender = true;
	}

	public synchronized String toString() {
		return "Car " + id + " [" + " engine: " + engine + " driveTrain: "
				+ driveTrain + " wheels: " + wheels + " exhaust: " + exhaust
				+ " body: " + body + " fender: " + fender + " ]";
	}
}

class CarQueue extends LinkedBlockingQueue<Car37> {
}

class ChassisBuilder implements Runnable {
	private CarQueue carQueue;
	private int counter = 0;

	public ChassisBuilder(CarQueue cq) {
		carQueue = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(500);
				// Make chassis:
				Car37 c = new Car37(counter++);
				System.out.println("ChassisBuilder created " + c);
				// Insert into queue
				carQueue.put(c);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted: ChassisBuilder");
		}
		System.out.println("ChassisBuilder off");
	}
}

class Assembler implements Runnable {
	protected CarQueue chassisQueue, finishingQueue;
	protected Car37 car;
	protected CyclicBarrier barrier = new CyclicBarrier(4);
	protected RobotPool robotPool;

	public Assembler(CarQueue cq, CarQueue fq, RobotPool rp) {
		chassisQueue = cq;
		finishingQueue = fq;
		robotPool = rp;
	}

	public Car37 car() {
		return car;
	}

	public CyclicBarrier barrier() {
		return barrier;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				car = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(EngineRobot.class, this);
				robotPool.hire(DriveTrainRobot.class, this);
				robotPool.hire(WheelRobot.class, this);
				barrier.await(); // Until the robots finish
				// Put car into finishingQueue for further work
				finishingQueue.put(car);
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

class Assembler2 extends Assembler {

	public Assembler2(CarQueue cq, CarQueue fq, RobotPool rp) {
		super(cq, fq, rp);
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until chassis is available:
				car = chassisQueue.take();
				// Hire robots to perform work:
				robotPool.hire(ExhaustRobot.class, this);
				robotPool.hire(BodyRobot.class, this);
				robotPool.hire(FenderRobot.class, this);
				barrier.await(); // Until the robots finish
				// Put car into finishingQueue for further work
				finishingQueue.put(car);
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

class Reporter implements Runnable {
	private CarQueue carQueue;

	public Reporter(CarQueue cq) {
		carQueue = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println(carQueue.take());
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting Reporter via interrupt");
		}
		System.out.println("Reporter off");
	}
}

abstract class Robot implements Runnable {
	private RobotPool pool;

	public Robot(RobotPool p) {
		pool = p;
	}

	protected Assembler assembler;

	public Robot assignAssembler(Assembler assembler) {
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

class EngineRobot extends Robot {
	public EngineRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		System.out.println(this + " installing engine");
		assembler.car().addEngine();
	}
}

class DriveTrainRobot extends Robot {
	public DriveTrainRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		System.out.println(this + " installing DriveTrain");
		assembler.car().addDriveTrain();
	}
}

class WheelRobot extends Robot {
	public WheelRobot(RobotPool pool) {
		super(pool);
	}

	protected void performService() {
		System.out.println(this + " installing Wheels");
		assembler.car().addWheels();
	}
}

class ExhaustRobot extends Robot {

	public ExhaustRobot(RobotPool p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing Exhaust System");
		assembler.car().addExhaout();
	}

}

class BodyRobot extends Robot {

	public BodyRobot(RobotPool p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing Body System");
		assembler.car().addBody();
	}

}

class FenderRobot extends Robot {

	public FenderRobot(RobotPool p) {
		super(p);
	}

	@Override
	protected void performService() {
		System.out.println(this + " installing Fender System");
		assembler.car().addFender();
	}

}

class RobotPool {
	// Quietly prevents identical entries:
	private Set<Robot> pool = new HashSet<Robot>();

	public synchronized void add(Robot r) {
		pool.add(r);
		notifyAll();
	}

	public synchronized void hire(Class<? extends Robot> robotType, Assembler d)
			throws InterruptedException {
		for (Robot r : pool)
			if (r.getClass().equals(robotType)) {
				pool.remove(r);
				r.assignAssembler(d);
				r.engage(); // Power it up to do the task
				return;
			}
		wait(); // None available
		hire(robotType, d); // Try again, recursively
	}

	public synchronized void release(Robot r) {
		add(r);
	}
}

class CarBuilder {
	public static void main(String[] args) throws Exception {
		CarQueue chassisQueue = new CarQueue(), secondQueue = new CarQueue(), finishingQueue = new CarQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		RobotPool robotPool = new RobotPool();
		exec.execute(new EngineRobot(robotPool));
		exec.execute(new DriveTrainRobot(robotPool));
		exec.execute(new WheelRobot(robotPool));
		exec.execute(new ExhaustRobot(robotPool));
		exec.execute(new BodyRobot(robotPool));
		exec.execute(new FenderRobot(robotPool));
		exec.execute(new Assembler(chassisQueue, secondQueue, robotPool));
		exec.execute(new Assembler2(secondQueue, finishingQueue, robotPool));
		exec.execute(new Reporter(finishingQueue));
		// Start everything running by producing chassis:
		exec.execute(new ChassisBuilder(chassisQueue));
		TimeUnit.SECONDS.sleep(7);
		exec.shutdownNow();
	}
}

public class Ex37 {
	public static void main(String[] args) {

	}
}
