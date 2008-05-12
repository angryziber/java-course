package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.Decathlon;

import java.util.List;
import java.util.logging.Logger;

import org.dom4j.Document;

/**
 * CSVOutput
 *
 * @author Romi Agar
 */
public class CSVOutput implements DataOutput{
	private static final Logger LOG = Logger.getLogger(XMLOutput.class.getSimpleName());

	public void outputResults(List<Athlete> results, String... parameter) {

		Document xmlDoc = XMLOutput.makeXMLDocument(results);
		System.out.println(xmlDoc.asXML());
		String xsdPath = Decathlon.class.getResource("xml/DecathlonResults.xsd").getPath();
		if (!XMLOutput.isValidXML(xmlDoc.asXML(), xsdPath)){
			LOG.warning("XML is not valid.");
		}
		String stylesheetPath = Decathlon.class.getResource("xml/csv.xsl").getPath();
		Document transformedDoc = XMLOutput.styleDocument(xmlDoc, stylesheetPath);
		System.out.println(transformedDoc.asXML());
		
	}

}
