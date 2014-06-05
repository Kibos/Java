package net.minixalpha.chap22;

import java.util.concurrent.TimeUnit;

import javax.swing.*;

class SubmitSwingProgram extends JFrame {
	JLabel label;

	public SubmitSwingProgram() {
		super("Hello Swing");
		label = new JLabel("A Label");
		add(label);
	}

	static SubmitSwingProgram ssp;

	public static void main(String[] args) throws Exception {
		ssp = new SubmitSwingProgram();
		SwingConsole.run(new SubmitSwingProgram(), 300, 100);

		TimeUnit.SECONDS.sleep(1);

		// Does not work 
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ssp.label.setText("Hey! This is Different!");
			}
		});
	}
}

public class Ex3 {
	public static void main(String[] args) throws Exception {
		SubmitSwingProgram.main(args);
	}
}
