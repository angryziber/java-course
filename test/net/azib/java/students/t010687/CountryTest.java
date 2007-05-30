package net.azib.java.students.t010687;

import static org.custommonkey.xmlunit.XMLAssert.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;


/**
 * CountryTest
 *
 * @author t010687
 */
public class CountryTest {
	private String xml;
	
	public void setUp() throws IOException{
		InputStream in = getClass().getClassLoader().getResourceAsStream("net/azib/java/lessons/xml/country.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder xml = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null){
			xml.append(line).append('\n');
		}
		this.xml = xml.toString();
		reader.close();
	}
	
	@Test
	public void testValid() throws Exception {
		setUp();
		//assertXMLValid(xml);
		System.out.println(xml);
		assertXpathExists("/country/name='Estonia'", xml);
	}

}
