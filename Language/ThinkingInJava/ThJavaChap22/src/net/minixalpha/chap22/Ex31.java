package net.minixalpha.chap22;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

class Ex31Demo extends JFrame {
	private JProgressBar pb = new JProgressBar();
	private int pbMax = pb.getMaximum();

	public Ex31Demo() {
		add(pb);
		final Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				int value = pb.getValue();
				pb.setValue(value + (pbMax - value) / 3);
			}
		};

		timer.scheduleAtFixedRate(task, 0, 1000);
	}
}

public class Ex31 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex31Demo(), 300, 200);

	}
}
