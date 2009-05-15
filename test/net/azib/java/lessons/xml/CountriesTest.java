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
public class CountriesTest {
	private Document doc;
	String xmlToVerify = 
		"<countries xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='country.xsd'>"+
		"<country code='EE'>"+
		  "<name>Estonia</name>"+
		  "<population>1350000</population>"+
		  "<phone_code>372</phone_code>"+
		"</country>"+
		"<country code='LV'>"+
		  "<name>Latvia</name>"+
		  "<population>2500000</population>"+
		  "<phone_code>371</phone_code>"+
		"</country>"+
		"</countries>";

	
	@Before
	public void loadXML() throws IOException, SAXException {
		doc = XMLUnit.buildControlDocument(new InputSource(getClass().getResourceAsStream("country.xml")));
		XMLUnit.setIgnoreWhitespace(true);
	}
	
	@Test
	public void correctXMLContent() throws Exception {
		assertXMLEqual(XMLUnit.buildTestDocument(xmlToVerify), doc);
	}

	@Test
	public void countriesShouldBeValidXML() throws Exception {
		String xsdPath = getClass().getResource("country.xsd").getPath();
		
		Validator v = new Validator(xmlToVerify, xsdPath);
		v.useXMLSchema(true);
		assertXMLValid(v);
	}
}
