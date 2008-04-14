package net.azib.java.lessons.xml;

import java.io.InputStream;

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
	
	int index = 1;
	boolean currentElementIsTitle;
	
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		if (name.equals("book")) {
			System.out.println("Book #" + index++ + ": " + attributes.getValue("category"));
		}
		else if (name.equals("title")) {
			currentElementIsTitle = true;
		}
		else {
			currentElementIsTitle = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (currentElementIsTitle) {
			String s = new String(ch, start, length).trim();
			if (s.length() > 0) {
				System.out.println(s);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		InputStream source = DOMDemo.class.getResourceAsStream("books.xml"); 
		SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
		saxParser.parse(source, new SAXDemo());
		source.close();
	}
}
