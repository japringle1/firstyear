package uk.ac.sheffield.com1003.guis.draw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class AboutDialog extends JDialog {
	public AboutDialog(JFrame parent) {
		super(parent, "About", true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// set up the about message
		JPanel messagePane = new JPanel();
		messagePane.setLayout(new GridLayout(0, 1));
		JLabel jlabel1 = new JLabel("Draw program");
		jlabel1.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlabel2 = new JLabel("by Phil McMinn");
		jlabel2.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlabel3 = new JLabel(" for the Java programming module ");
		jlabel3.setHorizontalAlignment(JLabel.CENTER);
		JLabel jlabel4 = new JLabel("(c) 2008");
		jlabel4.setHorizontalAlignment(JLabel.CENTER);
		messagePane.add(jlabel1);
		messagePane.add(jlabel2);
		messagePane.add(jlabel3);
		messagePane.add(jlabel4);
		getContentPane().add(messagePane);

		// set up the ok button
		JPanel buttonPane = new JPanel();
		JButton button = new JButton("OK");
		buttonPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		// set size according to contents
		pack();

		// set location to be in the middle of the parent window
		Dimension parentSize = parent.getSize();
		Dimension dialogSize = getSize();
		Point p = parent.getLocation();
		setLocation(p.x + (parentSize.width - dialogSize.width) / 2, p.y
				+ (parentSize.height - dialogSize.height) / 2);

		// display the dialog
		setVisible(true);
	}
}