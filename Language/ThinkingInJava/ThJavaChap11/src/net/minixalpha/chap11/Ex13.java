
package net.minixalpha.chap11;

import net.minixalpha.chap11.GreenhouseControls.Bell;
import net.minixalpha.chap11.GreenhouseControls.LightOff;
import net.minixalpha.chap11.GreenhouseControls.LightOn;
import net.minixalpha.chap11.GreenhouseControls.Restart;
import net.minixalpha.chap11.GreenhouseControls.ThermostatDay;
import net.minixalpha.chap11.GreenhouseControls.ThermostatNight;
import net.minixalpha.chap11.GreenhouseControls.WaterOff;
import net.minixalpha.chap11.GreenhouseControls.WaterOn;
import net.minixalpha.chap11.controller.Event;

public class Ex13 {

	public static void main(String[] args) {
		 GreenhouseControls gc = new GreenhouseControls();
		    // Instead of hard-wiring, you could parse
		    // configuration information from a text file here:
		    gc.addEvent(gc.new Bell(900));
		    Event[] eventList = {
		      gc.new ThermostatNight(0),
		      gc.new LightOn(200),
		      gc.new LightOff(400),
		      gc.new WaterOn(600),
		      gc.new WaterOff(800),
		      gc.new ThermostatDay(1400)
		    };	
		    gc.addEvent(gc.new Restart(2000, eventList));
		    if(args.length == 1)
		      gc.addEvent(
		        new GreenhouseControls.Terminate(
		          new Integer(args[0])));
		    gc.run();
	}

}
