package net.minixalpha.chap22;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class List16 extends JFrame {
	private String[] flavors = { "Chocolate", "Strawberry",
			"Vanilla Fudge Swirl", "Mint Chip", "Mocha Almond Fudge",
			"Rum Raisin", "Praline Cream", "Mud Pie" };
	private DefaultListModel lItems = new DefaultListModel();
	private JList lst = new JList(flavors);
	private JTextArea t = new JTextArea(flavors.length, 20);
	private JButton b = new JButton("Add Item");
	private ActionListener bl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (count < flavors.length) {
				lItems.add(0, flavors[count++]);
			} else {
				// Disable, since there are no more
				// flavors left to be added to the List
				b.setEnabled(false);
			}
		}
	};
	private ListSelectionListener ll = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			if (e.getValueIsAdjusting())
				return;
			t.setText("");
			for (Object item : lst.getSelectedValues())
				t.append(item + "\n");
		}
	};
	private int count = 0;

	public List16() {
		t.setEditable(false);
		setLayout(new FlowLayout());
		// Create Borders for components:
		Border brd = BorderFactory.createMatteBorder(1, 1, 2, 2, Color.BLACK);
		lst.setBorder(brd);
		t.setBorder(brd);
		// Add the first four items to the List
		add(t);
		add(lst);
		add(b);
		// Register event listeners
		lst.addListSelectionListener(ll);
		b.addActionListener(bl);
	}

	public static void main(String[] args) {
		SwingConsole.run(new List16(), 250, 375);
	}
}

public class Ex16 {
	public static void main(String[] args) {
		List16.main(args);
	}
}
