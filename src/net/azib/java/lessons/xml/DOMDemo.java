package net.azib.java.lessons.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DOMDemo
 *
 * @author anton
 */
public class DOMDemo {
	public static void main(String[] args) throws Exception {
		Document doc = loadDocument("books.xml");
		NodeList books = doc.getElementsByTagName("book");
		for (int i = 0; i < books.getLength(); i++) {
			Element book = (Element) books.item(i);
			System.out.println(book.getAttribute("category"));
			NodeList children = book.getChildNodes();
			for (int j = 0; j < children.getLength(); j++) {
				Node node = children.item(j);
				if ("title".equals(node.getNodeName())) 
					System.out.println("Title: " + node.getTextContent());
			}
		}
	}
	
	public static Document loadDocument(String xmlFile) throws Exception {
		InputStream stream = DOMDemo.class.getResourceAsStream(xmlFile);
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(stream);
	}

}
