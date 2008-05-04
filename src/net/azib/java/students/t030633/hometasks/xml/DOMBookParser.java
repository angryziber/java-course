package net.azib.java.students.t030633.hometasks.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * DOMBookParser
 * 
 * @author t030633
 */
public class DOMBookParser implements XMLParser {

	public Bookstore parse(File file) throws Exception {
		Bookstore bookstore = new Bookstore();
		NodeList nodes = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("book");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element e = (Element) nodes.item(i);
			
			// create new book and set fields
			Book book = new Book();
			book.setCategory(e.getAttribute("category").toUpperCase());
			book.setLang(e.getAttribute("lang"));
			book.setTitle(e.getElementsByTagName("title").item(0).getTextContent());
			book.setYear(e.getElementsByTagName("year").item(0).getTextContent());
			book.setPrice(e.getElementsByTagName("price").item(0).getTextContent());
			NodeList authorNodes = e.getElementsByTagName("author");
			for (int j = 0; j < authorNodes.getLength(); j++) {
				book.addAuthor(authorNodes.item(j).getTextContent());
			}
			
			// add book to bookstore
			bookstore.addBook(book);
		}
		
		return bookstore;
	}

}
