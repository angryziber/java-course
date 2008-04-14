package net.azib.java.students.t980814.lec10;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
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
 * @author t980814
 */
public class DOMDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		System.out.println(factory);
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		System.out.println(builder);
		
		InputStream source = DOMDemo.class.getResourceAsStream("books.xml");
		Document doc = builder.parse(source);
		source.close();
		// Näite jaoks on pikalt kirja pandud, tegelikult saab 3 pika reaga.
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList books = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < books.getLength(); i++) {
			Node node = books.item(i);
			if (!(node instanceof Element))
				continue;
			Element bookNode = (Element)node;
			System.out.println(bookNode.getAttribute("category"));
			System.out.println(bookNode.getElementsByTagName("title").item(0).getTextContent());
		}
			
	}
}
