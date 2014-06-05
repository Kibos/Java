package net.minixalpha.chap22;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;
import java.util.*;

class CBox extends JPanel implements Runnable {
	private int pause;
	private static Random rand = new Random();
	private Color color = new Color(0);
	private boolean blink = false;

	public void paintComponent(Graphics g) {
		g.setColor(color);
		Dimension s = getSize();
		g.fillRect(0, 0, s.width, s.height);
	}

	public CBox(int pause) {
		this.pause = pause;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				if (blink == false) {
					TimeUnit.MILLISECONDS.sleep(pause);
					color = new Color(rand.nextInt(0xFFFFFF));
					repaint(); // Asynchronously request a paint()
					TimeUnit.MILLISECONDS.sleep(200);

					blink = true;
					color = new Color(0);
					repaint();
				}

			}
		} catch (InterruptedException e) {
			// Acceptable way to exit
		}
	}
}

class ColorBoxes extends JFrame {
	private int grid = 12;
	private int pause = 200;
	private static ExecutorService exec = Executors.newCachedThreadPool();

	public void setUp() {
		setLayout(new GridLayout(grid, grid));
		for (int i = 0; i < grid * grid; i++) {
			CBox cb = new CBox(pause);
			pause += 200;
			add(cb);
			exec.execute(cb);

			if (i % grid == 0) {
				pause = 200;
			}
		}
	}

	public static void main(String[] args) {
		ColorBoxes boxes = new ColorBoxes();
		if (args.length > 0)
			boxes.grid = new Integer(args[0]);
		if (args.length > 1)
			boxes.pause = new Integer(args[1]);
		boxes.setUp();
		SwingConsole.run(boxes, 200, 400);
	}
}

public class Ex34 {
	public static void main(String[] args) {
		ColorBoxes.main(args);
	}
}
