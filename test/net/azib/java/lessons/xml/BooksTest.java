package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * CountryTest
 *
 * @author anton
 */
public class BooksTest {
	
	private Document xml;
	
	@Before
	public void readXML() throws IOException, ParserConfigurationException, SAXException {
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		xml = db.parse(getClass().getResourceAsStream("books.xml"));
	}

	@Test
	public void testXPath() throws Exception {
		assertXpathExists("//book", xml);
		assertXpathEvaluatesTo("XQuery Kick Start", "/bookstore/book[author='James Linn']/title", xml);
		assertXpathEvaluatesTo("Erik T. Ray", "/bookstore/book[year &lt; 2005 and price &lt; 40]/author", xml);
	}
}
