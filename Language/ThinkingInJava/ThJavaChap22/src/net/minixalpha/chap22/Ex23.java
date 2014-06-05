package net.minixalpha.chap22;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class CubicDraw extends JPanel {
	private static final int SCALEFACTOR = 200;
	private int cubicSize;
	private int points;
	private double[] sines;
	private int[] pts;

	public CubicDraw() {
		setCubicSize(50);
		setSize(100, 50);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int W = getWidth();
		int H = getHeight();
		int C = cubicSize;

		int[] p0 = { (W - C) / 2, (H - C) / 2 };
		int[] p1 = { (W - C) / 2, (H - C) / 2 + C };
		int[] p2 = { (W - C) / 2 + C, (H - C) / 2 + C };
		int[] p3 = { (W - C) / 2 + C, (H - C) / 2 };

		g.drawLine(p0[0], p0[1], p1[0], p1[1]);
		g.drawLine(p1[0], p1[1], p2[0], p2[1]);
		g.drawLine(p2[0], p2[1], p3[0], p3[1]);
		g.drawLine(p3[0], p3[1], p0[0], p0[1]);
	}

	public void setCubicSize(int cubicSize) {
		this.cubicSize = cubicSize;
		repaint();
	}

}

class CubicWave extends JFrame {
	private CubicDraw sines = new CubicDraw();
	private JSlider adjustCycles = new JSlider(1, 100, 50);
	private JTextField field = new JTextField(50);

	public CubicWave() {
		field.setText("5");

		adjustCycles.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int nCicles = ((JSlider) e.getSource()).getValue();
				sines.setCubicSize(nCicles);
				field.setText(Integer.toString(nCicles));
			}
		});
		add(BorderLayout.SOUTH, adjustCycles);

		field.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int nCircles = 50;
				String strCircles = field.getText();
				if (strCircles.length() > 0) {
					nCircles = Integer.parseInt(strCircles);
				}
				adjustCycles.setValue(nCircles);
				sines.setCubicSize(nCircles);
			}
		});
		add(field);
		add(sines);
	}

	public static void main(String[] args) {
		SwingConsole.run(new CubicWave(), 700, 400);
	}
}

public class Ex23 {
	public static void main(String[] args) {
		CubicWave.main(args);
	}
}
