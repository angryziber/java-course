package net.azib.java.students.t050209;

import static org.custommonkey.xmlunit.XMLAssert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.custommonkey.xmlunit.Validator;
import org.junit.Test;
/**
 * CountryTest
 *
 * @author t050209
 */
public class CountryTest {
	
	private String xml;
	
	public void readXML() throws IOException {
		InputStream in = getClass().getResourceAsStream("country.xml");
		BufferedReader reader = new  BufferedReader(new InputStreamReader(in));
		StringBuilder xml = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			xml.append(line).append("\n");
		}
		this.xml = xml.toString();
		reader.close();
	}
	
	@Test
	public void testValid() throws Exception {
		//Validator v = new Validator(new InputStreamReader(get));
		//v.useXMLSchema(true);
		assertXMLValid(xml);
	}
}
