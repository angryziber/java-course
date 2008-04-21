package net.azib.java.students.t040750.lessons.lesson10;

import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

/**
 * SAXDemo
 *
 * @author t040750
 */
public class SAXDemo {
	public static void main(String[] args) {
		InputStream source = DOMDemo.class.getResourceAsStream("books.xml");
	}
}
