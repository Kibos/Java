package net.minixalpha.chap22;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;

class Progress extends JFrame {
	private JProgressBar pb = new JProgressBar();
	private ProgressMonitor pm = new ProgressMonitor(this,
			"Monitoring Progress", "Test", 0, 100);
	private JSlider sb = new JSlider(JSlider.HORIZONTAL, 0, 100, 60);

	public Progress() {
		setLayout(new GridLayout(2, 1));
		add(pb);
		pm.setProgress(0);
		pm.setMillisToPopup(1000);
		sb.setValue(0);
		sb.setPaintTicks(true);
		sb.setMajorTickSpacing(20);
		sb.setMinorTickSpacing(5);
		sb.setBorder(new TitledBorder("Slide Me"));
		add(sb);
		sb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				pm.setProgress(sb.getValue());
				pb.setValue(sb.getValue());
			}
		});
	}

	public static void main(String[] args) {
		SwingConsole.run(new Progress(), 300, 200);
	}
}

public class Ex32 {
	public static void main(String[] args) {
		Progress.main(args);
	}

}
