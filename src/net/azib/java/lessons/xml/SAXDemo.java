package net.azib.java.lessons.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXDemo extends DefaultHandler {
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName);
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended");
	}

	public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(DOMDemo.class.getResourceAsStream("books.xml"), new SAXDemo());
	}
}
