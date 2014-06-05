package net.minixalpha.chap22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

class Ex17Demo extends JFrame {
	private JPasswordField pwdField = new JPasswordField(20);

	public Ex17Demo() {
		pwdField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String pwd = new String(pwdField.getPassword());
				String pwdT = "abc";
				if (pwd.equals(pwdT)) {
					JOptionPane.showMessageDialog(null, "Correct");
				}

			}
		});
		add(pwdField);
	}
}

public class Ex17 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex17Demo(), 300, 200);
	}
}
