package net.minixalpha.chap22;

import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex2 {
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Hello Swing");
		JLabel label = new JLabel("A Label");
		frame.add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setVisible(true);

		for (int i = 1; i < 3; i++) {
			TimeUnit.SECONDS.sleep(1);
			label.setText("Hey! This is Different!" + i);
		}
	}
}
