package net.azib.java.lessons.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMDemo {
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		Document xml = loadDocument("books.xml");
		Element root = xml.getDocumentElement();
		System.out.println(root.getNodeName());

		NodeList books = root.getElementsByTagName("book");
		for (int i = 0; i < books.getLength(); i++) {
			Element book = (Element) books.item(i);
			System.out.println(book.getAttribute("lang") + ": " + book.getElementsByTagName("title").item(0).getTextContent());
		}
	}

	public static Document loadDocument(String filename) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(DOMDemo.class.getResourceAsStream(filename));
	}
}
