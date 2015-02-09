package uk.ac.sheffield.com1003.guis.draw;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JPanel;
import java.util.ArrayList;

import uk.ac.sheffield.com1003.guis.draw.graphicoperation.EllipseOperation;
import uk.ac.sheffield.com1003.guis.draw.graphicoperation.FloodFillOperation;
import uk.ac.sheffield.com1003.guis.draw.graphicoperation.GraphicOperation;
import uk.ac.sheffield.com1003.guis.draw.graphicoperation.LineOperation;
import uk.ac.sheffield.com1003.guis.draw.graphicoperation.RectangleOperation;

@SuppressWarnings("serial")
class DrawingCanvas extends JPanel {

	class DrawingCanvasMouseAdapter extends MouseAdapter {
		private int lastX, lastY;
		private boolean startedDragging = false;

		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			DrawingToolPanel.DrawingTool selectedOperation = drawingToolPanel
					.getSelectedOperation();

			if (selectedOperation == DrawingToolPanel.DrawingTool.RECTANGLE) {
				int width = drawingToolPanel.getRectangleWidth();
				int height = drawingToolPanel.getRectangleHeight();
				RectangleOperation rectangleOperation = new RectangleOperation(
						x, y, width, height);
				DrawingCanvas.this.addGraphicOperation(rectangleOperation);

			} else if (selectedOperation == DrawingToolPanel.DrawingTool.ELLIPSE) {
				int x2 = drawingToolPanel.getEllipseXRadius();
				int y2 = drawingToolPanel.getEllipseYRadius();
				EllipseOperation ellipseOperation = new EllipseOperation(x, y,
						x2, y2);
				DrawingCanvas.this.addGraphicOperation(ellipseOperation);

			} else if (selectedOperation == DrawingToolPanel.DrawingTool.FLOOD_FILL) {
				FloodFillOperation floodFillOperation = new FloodFillOperation(
						x, y);
				DrawingCanvas.this.addGraphicOperation(floodFillOperation);
			}
		}

		public void mouseDragged(MouseEvent e) {
			DrawingToolPanel.DrawingTool selectedOperation = drawingToolPanel
					.getSelectedOperation();
			int x = e.getX();
			int y = e.getY();

			if (selectedOperation == DrawingToolPanel.DrawingTool.LINE) {
				if (startedDragging) {
					LineOperation lineOperation = new LineOperation(lastX,
							lastY, x, y);
					DrawingCanvas.this.addGraphicOperation(lineOperation);
				}
				startedDragging = true;
				lastX = x;
				lastY = y;
			}
		}

		public void mouseReleased(MouseEvent e) {
			startedDragging = false;
		}
	}

	private DrawingToolPanel drawingToolPanel;
	private Color backgroundColour;
	private ArrayList<GraphicOperation> graphicOperations;

	DrawingCanvas() {
		backgroundColour = Color.WHITE;
		graphicOperations = new ArrayList<GraphicOperation>();
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		DrawingCanvasMouseAdapter drawingCanvasMouselistener = new DrawingCanvasMouseAdapter();
		addMouseListener(drawingCanvasMouselistener);
		addMouseMotionListener(drawingCanvasMouselistener);
	}

	void setDrawingToolPanel(DrawingToolPanel drawingToolPanel) {
		this.drawingToolPanel = drawingToolPanel;
	}

	public void paintComponent(Graphics graphics) {

		super.paintComponent(graphics);

		Dimension s = this.getSize();
		BufferedImage image = new BufferedImage(s.width, s.height,
				BufferedImage.TYPE_INT_RGB);

		Graphics imageGraphics = image.getGraphics();
		imageGraphics.setColor(backgroundColour);
		imageGraphics.fillRect(0, 0, s.width, s.height);

		for (GraphicOperation d : graphicOperations) {
			d.draw(imageGraphics, image);
		}

		graphics.drawImage(image, 0, 0, null);
	}

	void addGraphicOperation(GraphicOperation graphicOperation) {
		graphicOperations.add(graphicOperation);
		repaint();
	}

	void clear() {
		graphicOperations.clear();
		repaint();
	}

	void undo() {
		if (graphicOperations.size() > 0) {
			graphicOperations.remove(graphicOperations.size() - 1);
			repaint();
		}
	}

	@SuppressWarnings("unchecked")
	void load(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			ArrayList<GraphicOperation> graphicOperations = (ArrayList<GraphicOperation>) ois
					.readObject();
			setGraphicOperations(graphicOperations);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			fis.close();
		}
	}

	void save(File file) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ArrayList<GraphicOperation> graphicOperations = getGraphicOperations();
		oos.writeObject(graphicOperations);
		fos.close();
	}

	ArrayList<GraphicOperation> getGraphicOperations() {
		return graphicOperations;
	}

	void setGraphicOperations(ArrayList<GraphicOperation> graphicOperations) {
		this.graphicOperations = graphicOperations;
		repaint();
	}

}
