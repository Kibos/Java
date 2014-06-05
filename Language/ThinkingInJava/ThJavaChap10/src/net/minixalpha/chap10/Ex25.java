package net.minixalpha.chap10;

import net.minixalpha.chap10.GreenhouseControls.Bell;
import net.minixalpha.chap10.GreenhouseControls.FansOff;
import net.minixalpha.chap10.GreenhouseControls.FansOn;
import net.minixalpha.chap10.GreenhouseControls.LightOff;
import net.minixalpha.chap10.GreenhouseControls.LightOn;
import net.minixalpha.chap10.GreenhouseControls.Restart;
import net.minixalpha.chap10.GreenhouseControls.ThermostatDay;
import net.minixalpha.chap10.GreenhouseControls.ThermostatNight;
import net.minixalpha.chap10.GreenhouseControls.WaterOff;
import net.minixalpha.chap10.GreenhouseControls.WaterOn;
import net.minixalpha.chap10.controller.*;

class NewGreenhouseControls extends GreenhouseControls {
	private boolean waterMist = false;

	public class WaterMistOn extends Event {

		public WaterMistOn(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			waterMist = true;
		}

	}

	public class WaterMistOff extends Event {

		public WaterMistOff(long delayTime) {
			super(delayTime);
		}

		@Override
		public void action() {
			waterMist = false;
		}

	}
}

public class Ex25 {
	public static void main(String[] args) {
		NewGreenhouseControls gc = new NewGreenhouseControls();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		gc.addEvent(gc.new Bell(900));
		Event[] eventList = { gc.new ThermostatNight(0), gc.new LightOn(200),
				gc.new LightOff(400), gc.new WaterOn(600),
				gc.new WaterOff(800), gc.new ThermostatDay(1400),
				gc.new FansOn(500), gc.new FansOff(700),
				gc.new WaterMistOn(550), gc.new WaterMistOff(750)};
		gc.addEvent(gc.new Restart(2000, eventList));
		if (args.length == 1)
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		gc.run();
	}
}
