package net.azib.java.lessons.xml;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DOMDemo
 *
 * @author anton
 */
public class DOMDemo {
	public static void main(String[] args) throws Exception {
		Document doc = loadDocument();
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList books = doc.getElementsByTagName("book");
		for (int i = 0; i < books.getLength(); i++) {
			Node node = books.item(i);
			
			Element bookNode = (Element) node;
			System.out.println("Book #" + (i+1) + ": " + bookNode.getAttribute("category"));
			Element titleNode = (Element) bookNode.getElementsByTagName("title").item(0);
			System.out.println(titleNode.getTextContent());
		}
	}

	static Document loadDocument() throws SAXException, IOException, ParserConfigurationException {
		InputStream source = DOMDemo.class.getResourceAsStream("books.xml"); 
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(source);
		source.close();
		return doc;
	}
}
