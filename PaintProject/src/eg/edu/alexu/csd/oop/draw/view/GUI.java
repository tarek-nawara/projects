package eg.edu.alexu.csd.oop.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GUI() {
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			throw new RuntimeException(e1);
		}
		this.setTitle("Test");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.add(new DrawShapes(), BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new GUI();
	}

	class DrawShapes extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics graphics) {
			this.setBackground(Color.white);
			super.paint(graphics);
			this.setVisible(true);

			Shape circle = new Circle();
			Map<String, Double> map = new HashMap<>();
			map.put("Radius", 70.0);
			circle.setProperties(map);
			circle.setColor(Color.blue);
			circle.setPosition(new Point(200, 100));
			circle.setFillColor(Color.white);
			circle.draw(graphics);

			Shape rectangle = new Rectangle();
			Map<String, Double> map2 = new HashMap<>();
			map2.put("Width", 70.0);
			map2.put("Height", 40.0);
			rectangle.setProperties(map2);
			rectangle.setPosition(new Point(300, 300));
			rectangle.draw(graphics);

			Shape ellipse = new Ellipse();
			ellipse.setProperties(map2);
			ellipse.setPosition(new Point(100, 200));
			ellipse.draw(graphics);

			Shape square = new Square();
			Map<String, Double> map3 = new HashMap<>();
			map3.put("Length", 40.0);
			square.setProperties(map3);
			square.setColor(Color.RED);
			square.setPosition(new Point(400, 100));
			square.draw(graphics);
			
			Shape circle2 = new Circle();
			try {
				circle2 = (Shape) circle.clone();
			} catch (CloneNotSupportedException e) {
				System.out.println(e);
			}
			circle2.setPosition(new Point(500, 300));
			circle2.setColor(Color.RED);
			circle2.draw(graphics);
		}
	}
}