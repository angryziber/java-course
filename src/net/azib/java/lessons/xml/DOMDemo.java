package net.azib.java.lessons.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DOMDemo
 *
 * @author anton
 */
public class DOMDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		Document doc = createDocument();
		System.out.println("Document: " + doc.getClass());
		
		NodeList books = doc.getElementsByTagName("book");
		for (int i = 0; i < books.getLength(); i++) {
			Element book = (Element) books.item(i);
			System.out.println("Book " + i + ": " + book.getElementsByTagName("title").item(0).getTextContent());
		}
	}

	static Document createDocument() throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(DOMDemo.class.getResource("books.xml").toString());
	}
}
