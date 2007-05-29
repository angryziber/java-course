package net.azib.java.students.t020632;


import static org.custommonkey.xmlunit.XMLAssert.assertXMLValid;
//import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;


/**
 * CountryTest
 *
 * @author t020632
 */
public class CountryTest {
	
	private String xml; 
	
	public void readXML(){
		InputStream in = getClass().getResourceAsStream("book.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder xml = new StringBuilder(); 
		
		String line;
		
		try {
			while((line = reader.readLine()) != null){
				xml.append(line).append('\n');
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		this.xml = xml.toString();
		
		try {
			reader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValid() throws Exception{
		// Validator v = new Validator(new InputStreamReader(get));
		assertXMLValid(xml);
	}
	
	@Test
	public void testPath() throws Exception {
		//(assertXPathEvaluatesTo("XQuery Kick Start", "/bookstore/book[author = 'James Linn']/title", xml);
	}
}
