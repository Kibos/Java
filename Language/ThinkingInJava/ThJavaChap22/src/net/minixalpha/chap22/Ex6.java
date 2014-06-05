package net.minixalpha.chap22;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Ex6Demo extends JFrame {
	final JTextField txtIn = new JTextField(10);
	final JTextField txtOut = new JTextField(10);
	final JButton btnCheck = new JButton("Check");

	public Ex6Demo() {
		setLayout(new FlowLayout());
		btnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String in = txtIn.getText();
				String out = txtOut.getText();
				Pattern p = Pattern.compile(out);
				Matcher m = p.matcher(in);

				StringBuilder builder = new StringBuilder();
				while (m.find()) {
					builder.append("Match \"" + m.group() + "\" at positions "
							+ m.start() + "-" + (m.end() - 1));
				}
				txtOut.setText(builder.toString());
			}
		});
		add(btnCheck);
		add(txtIn);
		add(txtOut);
	}
}

public class Ex6 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex6Demo(), 300, 200);
	}
}
