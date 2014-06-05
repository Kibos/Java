package net.minixalpha.chap22;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ex8 {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setCursor(Cursor.CROSSHAIR_CURSOR);
		SwingConsole.run(f, 300, 200);
	}
}
