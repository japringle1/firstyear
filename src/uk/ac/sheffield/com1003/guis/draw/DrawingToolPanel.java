package uk.ac.sheffield.com1003.guis.draw;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
class DrawingToolPanel extends JPanel {

	enum DrawingTool {
		NONE, LINE, RECTANGLE, ELLIPSE, FLOOD_FILL;
	}

	private DrawingCanvas drawingCanvas;

	private JRadioButton rectangleRadioButton;
	private JRadioButton ellipseRadioButton;
	private JRadioButton floodFillRadioButton;
	private JRadioButton scribbleRadioButton;
	private JFormattedTextField rectangleWidthTextField;
	private JFormattedTextField rectangleHeightTextField;
	private JFormattedTextField ellipseXRadiusTextField;
	private JFormattedTextField ellipseYRadiusTextField;
	private JButton undoButton;
	private JButton clearButton;

	DrawingToolPanel() {
		// set up radio buttons
		scribbleRadioButton = new JRadioButton("Scribble");
		scribbleRadioButton.setSelected(true);
		rectangleRadioButton = new JRadioButton("Rectangle");
		ellipseRadioButton = new JRadioButton("Ellipse");
		floodFillRadioButton = new JRadioButton("Flood Fill");

		// add radio buttons to a group
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(scribbleRadioButton);
		buttonGroup.add(rectangleRadioButton);
		buttonGroup.add(ellipseRadioButton);
		buttonGroup.add(floodFillRadioButton);

		// instantiate the undo button
		undoButton = new JButton("Undo");
		undoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawingCanvas.undo();
			}
		});

		// instantiate the clear button
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawingCanvas.clear();
			}
		});

		// add rectangle width & height labels
		JLabel rectangleWidthLabel = new JLabel("Width: ");
		rectangleWidthLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel rectangleHeightLabel = new JLabel("Height: ");
		rectangleHeightLabel.setHorizontalAlignment(JLabel.RIGHT);

		// add ellipse width & height labels
		JLabel ellipseXRadiusLabel = new JLabel("X Radius: ");
		ellipseXRadiusLabel.setHorizontalAlignment(JLabel.RIGHT);
		JLabel ellipseYRadiusLabel = new JLabel("Y Radius: ");
		ellipseYRadiusLabel.setHorizontalAlignment(JLabel.RIGHT);

		// set up text fields
		rectangleWidthTextField = new JFormattedTextField();
		rectangleWidthTextField.setValue(new Integer(100));
		rectangleHeightTextField = new JFormattedTextField();
		rectangleHeightTextField.setValue(new Integer(100));

		ellipseXRadiusTextField = new JFormattedTextField();
		ellipseXRadiusTextField.setValue(new Integer(100));
		ellipseYRadiusTextField = new JFormattedTextField();
		ellipseYRadiusTextField.setValue(new Integer(100));

		// instantiate the main tool panel
		JPanel toolPanel = new JPanel(new GridLayout(0, 5));

		// add scribble controls
		toolPanel.add(scribbleRadioButton);
		for (int i = 0; i < 4; i++) {
			toolPanel.add(new JPanel()); // skip rest of row
		}

		// add rectangle controls
		toolPanel.add(rectangleRadioButton);
		toolPanel.add(rectangleWidthLabel);
		toolPanel.add(rectangleWidthTextField);
		toolPanel.add(rectangleHeightLabel);
		toolPanel.add(rectangleHeightTextField);

		// add ellipse controls
		toolPanel.add(ellipseRadioButton);
		toolPanel.add(ellipseXRadiusLabel);
		toolPanel.add(ellipseXRadiusTextField);
		toolPanel.add(ellipseYRadiusLabel);
		toolPanel.add(ellipseYRadiusTextField);

		// add flood fill controls
		toolPanel.add(floodFillRadioButton);
		for (int i = 0; i < 4; i++) {
			toolPanel.add(new JPanel()); // skip rest of row
		}

		// add buttons
		toolPanel.add(new JPanel()); // skip a cell
		toolPanel.add(undoButton);
		toolPanel.add(new JPanel()); // skip a cell
		toolPanel.add(clearButton);

		// 3. finally, add complete panel
		add(toolPanel, BorderLayout.CENTER);
	}

	void setDrawingCanvas(DrawingCanvas drawingCanvas) {
		this.drawingCanvas = drawingCanvas;
	}

	DrawingTool getSelectedOperation() {
		if (scribbleRadioButton.isSelected()) {
			return DrawingTool.LINE;
		} else if (rectangleRadioButton.isSelected()) {
			return DrawingTool.RECTANGLE;
		} else if (ellipseRadioButton.isSelected()) {
			return DrawingTool.ELLIPSE;
		} else if (floodFillRadioButton.isSelected()) {
			return DrawingTool.FLOOD_FILL;
		} else {
			return DrawingTool.NONE;
		}
	}

	int getRectangleWidth() {
		return Integer.parseInt(rectangleWidthTextField.getText());
	}

	int getRectangleHeight() {
		return Integer.parseInt(rectangleHeightTextField.getText());
	}

	int getEllipseXRadius() {
		return Integer.parseInt(ellipseXRadiusTextField.getText());
	}

	int getEllipseYRadius() {
		return Integer.parseInt(ellipseYRadiusTextField.getText());
	}
}
