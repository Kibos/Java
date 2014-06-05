package net.minixalpha.chap21;

import net.minixalpha.chap21.menu.*;

import java.util.concurrent.*;
import java.util.*;

// This is given to the waiter, who gives it to the chef:

class OrderTicket {
	BlockingQueue<Order> orderTicket = new LinkedBlockingQueue<Order>();
	private Customer3 customer;
	private WaitPerson36 waiter;
	private Food food;

	public void add(Customer3 cust, WaitPerson36 wp, Food f) {
		this.customer = cust;
		this.waiter = wp;
		this.food = f;
		try {
			orderTicket.put(new Order(cust, wp, f));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Food item() {
		return food;
	}

	public Customer3 getCustomer() {
		return customer;
	}

	public WaitPerson36 getWaitPerson() {
		return waiter;
	}

	public int getOrderCount() {
		return orderTicket.size();
	}

	static class Order { // (A data-transfer object)
		private static int counter = 0;
		private final int id = counter++;
		private final Customer3 customer;
		private final WaitPerson36 waitPerson;
		private final Food food;

		public Order(Customer3 cust, WaitPerson36 wp, Food f) {
			customer = cust;
			waitPerson = wp;
			food = f;
		}

		public Food item() {
			return food;
		}

		public Customer3 getCustomer3() {
			return customer;
		}

		public WaitPerson36 getWaitPerson36() {
			return waitPerson;
		}

		public String toString() {
			return "Order: " + id + " item: " + food + " for: " + customer
					+ " served by: " + waitPerson;
		}
	}
}

class Table {
	public static int CAPACITY = 5;
	OrderTicket orderTicket = new OrderTicket();
	private List<Customer3> customers = new ArrayList<Customer3>();

	public void addCustomer(Customer3 c) {
		customers.add(c);
	}

	public int getCustomerSize() {
		return customers.size();
	}

	public boolean removeCustomer(Customer3 c) {
		return customers.remove(c);
	}

	public void addToOrderTicket(Customer3 cust, WaitPerson36 wp, Food f) {
		orderTicket.add(cust, wp, f);
	}

	public int getOrderCount() {
		return orderTicket.getOrderCount();
	}
}

// This is what comes back from the chef:
class Plate {
	private final OrderTicket order;
	private final Food food;

	public Plate(OrderTicket ord, Food f) {
		order = ord;
		food = f;
	}

	public OrderTicket getOrder() {
		return order;
	}

	public Food getFood() {
		return food;
	}

	public String toString() {
		return food.toString();
	}
}

class Customer3 implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final WaitPerson36 waitPerson;
	// Only one course at a time can be received:
	private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<Plate>();
	private Table table;

	public Customer3(WaitPerson36 w, Table table) {
		waitPerson = w;
		this.table = table;
	}

	public void deliver(Plate p) throws InterruptedException {
		// Only blocks if customer is still
		// eating the previous course:
		placeSetting.put(p);
	}

	public Table getTable() {
		return table;
	}

	public void run() {
		for (Course course : Course.values()) {
			Food food = course.randomSelection();
			try {
				waitPerson.placeOrder(this, food);
				// Blocks until course has been delivered:
				System.out.println(this + "eating " + placeSetting.take());
			} catch (InterruptedException e) {
				System.out.println(this + "waiting for " + course
						+ " interrupted");
				break;
			}
		}
		System.out.println(this + "finished meal, leaving");
		getTable().removeCustomer(this);
		synchronized (waitPerson.getRestaurant()) {
			waitPerson.getRestaurant().notifyAll();
		}
	}

	public String toString() {
		return "Customer3 " + id + " ";
	}
}

class WaitPerson36 implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant36 restaurant;
	BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<Plate>();

	public WaitPerson36(Restaurant36 rest) {
		restaurant = rest;
	}

	public Restaurant36 getRestaurant() {
		return restaurant;
	}

	public void placeOrder(Customer3 cust, Food food) {
		// Shouldn't actually block because this is
		// a LinkedBlockingQueue with no size limit:
		Table table = cust.getTable();
		table.addToOrderTicket(cust, this, food);
		synchronized (restaurant) {
			restaurant.notifyAll();
		}

	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until a course is ready
				Plate plate = filledOrders.take();
				System.out.println(this + "received " + plate
						+ " delivering to " + plate.getOrder().getCustomer());
				plate.getOrder().getCustomer().deliver(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " off duty");
	}

	public String toString() {
		return "WaitPerson36 " + id + " ";
	}
}

class Chef36 implements Runnable {
	private static int counter = 0;
	private final int id = counter++;
	private final Restaurant36 restaurant;
	private static Random rand = new Random(47);

	public Chef36(Restaurant36 rest) {
		restaurant = rest;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// Blocks until an order appears:
				OrderTicket orderTicket = restaurant.getOrderTicket();
				Food requestedItem = orderTicket.item();
				// Time to prepare order:
				TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
				Plate plate = new Plate(orderTicket, requestedItem);
				orderTicket.getWaitPerson().filledOrders.put(plate);
			}
		} catch (InterruptedException e) {
			System.out.println(this + " interrupted");
		}
		System.out.println(this + " off duty");
	}

	public String toString() {
		return "Chef36 " + id + " ";
	}
}

class Restaurant36 implements Runnable {
	private List<WaitPerson36> waitPersons = new ArrayList<WaitPerson36>();
	private List<Chef36> chefs = new ArrayList<Chef36>();
	public List<Table> tables = new ArrayList<Table>();
	private ExecutorService exec;
	private static Random rand = new Random(47);

	// BlockingQueue<Order> orders = new LinkedBlockingQueue<Order>();

	public OrderTicket getOrderTicket() {
		OrderTicket ticket = null;

		while (ticket == null) {
			for (Table t : tables) {
				if (t.getOrderCount() > 0) {
					ticket = t.orderTicket;
					break;
				}
			}
			if (ticket == null) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return ticket;
	}

	public Table getTable() {
		Table table = null;
		int minSize = Table.CAPACITY;

		while (minSize == Table.CAPACITY) {
			for (Table t : tables) {
				int curSize = t.getCustomerSize();
				if (curSize < minSize) {
					minSize = curSize;
					table = t;
				}
			}

			if (minSize == Table.CAPACITY) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return table;
	}

	public Restaurant36(ExecutorService e, int nWaitPerson36s, int nChef36s,
			int nTables) {
		exec = e;
		for (int i = 0; i < nWaitPerson36s; i++) {
			WaitPerson36 waitPerson = new WaitPerson36(this);
			waitPersons.add(waitPerson);
			exec.execute(waitPerson);
		}
		for (int i = 0; i < nChef36s; i++) {
			Chef36 chef = new Chef36(this);
			chefs.add(chef);
			exec.execute(chef);
		}
		for (int i = 0; i < nTables; i++) {
			Table table = new Table();
			tables.add(table);
		}
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				// A new customer arrives; assign a WaitPerson36:
				WaitPerson36 wp = waitPersons.get(rand.nextInt(waitPersons
						.size()));
				Table table = getTable();
				Customer3 c = new Customer3(wp, table);
				table.addCustomer(c);
				exec.execute(c);
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Restaurant36 interrupted");
		}
		System.out.println("Restaurant36 closing");
	}
}

class Restaurant36WithQueues {
	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		Restaurant36 restaurant = new Restaurant36(exec, 5, 2, 3);
		exec.execute(restaurant);
		if (args.length > 0) // Optional argument
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
		else {
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
}

public class Ex36 {
	public static void main(String[] args) throws Exception {
		Restaurant36WithQueues.main(args);
	}
}
