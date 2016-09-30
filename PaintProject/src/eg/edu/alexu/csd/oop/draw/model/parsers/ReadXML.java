package eg.edu.alexu.csd.oop.draw;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
	public Shape[] xmlLoad(String fileName) throws Exception {
		File xmlFile = new File(fileName);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFile);
		ArrayList<Shape> listOfShapes = new ArrayList<>();
		NodeList list = document.getElementsByTagName("canvas");

		Node node = list.item(0);

		if (node.getNodeType() == Node.ELEMENT_NODE) {

			Element canvas = (Element) node;
			NodeList shapes = canvas.getChildNodes();

			for (int i = 0; i < shapes.getLength(); i++) {

				Node n = shapes.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) n;
					Shape shape = (Shape) Class.forName(
							element.getAttribute("class")).newInstance();

					Map<String, Double> map;
					Map<String, Double> propertyMap = new HashMap<>();
					map = shape.getProperties();

					for (Map.Entry<String, Double> entry : map.entrySet()) {
						propertyMap.put(entry.getKey(), entry.getValue());
					}

					for (Map.Entry<String, Double> entry : map.entrySet()) {
						String key = entry.getKey();
						Double value = Double.parseDouble(element
								.getAttribute(key));
						propertyMap.put(key, value);
					}

					int xPosition = Integer.parseInt(element.getAttribute("x"));
					int yPosition = Integer.parseInt(element.getAttribute("y"));
					shape.setPosition(new Point(xPosition, yPosition));

					Color color = new Color(Integer.parseInt(element
							.getAttribute("color")));
					Color fillColor = new Color(Integer.parseInt(element
							.getAttribute("fillColor")));

					shape.setColor(color);
					shape.setFillColor(fillColor);

					shape.setProperties(propertyMap);

					listOfShapes.add(shape);
				}

			}
		}
		Shape[] ans = new Shape[listOfShapes.size()];
		for (int i = 0; i < listOfShapes.size(); i++) {
			ans[i] = listOfShapes.get(i);
		}
		return ans;
	}
}
