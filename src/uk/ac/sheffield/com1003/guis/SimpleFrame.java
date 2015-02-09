package uk.ac.sheffield.com1003.guis;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SimpleFrame extends JFrame {

	public SimpleFrame() {
		setTitle("A Simple Frame");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SimpleFrame();
	}
}
