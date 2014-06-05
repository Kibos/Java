package net.minixalpha.chap22;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class Ex10Demo extends JFrame {
	private JButton btn = new JButton("Button");
	private JTextField txt = new JTextField(20);
	private KeyListener keyListener = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			Character c = e.getKeyChar();
			txt.setText(c.toString());
		}
	};

	public Ex10Demo() {
		btn.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				btn.removeKeyListener(keyListener);
			}

			@Override
			public void focusGained(FocusEvent e) {
				btn.addKeyListener(keyListener);
			}
		});
		add(btn);
		add(txt);
	}
}

public class Ex10 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex10Demo(), 300, 200);
	}
}
