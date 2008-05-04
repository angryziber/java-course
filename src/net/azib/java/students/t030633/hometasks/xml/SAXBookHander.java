package net.azib.java.students.t030633.hometasks.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * SAXBookHander
 * 
 * @author t030633
 */
public class SAXBookHander extends DefaultHandler {

	private Bookstore bookstore;
	private Book book; // current book under parsing
	private String name; // current element name

	public SAXBookHander() {
		bookstore = new Bookstore();
	}

	public Bookstore getBooks() {
		return bookstore;
	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		this.name = name;
		if (name.equals("book")) {
			book = new Book();
			book.setCategory(attributes.getValue("category"));
			book.setLang(attributes.getValue("lang"));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("book")) {
			bookstore.addBook(book);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String trim = new String(ch, start, length).trim();

		if (trim.length() > 0) {
			if (name.compareTo("title") == 0) {
				book.setTitle(trim);
			}
			else if (name.compareTo("author") == 0) {
				book.addAuthor(trim);
			}
			else if (name.compareTo("year") == 0) {
				book.setYear(trim);
			}
			else if (name.compareTo("price") == 0) {
				book.setPrice(trim);
			}
		}

	}

}
