package net.azib.java.students.t090437.homework;

import net.azib.java.students.t090437.homework.Competitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.SortedSet;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import junit.framework.Assert;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 * CompetitionToXMLTest
 *
 * @author Ronald
 */
public class CompetitionToXMLTest {
	@Test
	public void testIfCreatesValidXML() throws IOException, MyException, ParserConfigurationException, SAXException {
		String testFileContents = "" +
		"\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 \r\n" +
		"\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 \r\n" + 
		"\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 \r\n" +
		"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01 ";

		File testInputFile = File.createTempFile("test", ".csv"); 
		
		Writer writer = new FileWriter(testInputFile);
		writer.write(testFileContents);
		
		writer.close();
		
		CompetitionDataLoader dataLoader = new CompetitionFromCSV(testInputFile.getAbsolutePath());
		
		dataLoader.loadData();		
		SortedSet<Competitor> competitors = dataLoader.getResults();
		PositionCalculator.calcPositions(competitors);
		
		File testOutputFile = File.createTempFile("test", ".xml");
		
		CompetitionResultsProducer producer = new CompetitionToXML(testOutputFile.getAbsolutePath());
		producer.setCompetitionResults(competitors);
		producer.produceResults();
		
	    // parse an XML document into a DOM tree
	    DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    Document document = parser.parse(testOutputFile);

	    // create a SchemaFactory capable of understanding WXS schemas
	    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

	    // load a WXS schema, represented by a Schema instance
	    Source schemaFile = new StreamSource(getClass().getResourceAsStream("results.xsd"));
	    Schema schema = factory.newSchema(schemaFile);

	    // create a Validator instance, which can be used to validate an instance document
	    Validator validator = schema.newValidator();

	    // validate the DOM tree
	    try {
	        validator.validate(new DOMSource(document));
	    } catch (SAXException e) {
	        Assert.assertTrue(false);
	    }
		
	}

}
