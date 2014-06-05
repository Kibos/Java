package net.minixalpha.chap22;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Ex22Demo extends JPanel {

	public Ex22Demo() {

	}
}

public class Ex22 extends JFrame {
	private JPanel panel = new Ex22Demo();
	private JSlider sliderR = new JSlider(1, 255, 1);
	private JSlider sliderG = new JSlider(1, 255, 1);
	private JSlider sliderB = new JSlider(1, 255, 1);
	private JSlider[] sliders = { sliderR, sliderG, sliderB };
	private JTextField fieldRGB = new JTextField(30);

	ChangeListener rgbListener = new ChangeListener() {

		@Override
		public void stateChanged(ChangeEvent e) {
			int rValue = sliderR.getValue();
			int gValue = sliderG.getValue();
			int bValue = sliderB.getValue();
			fieldRGB.setText(rValue + " " + gValue + " " + bValue);
			panel.setBackground(new Color(rValue, gValue, bValue));
			panel.repaint();
		}
	};

	public Ex22() {
		add(panel);
		fieldRGB.setEditable(false);
		add(fieldRGB);
		for (JSlider slider : sliders) {
			slider.addChangeListener(rgbListener);
			add(slider);
		}
	}

	public static void main(String[] args) {
		SwingConsole.run(new Ex22(), 300, 200);
	}
}
