package net.azib.java.lessons.xml;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

/**
 * XPathDemo
 *
 * @author anton
 */
public class XPathDemo {
	public static void main(String[] args) throws Exception {
		Document doc = DOMDemo.loadDocument();
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		System.out.println(xpath.evaluate("//book[author = 'Erich Gamma']/title", doc));
	}
}
