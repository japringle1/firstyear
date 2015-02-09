package uk.ac.sheffield.com1003.guis.draw;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class Draw extends JFrame {

	private DrawingToolPanel drawingToolPanel;
	private DrawingCanvas drawingCanvas;

	public Draw() {
		// set to exit on frame closure
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set the title
		setTitle("Drawing program");

		// set the frame's contents - canvas and tool panel
		setupFrameContents();

		// set up the menu
		setupMenu();

		// set position
		positionFrame();

		// show the frame
		setVisible(true);
	}

	private void positionFrame() {
		// use a toolkit to get system dependent info
		Toolkit tk = Toolkit.getDefaultToolkit();

		// Dimension encapsulates width and height
		Dimension dim = tk.getScreenSize();

		// same width:height ratio as screen and 1/4 the area
		setSize(dim.width / 2, dim.height / 2);

		// centre window on screen
		setLocation(new Point(dim.width / 4, dim.height / 4));
	}

	private void setupFrameContents() {
		drawingCanvas = new DrawingCanvas();
		drawingToolPanel = new DrawingToolPanel();

		drawingCanvas.setDrawingToolPanel(drawingToolPanel);
		drawingToolPanel.setDrawingCanvas(drawingCanvas);

		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		pane.add(drawingCanvas, BorderLayout.CENTER);
		pane.add(drawingToolPanel, BorderLayout.SOUTH);
	}

	private void setupMenu() {
		// initialise menu bar
		JMenuBar menuBar = new JMenuBar();

		// file menu
		JMenu fileMenu = new JMenu("File");

		JMenuItem openMenuItem = new JMenuItem("Open File...");
		openMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser("Load");
				chooser.showOpenDialog(Draw.this);
				try {
					File file = chooser.getSelectedFile();
					drawingCanvas.load(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		fileMenu.add(openMenuItem);

		JMenuItem saveMenuItem = new JMenuItem("Save As...");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser("Save As...");
				chooser.showSaveDialog(Draw.this);
				try {
					File file = chooser.getSelectedFile();
					drawingCanvas.save(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		fileMenu.add(saveMenuItem);

		menuBar.add(fileMenu);

		// help menu
		JMenu helpMenu = new JMenu("Help");

		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutDialog(Draw.this);
			}
		});
		helpMenu.add(aboutMenuItem);

		menuBar.add(helpMenu);

		setJMenuBar(menuBar);
	}

	public static void main(String[] args) {
		new Draw();
	}
}
