package net.minixalpha.chap22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.util.regex.*;

class ShowAddListeners extends JFrame {
	private JTextField name = new JTextField(25);
	private JTextArea results = new JTextArea(40, 65);
	private static Pattern addListener = Pattern
			.compile("(add\\w+?Listener\\(.*?\\))");
	private static Pattern qualifier = Pattern.compile("\\w+\\.");

	class NameL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String nm = name.getText().trim();
			if (nm.length() == 0) {
				results.setText("No match");
				return;
			}
			Class<?> kind;
			try {
				kind = Class.forName("javax.swing." + nm);
			} catch (ClassNotFoundException ex) {
				results.setText("No match");
				return;
			}
			Method[] methods = kind.getMethods();
			results.setText("");
			for (Method m : methods) {
				Matcher matcher = addListener.matcher(m.toString());
				if (matcher.find())
					results.append(qualifier.matcher(matcher.group(1))
							.replaceAll("") + "\n");
			}
			Constructor[] ctors = kind.getConstructors();
			System.out.println(ctors);
			for (Constructor ctor : ctors) {
				Matcher matcher = addListener.matcher(ctor.toString());
				if (matcher.find()) {
					results.append(qualifier.matcher(ctor.toString())
							.replaceAll(""));
				}
			}
		}
	}

	public ShowAddListeners() {
		NameL nameListener = new NameL();
		name.addActionListener(nameListener);
		JPanel top = new JPanel();
		top.add(new JLabel("Swing class name (press Enter):"));
		top.add(name);
		add(BorderLayout.NORTH, top);
		add(new JScrollPane(results));
		// Initial data and test:
		name.setText("JTextArea");
		nameListener.actionPerformed(new ActionEvent("", 0, ""));
	}

	public static void main(String[] args) {
		SwingConsole.run(new ShowAddListeners(), 500, 400);
	}
}

public class Ex9 {
	public static void main(String[] args) {
		ShowAddListeners.main(args);
	}
}
