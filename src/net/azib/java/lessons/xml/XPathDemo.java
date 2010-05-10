package net.azib.java.lessons.xml;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

/**
 * XPathDemo
 *
 * @author anton
 */
public class XPathDemo {
	public static void main(String[] args) throws Exception {
		Document doc = DOMDemo.loadDocument("books.xml");
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		String title = xpath.evaluate("/bookstore/book[1]/title", doc.getDocumentElement());
		System.out.println(title);
	}
}
