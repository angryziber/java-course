package net.azib.java.students.t030675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.custommonkey.xmlunit.Validator;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import static org.custommonkey.xmlunit.XMLAssert.*;
/**
 * CountryTest
 *
 * @author t030675
 */
public class CountryTest {

	private String xml;
	private Document xml2;
	
	@Before
	public void readXML() throws IOException, ParserConfigurationException, SAXException{
//		InputStream in = getClass().getResourceAsStream("books.xml");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//		StringBuilder xml = new StringBuilder();
//		String line;
//		while((line = reader.readLine()) != null){
//			xml.append(line).append('\n');
//		}
//		this.xml = xml.toString();
//		reader.close();
		
		//SAXParserFactory.newInstance() SAX parseriga peaaegu samamoodi nagu edasi naidatud:
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		xml2 = db.parse(getClass().getResourceAsStream("books.xml"));
//		NodeList childNodes = xml2.getDocumentElement().getChildNodes();
//		for (int i = 0; i < childNodes.getLength(); i++) {
//			System.out.println(childNodes.item(i));
//		}
	}
	
//	@Test
//	public void testValid() throws Exception {
//		Validator v = new Validator(new InputStreamReader(getClass()));
//		v.useXMLSchema(true);
//		assertXMLValid(xml);
//	}
	
	@Test
	public void testXPath() throws Exception {
		assertXpathExists("//book", xml2);
		assertXpathEvaluatesTo("XQuery Kick Start", "/bookstore/book[author='James Linn']/title", xml2);
	}
	
}
