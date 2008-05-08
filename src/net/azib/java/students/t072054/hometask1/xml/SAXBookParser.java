package net.azib.java.students.t072054.hometask1.xml;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * SAXBookParser
 * 
 * @author t030633
 */
public class SAXBookParser implements XMLParser {

	public Bookstore parse(File file) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		SAXBookHander handler = new SAXBookHander();
		parser.parse(file, handler);
		return handler.getBooks();
	}

}
