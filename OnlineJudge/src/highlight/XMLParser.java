package highlight;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
	public Set<String> parse(String fileName, String tagName) throws Exception {
		File file = new File(fileName);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(file);
		NodeList list = document.getElementsByTagName(tagName);
		
		Set<String> ans = new HashSet<>();
		Node root = list.item(0);
		if (root.getNodeType() == Node.ELEMENT_NODE) {
			Element rootTag = (Element) root;
			
			NodeList keys = rootTag.getChildNodes();
			for (int i = 0; i < keys.getLength(); ++i) {
				Node keyWordNode = keys.item(i);
				if (keyWordNode.getNodeType() == Node.ELEMENT_NODE) {
					Element keyWord = (Element) keyWordNode;
					String value = keyWord.getAttribute("value");
					ans.add(value);
				}
			}
		}
		return ans;
	}
}
