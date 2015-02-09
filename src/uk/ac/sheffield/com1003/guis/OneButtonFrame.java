package uk.ac.sheffield.com1003.guis;

import java.awt.Container;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class OneButtonFrame extends CentredFrame {

	public OneButtonFrame() {
		setTitle("Centred Frame with a Button");

		// instantiate a button
		JButton button = new JButton("Press me");

		// add it to the JFrame
		Container contentPane = getContentPane();
		contentPane.add(button);
	}

	public static void main(String[] args) {
		OneButtonFrame oneButtonFrame = new OneButtonFrame();
		oneButtonFrame.setVisible(true);
	}
}
