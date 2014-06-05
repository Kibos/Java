package net.minixalpha.chap22;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

class Ex11Demo extends JButton {
	private static Random rand = new Random();

	public Ex11Demo() {
		super("RandomColorBtn");
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				float h = rand.nextFloat(), s = rand.nextFloat(), b = rand
						.nextFloat();
				setBackground(Color.getHSBColor(h, s, b));
			}
		});
	}
}

class Ex11DemoFrame extends JFrame {
	public Ex11DemoFrame() {
		add(new Ex11Demo());
	}
}

public class Ex11 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex11DemoFrame(), 300, 200);
	}
}
