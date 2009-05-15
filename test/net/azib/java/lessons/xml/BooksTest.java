package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.*;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * CountriesTest
 *
 * @author anton
 */
public class BooksTest {
	private Document doc;
	
	@Before
	public void loadXML() throws IOException, SAXException {
		doc = XMLUnit.buildControlDocument(new InputSource(getClass().getResourceAsStream("books.xml")));
		XMLUnit.setIgnoreWhitespace(true);
	}

	@Test
	public void assertThereAreBooksInTheShop() throws Exception {
		assertXpathExists("/bookstore/book", doc);
	}

	@Test
	public void assertGOFBookIsSoldInTheShop() throws Exception {
		assertXpathExists("/bookstore/book[contains(title, 'Design Patterns')]", doc);
	}

	@Test
	public void assertThereAre7BooksInTheShop() throws Exception {
		assertXpathEvaluatesTo("7", "count(/bookstore/book)", doc);
	}
}
