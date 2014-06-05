package net.minixalpha.chap22;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

class SineDraw extends JPanel {
	private static final int SCALEFACTOR = 200;
	private int cycles;
	private int points;
	private double[] sines;
	private int[] pts;

	public SineDraw() {
		setCycles(5);
		setSize(300, 300);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int maxWidth = getWidth();
		double hstep = (double) maxWidth / (double) points;
		int maxHeight = getHeight();
		pts = new int[points];
		for (int i = 0; i < points; i++)
			pts[i] = (int) (sines[i] * maxHeight / 2 * .95 + maxHeight / 2);
		g.setColor(Color.RED);
		for (int i = 1; i < points; i++) {
			int x1 = (int) ((i - 1) * hstep);
			int x2 = (int) (i * hstep);
			int y1 = pts[i - 1];
			int y2 = pts[i];
			g.drawLine(x1, y1, x2, y2);
		}
	}

	public void setCycles(int newCycles) {
		cycles = newCycles;
		points = SCALEFACTOR * cycles * 2;
		sines = new double[points];
		for (int i = 0; i < points; i++) {
			double radians = (Math.PI / SCALEFACTOR) * i;
			sines[i] = Math.sin(radians);
		}
		repaint();
	}

}

class SineWave extends JFrame {
	private SineDraw sines = new SineDraw();
	private JSlider adjustCycles = new JSlider(1, 30, 5);
	private JTextField field = new JTextField(30);

	public SineWave() {
		field.setText("5");
		add(sines);
		adjustCycles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int nCicles = ((JSlider) e.getSource()).getValue();
				sines.setCycles(nCicles);
				field.setText(Integer.toString(nCicles));
			}
		});
		add(BorderLayout.SOUTH, adjustCycles);

		field.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int nCircles = 1;
				String strCircles = field.getText();
				if (strCircles.length() > 0) {
					nCircles = Integer.parseInt(strCircles);
				}
				adjustCycles.setValue(nCircles);
				sines.setCycles(nCircles);
			}
		});
		add(field);
	}

	public static void main(String[] args) {
		SwingConsole.run(new SineWave(), 700, 400);
	}
}

public class Ex21 {
	public static void main(String[] args) {
		SineWave.main(args);
	}
}
