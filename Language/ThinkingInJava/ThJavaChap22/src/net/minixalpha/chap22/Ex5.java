package net.minixalpha.chap22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Ex5Demo extends JFrame {
	final JTextField txt = new JTextField(10);

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

	public Ex5Demo() {
		setLayout(new FlowLayout());
		addButtonMsg("Yes", "hi");
		addButtonMsg("No", "jack");
		addButtonMsg("Cancel", "gui");
		add(txt);
	}
}

public class Ex5 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex5Demo(), 300, 200);
	}
}
