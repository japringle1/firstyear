package uk.ac.sheffield.com1003.guis.eventhandling;

import uk.ac.sheffield.com1003.guis.CentredFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HandlerInNonStaticMemberClass extends CentredFrame {

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			currentLabel++;
			if (currentLabel >= labels.length) {
				currentLabel = 0;
			}
			button.setText(labels[currentLabel]);
		}
	}

	JButton button;
	String[] labels = { "Click me", "Click me again" };
	int currentLabel = 0;

	public HandlerInNonStaticMemberClass() {

		button = new JButton(labels[0]);
		button.addActionListener(new ButtonHandler());

		setTitle("Handler in non-static member class");
		getContentPane().add(button);
		setVisible(true);
	}

	public static void main(String[] args) {
		new HandlerInNonStaticMemberClass();
	}
}
