package net.azib.java.lessons.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

import static net.azib.java.lessons.xml.DOMDemo.loadDocument;

public class XMLSerialization {
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, TransformerException {
		Document document = loadDocument("books.xml");

		Transformer serializer = TransformerFactory.newInstance().newTransformer();
		serializer.transform(new DOMSource(document), new StreamResult(System.out));
	}
}
