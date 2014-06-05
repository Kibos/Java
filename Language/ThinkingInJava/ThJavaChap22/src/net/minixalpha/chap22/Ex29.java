package net.minixalpha.chap22;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

class Ex29Demo extends JFrame {
	private JColorChooser colorChooser = new JColorChooser();
	private JButton btn = new JButton("Choose Color");

	public Ex29Demo() {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				colorChooser.showDialog(null, "Color Chooser", Color.RED);
			}
		});
		add(btn);
	}
}

public class Ex29 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex29Demo(), 300, 200);
	}
}
