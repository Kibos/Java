package net.minixalpha.chap22;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JToolTip;

class Ex30Demo extends JFrame {
	private JTabbedPane pane = new JTabbedPane();
	private JMenuItem item = new JMenuItem("<html> <i>Hello");
	private JRadioButton rdBtn = new JRadioButton("<html> <i> Radio");
	private JCheckBox checkBox = new JCheckBox("<html> <i> CheckBox");

	public Ex30Demo() {
		pane.addTab("<html><i>Tab", null);
		add(pane);
		add(item);
		rdBtn.setToolTipText("<html> <i> tips");
		add(rdBtn);
		add(checkBox);
	}
}

public class Ex30 {
	public static void main(String[] args) {
		SwingConsole.run(new Ex30Demo(), 300, 200);
	}
}
