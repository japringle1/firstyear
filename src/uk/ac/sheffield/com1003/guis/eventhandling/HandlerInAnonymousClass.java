package uk.ac.sheffield.com1003.guis.eventhandling;

import uk.ac.sheffield.com1003.guis.CentredFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HandlerInAnonymousClass extends CentredFrame {

	JButton button;
	String[] labels = { "Click me", "Click me again" };
	int currentLabel = 0;

	public HandlerInAnonymousClass() {

		button = new JButton(labels[0]);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentLabel++;
				if (currentLabel >= labels.length) {
					currentLabel = 0;
				}
				button.setText(labels[currentLabel]);
			}
		});

		setTitle("Handler in anonymous class");
		getContentPane().add(button);
		setVisible(true);
	}

	public static void main(String[] args) {
		new HandlerInAnonymousClass();
	}
}
