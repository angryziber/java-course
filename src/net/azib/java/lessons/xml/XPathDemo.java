package net.azib.java.lessons.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

import static net.azib.java.lessons.xml.DOMDemo.loadDocument;

public class XPathDemo {
	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
		Document xml = loadDocument("books.xml");

		XPath xpath = XPathFactory.newInstance().newXPath();
		System.out.println(xpath.evaluate("/bookstore/book[1]/title", xml));

		System.out.println(xpath.evaluate("/bookstore/book", xml, XPathConstants.NODESET));
	}

}
