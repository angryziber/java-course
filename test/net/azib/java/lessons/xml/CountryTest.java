package net.azib.java.lessons.xml;

import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static net.azib.java.lessons.xml.DOMDemo.loadDocument;
import static org.custommonkey.xmlunit.XMLAssert.*;

public class CountryTest {
	@Test
	public void equality() throws IOException, SAXException {
		assertXMLEqual("<country/>", "  <country></country>  ");
	}

	@Test
	public void xpathQueries() throws IOException, SAXException, XpathException {
	    assertXpathExists("/bookstore/book", "<bookstore><book/></bookstore>");
		assertXpathEvaluatesTo("123", "/bookstore/book[1]/@price", "<bookstore><book price='123'/></bookstore>");
	}

	@Test
	public void xpathOnActualDocument() throws IOException, SAXException, ParserConfigurationException, XpathException {
	    Document doc = loadDocument("country.xml");
		assertXpathsEqual("LV", "/bookstore/books[2]/@code", doc);
	}
}
