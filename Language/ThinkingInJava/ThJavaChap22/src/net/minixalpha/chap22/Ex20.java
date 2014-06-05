package net.minixalpha.chap22;

import java.awt.MenuBar;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

class Ex20Demo extends JFrame {
	JMenuBar menuBar = new JMenuBar();

	public Ex20Demo() {
		try {
			Scanner in = new Scanner(new File("Menus.txt"));
			while (in.hasNext()) {
				String[] words = in.nextLine().trim().split(" ");
				JMenu menu = new JMenu(words[0]);

				for (int i = 1; i < words.length; i++) {
					JMenuItem item = new JMenuItem(words[i]);
					menu.add(item);
				}

				menuBar.add(menu);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		setJMenuBar(menuBar);
	}
}

public class Ex20 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex20Demo(), 300, 200);
	}
}
