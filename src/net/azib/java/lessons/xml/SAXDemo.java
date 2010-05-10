package net.azib.java.lessons.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAXDemo
 *
 * @author anton
 */
public class SAXDemo extends DefaultHandler {
	
	private boolean titleProcessing;
	
	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts)  throws SAXException {
		titleProcessing = "title".equals(qName);
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		titleProcessing = false;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (titleProcessing)
			System.out.println(new String(ch, start, length));
	}

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(SAXDemo.class.getResourceAsStream("books.xml"), new SAXDemo());
	}
}
