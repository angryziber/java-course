package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import static junit.framework.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;


/**
 * XMLOutputTest
 *
 * @author romi
 */
public class XMLOutputTest {
	private int errorCode;
	
	private Document parse(URL url) throws DocumentException{
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }
	
	private String xmlToString(Document doc) throws IOException{
		OutputFormat format = OutputFormat.createCompactFormat();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLWriter writer = new XMLWriter( out, format );
        writer.write(doc);
        return out.toString();
	}
	
	@Test
	public void testOutputResultsForEmptyArguments(){
		XMLOutput xmlo = new XMLOutput() {
			@Override
	         public void exit(int errorCode) {
	        	 XMLOutputTest.this.errorCode = errorCode;
	         }
		};
		xmlo.outputResults(null, "asd");
		assertEquals(13,errorCode);
		xmlo.outputResults(new ArrayList<Athlete>(), (String[])null);
		assertEquals(12, errorCode);
		xmlo.outputResults(new ArrayList<Athlete>(), "");
		assertEquals(12, errorCode);
		xmlo.outputResults(new ArrayList<Athlete>());
		assertEquals(12, errorCode);
	}
	
	@Test
	public void testMakeXMLDocumentWithNoAthletes() throws IOException{
		Document doc1 = XMLOutput.makeXMLDocument(new ArrayList<Athlete>());
		Document doc2 = DocumentHelper.createDocument();
        doc2.addElement("decathlon")
        	.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
        	.addAttribute(new QName("xsi:noNamespaceSchemaLocation",Namespace.NO_NAMESPACE), "DecathlonResults.xsd");

        assertEquals(xmlToString(doc1), xmlToString(doc2));	
	}

	@Test
	public void testMakeXMLDocument() throws ParseException, DocumentException, URISyntaxException, IOException{
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1999");
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		Athlete ath = new Athlete("s s", d, "EE", realResults);
		List<Athlete> al = new ArrayList<Athlete>();
		al.add(ath);

		Document doc1 = XMLOutput.makeXMLDocument(al);
		Document doc2 = parse(XMLOutputTest.class.getResource(("test.xml")).toURI().toURL());
		
        assertEquals(xmlToString(doc1), xmlToString(doc2));	
	}
	
	@Test
	public void testOutputResults() throws ParseException, DocumentException, URISyntaxException, IOException{
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1999");
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		Athlete ath = new Athlete("s s", d, "EE", realResults);
		List<Athlete> al = new ArrayList<Athlete>();
		al.add(ath);
		File tmpFile = File.createTempFile("test", ".tmp");
		new XMLOutput(tmpFile).outputResults(al, "nothing");
		File tmpFile2 = new File(XMLOutputTest.class.getResource(("test.xml")).toURI().getPath());
		
        assertEquals(tmpFile.length(), tmpFile2.length());	
	}
}
