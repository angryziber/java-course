package net.azib.java.lessons.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;

import static net.azib.java.lessons.xml.DOMDemo.loadDocument;

public class XSLDemo {
	public static void main(String[] args) throws TransformerException, IOException, SAXException, ParserConfigurationException {
		InputStream xsl = XSLDemo.class.getResourceAsStream("books.xsl");
		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));

		transformer.transform(new DOMSource(loadDocument("books.xml")), new StreamResult(System.out));
	}
}
