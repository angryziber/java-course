package net.azib.java.students.t040750.lessons.lesson10;

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
 * @author t040750
 */
public class DOMDemo{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		System.out.println(factory);
		
		DocumentBuilder builder = factory.newDocumentBuilder();
		System.out.println(builder);
		
		InputStream source = DOMDemo.class.getResourceAsStream("books.xml");
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(source);
		
		System.out.println(doc.getDocumentElement().getNodeName());
		
		NodeList books = doc.getDocumentElement().getChildNodes();
		for (int i = 0; i < books.getLength(); i++) {
			Node node = books.item(i);
			if (!(node instanceof Element)) 
				continue;
			
			Element bookNode = (Element) node;
			System.out.println("Book #1: " + bookNode.getAttribute("category"));
		}
	}
}
