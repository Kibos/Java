package net.minixalpha.chap22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class Ex7Demo extends JFrame {
	JTextField txt = new JTextField(20);
	JButton btn = new JButton("button");
	JComboBox box = new JComboBox<>();

	public Ex7Demo() {
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText("btn click me");
			}
		});
		add(btn);

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText("combo box click me");

			}
		});
		add(box);

		add(new JScrollPane(txt));
	}
}

public class Ex7 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex7Demo(), 300, 200);
	}
}
