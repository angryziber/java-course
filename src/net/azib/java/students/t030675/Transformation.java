package net.azib.java.students.t030675;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Transformation
 *
 * @author t030675
 */
public class Transformation {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, XPathExpressionException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xml = db.parse(Transformation.class.getResourceAsStream("books.xml"));
		
		Transformer t = TransformerFactory.newInstance().newTransformer();
//		Transformer t = TransformerFactory.newInstance().newTransformer();
		t.transform(new DOMSource(xml), new StreamResult(System.out));
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		System.out.println(xpath.evaluate("//book/title", xml));
	}
}
