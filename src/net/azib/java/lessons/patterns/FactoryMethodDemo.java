package net.azib.java.lessons.patterns;

import java.text.DateFormat;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/**
 * FactoryMethodDemo
 *
 * @author anton
 */
public class FactoryMethodDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		DateFormat format = DateFormat.getDateInstance();
	}
}
