package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;

// Read-only objects don't require synchronization:
class Customer {
	private final int serviceTime;

	public Customer(int tm) {
		serviceTime = tm;
	}

	public int getServiceTime() {
		return serviceTime;
	}

	public String toString() {
		return "[" + serviceTime + "]";
	}
}

// Teach the customer line to display itself:
class CustomerLine extends ArrayBlockingQueue<Customer> {
	public CustomerLine(int maxLineSize) {
		super(maxLineSize);
	}

	public String toString() {
		if (this.size() == 0)
			return "[Empty]";
		StringBuilder result = new StringBuilder();
		for (Customer customer : this)
			result.append(customer);
		return result.toString();
	}
}

// Randomly add customers to a queue:
class CustomerGenerator implements Runnable {
	private CustomerLine customers;
	private static Random rand = new Random(47);

	public CustomerGenerator(CustomerLine cq) {
		customers = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
				customers.put(new Customer(rand.nextInt(1000)));
			}
		} catch (InterruptedException e) {
			System.out.println("CustomerGenerator interrupted");
		}
		System.out.println("CustomerGenerator terminating");
	}
}

class Teller implements Runnable, Comparable<Teller> {
	private static int counter = 0;
	private final int id = counter++;
	// Customers served during this shift:
	private int customersServed = 0;
	private CustomerLine customers;
	private boolean servingCustomerLine = true;

	public Teller(CustomerLine cq) {
		customers = cq;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				Customer customer = customers.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
					customersServed++;
					while (!servingCustomerLine)
						wait();
				}
			}
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		}
		System.out.println(this + "terminating");
	}

	public synchronized void doSomethingElse() {
		customersServed = 0;
		servingCustomerLine = false;
	}

	public synchronized void serveCustomerLine() {
		assert !servingCustomerLine : "already serving: " + this;
		servingCustomerLine = true;
		notifyAll();
	}

	public String toString() {
		return "Teller " + id + " ";
	}

	public String shortString() {
		return "T" + id;
	}

	// Used by priority queue:
	public synchronized int compareTo(Teller other) {
		return customersServed < other.customersServed ? -1
				: (customersServed == other.customersServed ? 0 : 1);
	}
}

class TellerManager implements Runnable {
	private ExecutorService exec;
	private CustomerLine customers;
	private PriorityQueue<Teller> workingTellers = new PriorityQueue<Teller>();
	private Queue<Teller> tellersDoingOtherThings = new LinkedList<Teller>();
	private int adjustmentPeriod;
	private int serverCount;
	private static Random rand = new Random(47);

	public TellerManager(ExecutorService e, CustomerLine customers,
			int adjustmentPeriod, int serverCount) {
		exec = e;
		this.customers = customers;
		this.adjustmentPeriod = adjustmentPeriod;
		// Start with a single teller:
		this.serverCount = serverCount;

		for (int i = 0; i < this.serverCount; i++) {
			Teller teller = new Teller(customers);
			exec.execute(teller);
			workingTellers.add(teller);
		}

	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
				System.out.print(customers + " { ");
				for (Teller teller : workingTellers)
					System.out.print(teller.shortString() + " ");
				System.out.println("}");
			}
		} catch (InterruptedException e) {
			System.out.println(this + "interrupted");
		}
		System.out.println(this + "terminating");
	}

	public String toString() {
		return "TellerManager ";
	}
}

class BankTellerSimulation {
	static final int MAX_LINE_SIZE = 50;
	static final int ADJUSTMENT_PERIOD = 1000;
	static final int SERVER_COUNT = 5;

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		// If line is too long, customers will leave:
		CustomerLine customers = new CustomerLine(MAX_LINE_SIZE);
		exec.execute(new CustomerGenerator(customers));
		// Manager will add and remove tellers as necessary:
		exec.execute(new TellerManager(exec, customers, ADJUSTMENT_PERIOD,
				SERVER_COUNT));

		if (args.length > 0) // Optional argument
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		else {
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
}

public class Ex35 {
	public static void main(String[] args) throws Exception {
		BankTellerSimulation.main(args);
	}
}
