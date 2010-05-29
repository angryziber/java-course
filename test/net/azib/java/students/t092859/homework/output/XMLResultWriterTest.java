package net.azib.java.students.t092859.homework.output;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;

/**
 * XMLResultWriterTest
 *
 * @author konstantin
 */
public class XMLResultWriterTest {
	
	@Test
	public void testWriteResults() throws Exception {
		StringWriter generatedXML = new StringWriter();
		XMLResultWriter uut = new XMLResultWriter(generatedXML);
		
		uut.writeResults(prepareResults(), preparePlaces());
		
		Validator validator = new Validator(generatedXML.toString());
		validator.useXMLSchema(true);
		InputStream schema = XMLResultWriterTest.class.getResourceAsStream("decathlon.xsd");
		validator.setJAXP12SchemaSource(schema);
		XMLAssert.assertXMLValid(validator);
	}

	private List<String> preparePlaces() {
		return Arrays.asList(new String[]{"1"});
	}

	private List<DecathlonResult> prepareResults() {
		List<DecathlonResult> results = new ArrayList<DecathlonResult>();
		
		String[] testInput = new String[]{"Siim Susi",
				"01.01.1976", "EE", "12.61","5.00", "9.22", "1.50", "59.39",
				"16.43", "21.60", "2.60", "35.81","5:25.72"};
		
		results.add(new DecathlonResult(testInput));
		
		return results;
	}

}
