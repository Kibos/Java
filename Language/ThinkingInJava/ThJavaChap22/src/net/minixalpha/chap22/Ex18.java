package net.minixalpha.chap22;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

class MessageBoxes extends JFrame {
	private JTextField txt = new JTextField(15);

	public MessageBoxes() {
		setLayout(new FlowLayout());
		JButton btnAlert = new JButton("Alert");
		btnAlert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "There's a bug on you!",
						"Hey!", JOptionPane.ERROR_MESSAGE);

			}
		});
		add(btnAlert);

		JButton btnYesNo = new JButton("YesNo");
		btnYesNo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "or no", "choose yes",
						JOptionPane.YES_NO_OPTION);

			}
		});
		add(btnYesNo);

		JButton btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Red", "Green" };
				int sel = JOptionPane.showOptionDialog(null, "Choose a Color!",
						"Warning", JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (sel != JOptionPane.CLOSED_OPTION)
					txt.setText("Color Selected: " + options[sel]);

			}
		});
		add(btnColor);

		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String val = JOptionPane
						.showInputDialog("How many fingers do you see?");
				txt.setText(val);

			}
		});
		add(btnInput);

		JButton btn3Value = new JButton("3Value");
		btn3Value.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] selections = { "First", "Second", "Third" };
				Object val = JOptionPane.showInputDialog(null, "Choose one",
						"3Value", JOptionPane.INFORMATION_MESSAGE, null,
						selections, selections[0]);

			}
		});
		add(btn3Value);

		add(txt);
	}

	public static void main(String[] args) {
		SwingConsole.run(new MessageBoxes(), 200, 200);
	}
}

public class Ex18 {
	public static void main(String[] args) {
		MessageBoxes.main(args);
	}
}
