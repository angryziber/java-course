package net.azib.java.students.t104607.homework;

import org.apache.log4j.PropertyConfigurator;
import org.custommonkey.xmlunit.Validator;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertTrue;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLUnit.buildTestDocument;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 104607 IASM
 */
public class OutputXmlTest {
	private ByteArrayInputStream inputStream;

	@Before
	public void setUp() throws Exception {
		PropertyConfigurator.configure(OutputXml.class.getResource("log4j.disable.properties"));

		List<Athlete> athletes = new ArrayList<Athlete>();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		athletes.add(new Athlete("I.Murumüts",dateFormat.parse("19.06.1980"),"EE",
				9.58, 8.95, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.0));
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		new OutputXml().save(outputStream, athletes);
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
	}

	@Test
	public void xpathOnActualDocument() throws Exception {
		Document doc = buildTestDocument(new InputSource(inputStream));
		assertXpathEvaluatesTo("3:26.00", "/decathlon/athlete/event[10]/result", doc);
	}

	@Test
	public void validateWithXSD() throws Exception {
		Validator validator = new Validator(new InputStreamReader(inputStream));
		validator.useXMLSchema(true);
		validator.setJAXP12SchemaSource(OutputXml.class.getResourceAsStream("decathlon.xsd"));
		assertTrue(validator.toString(), validator.isValid());
	}

	@Test
	public void validateWithDTD () throws Exception {
		Validator validator = new Validator(new InputStreamReader(inputStream),
				OutputXml.class.getResource("decathlon.dtd").toExternalForm(),"decathlon");
		assertTrue(validator.toString(), validator.isValid());
	}
}
