package net.minixalpha.chap22;

import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Ex1 {
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("Hello Swing");
		JLabel label = new JLabel("A Label");
		frame.add(label);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setVisible(true);
		TimeUnit.SECONDS.sleep(1);
		label.setText("Hey! This is Different!");
	}
}

// After Comment, window will still disappear, but program will not terminal
