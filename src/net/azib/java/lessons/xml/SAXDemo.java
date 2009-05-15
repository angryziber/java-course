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
	
	private boolean parsingTitle; 
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing started");
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		parsingTitle = name.equals("title");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (parsingTitle) {
			String title = new String(ch, start, length);
			if (!title.trim().isEmpty())
				System.out.println("Book: " + title);
		}
	}

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		parser.parse(DOMDemo.class.getResource("books.xml").toString(), new SAXDemo());
	}
}
