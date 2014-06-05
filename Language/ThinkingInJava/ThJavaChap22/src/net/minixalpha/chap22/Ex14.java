package net.minixalpha.chap22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TextPane extends JFrame {
	private JButton b = new JButton("Add Text");
	private JTextArea tp = new JTextArea();
	private static Generator sg = new RandomGenerator.String(7);

	public TextPane() {
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 1; i < 10; i++)
					tp.setText(tp.getText() + sg.next() + "\n");
			}
		});
		add(new JScrollPane(tp));
		add(BorderLayout.SOUTH, b);
	}

	public static void main(String[] args) {
		SwingConsole.run(new TextPane(), 475, 425);
	}
}

public class Ex14 {
	public static void main(String[] args) {
		TextPane.main(args);
	}
}
