package net.minixalpha.chap22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Ex15Demo extends JFrame {
	private JTextField txt = new JTextField(10);
	private JCheckBox box = new JCheckBox();

	private void addButtonMsg(String btnName, final String msg) {
		JButton btn = new JButton(btnName);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(msg);
			}
		});
		add(btn);
	}

	public Ex15Demo() {
		setLayout(new FlowLayout());
		addButtonMsg("Yes", "hi");
		addButtonMsg("No", "jack");
		addButtonMsg("Cancel", "gui");
		add(txt);

		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txt.setText(e.paramString());
			}
		});
		add(box);
	}
}

public class Ex15 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex15Demo(), 300, 200);
	}
}