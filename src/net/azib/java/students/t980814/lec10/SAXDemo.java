package net.azib.java.students.t980814.lec10;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * SAXDemo
 *
 * @author t980814
 */
public class SAXDemo extends DefaultHandler {

	int index;
/*	
	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) {
		if (name.equals("book")) {
			System.out.println("Book #" + index++ + ": " + attributes.);
		}
		else if (name.equals("title")) {
			currentElementIsTitle = true;
		}
		else {
			currentElementIsTitle = false;
		}
	}
*/	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		InputStream source = SAXDemo.class.getResourceAsStream("books.xml");
		SAXParserFactory.newInstance().newSAXParser().parse(source, new SAXDemo());
		source.close();
	}
}
