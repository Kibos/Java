package net.minixalpha.chap21;

import java.util.concurrent.*;
import java.util.*;
import static java.util.concurrent.TimeUnit.*;

class DelayedTask implements Runnable, Delayed {
	private static int counter = 0;
	private final int id = counter++;
	protected final int delta;
	private final long trigger;
	protected static List<DelayedTask> sequence = new ArrayList<DelayedTask>();
	protected static DelayQueue<DelayedTask> queue = null;
	protected final boolean repeat;

	public DelayedTask(int delayInMilliseconds, boolean repeat) {
		delta = delayInMilliseconds;
		trigger = System.nanoTime() + NANOSECONDS.convert(delta, MILLISECONDS);
		sequence.add(this);
		this.repeat = repeat;
	}

	public long getDelay(TimeUnit unit) {
		return unit.convert(trigger - System.nanoTime(), NANOSECONDS);
	}

	public int compareTo(Delayed arg) {
		DelayedTask that = (DelayedTask) arg;
		if (trigger < that.trigger)
			return -1;
		if (trigger > that.trigger)
			return 1;
		return 0;
	}

	public String toString() {
		return String.format("[%1$-4d]", delta) + " Task " + id;
	}

	public String summary() {
		return "(" + id + ":" + delta + ")";
	}

	@Override
	public void run() {
	}

}

class GreenhouseScheduler {
	private volatile boolean light = false;
	private volatile boolean water = false;
	private String thermostat = "Day";

	public synchronized String getThermostat() {
		return thermostat;
	}

	public synchronized void setThermostat(String value) {
		thermostat = value;
	}

	ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

	public void schedule(Runnable event, long delay) {
		scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
	}

	public void repeat(Runnable event, long initialDelay, long period) {
		scheduler.scheduleAtFixedRate(event, initialDelay, period,
				TimeUnit.MILLISECONDS);
	}

	class LightOn extends DelayedTask implements Runnable {
		public LightOn(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
		}

		public void run() {
			// Put hardware control code here to
			// physically turn on the light.
			System.out.println("Turning on lights");
			light = true;

			if (repeat) {
				queue.put(new LightOn(delta, repeat));
			}
		}
	}

	class LightOff extends DelayedTask implements Runnable {
		public LightOff(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			// Put hardware control code here to
			// physically turn off the light.
			System.out.println("Turning off lights");
			light = false;

			if (repeat) {
				queue.put(new LightOff(delta, repeat));
			}
		}
	}

	class WaterOn extends DelayedTask implements Runnable {
		public WaterOn(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Turning greenhouse water on");
			water = true;

			if (repeat) {
				queue.put(new WaterOn(delta, repeat));
			}
		}
	}

	class WaterOff extends DelayedTask implements Runnable {
		public WaterOff(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Turning greenhouse water off");
			water = false;

			if (repeat) {
				queue.put(new WaterOff(delta, repeat));
			}
		}
	}

	class ThermostatNight extends DelayedTask implements Runnable {
		public ThermostatNight(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Thermostat to night setting");
			setThermostat("Night");

			if (repeat) {
				queue.put(new ThermostatNight(delta, repeat));
			}
		}
	}

	class ThermostatDay extends DelayedTask implements Runnable {
		public ThermostatDay(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			// Put hardware control code here.
			System.out.println("Thermostat to day setting");
			setThermostat("Day");

			if (repeat) {
				queue.put(new ThermostatDay(delta, repeat));
			}
		}
	}

	class Bell extends DelayedTask implements Runnable {
		public Bell(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			System.out.println("Bing!");

			if (repeat) {
				queue.put(new Bell(delta, repeat));
			}
		}
	}

	class Terminate extends DelayedTask implements Runnable {
		public Terminate(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			System.out.println("Terminating");
			scheduler.shutdownNow();
			// Must start a separate task to do this job,
			// since the scheduler has been shut down:
			new Thread() {
				public void run() {
					for (DataPoint d : data)
						System.out.println(d);
				}
			}.start();

			if (repeat) {
				queue.put(new Terminate(delta, repeat));
			}
		}
	}

	// New feature: data collection
	static class DataPoint {
		final Calendar time;
		final float temperature;
		final float humidity;

		public DataPoint(Calendar d, float temp, float hum) {
			time = d;
			temperature = temp;
			humidity = hum;
		}

		public String toString() {
			return time.getTime()
					+ String.format(" temperature: %1$.1f humidity: %2$.2f",
							temperature, humidity);
		}
	}

	private Calendar lastTime = Calendar.getInstance();
	{ // Adjust date to the half hour
		lastTime.set(Calendar.MINUTE, 30);
		lastTime.set(Calendar.SECOND, 00);
	}
	private float lastTemp = 65.0f;
	private int tempDirection = +1;
	private float lastHumidity = 50.0f;
	private int humidityDirection = +1;
	private Random rand = new Random(47);
	List<DataPoint> data = Collections
			.synchronizedList(new ArrayList<DataPoint>());

	class CollectData extends DelayedTask implements Runnable {
		public CollectData(int delayInMilliseconds, boolean repeat) {
			super(delayInMilliseconds, repeat);
			// TODO Auto-generated constructor stub
		}

		public void run() {
			System.out.println("Collecting data");
			synchronized (GreenhouseScheduler.this) {
				// Pretend the interval is longer than it is:
				lastTime.set(Calendar.MINUTE,
						lastTime.get(Calendar.MINUTE) + 30);
				// One in 5 chances of reversing the direction:
				if (rand.nextInt(5) == 4)
					tempDirection = -tempDirection;
				// Store previous value:
				lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
				if (rand.nextInt(5) == 4)
					humidityDirection = -humidityDirection;
				lastHumidity = lastHumidity + humidityDirection
						* rand.nextFloat();
				// Calendar must be cloned, otherwise all
				// DataPoints hold references to the same lastTime.
				// For a basic object like Calendar, clone() is OK.
				data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp,
						lastHumidity));

				if (repeat) {
					queue.put(new CollectData(delta, repeat));
				}
			}
		}
	}

	class DelayedTaskConsumer implements Runnable {
		private DelayQueue<DelayedTask> q;

		public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
			this.q = q;
		}

		public void run() {
			try {
				while (!Thread.interrupted())
					q.take().run(); // Run task with the current thread
			} catch (InterruptedException e) {
				// Acceptable way to exit
			}
			System.out.println("Finished DelayedTaskConsumer");
		}
	}

	public static void main(String[] args) {
		GreenhouseScheduler gh = new GreenhouseScheduler();
		DelayQueue<DelayedTask> queue = new DelayQueue<>();
		DelayedTask.queue = queue;

		queue.put(gh.new Terminate(5000, false));
		queue.put(gh.new ThermostatDay(2000, true));
		queue.put(gh.new LightOn(200, true));
		queue.put(gh.new LightOff(400, true));
		queue.put(gh.new WaterOn(600, true));
		queue.put(gh.new WaterOff(800, true));
		queue.put(gh.new ThermostatDay(1400, true));
		queue.put(gh.new CollectData(1000, true));

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(gh.new DelayedTaskConsumer(queue));

	}
}

public class Ex33 {
	public static void main(String[] args) {
		GreenhouseScheduler.main(args);
	}
}
