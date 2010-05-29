package net.azib.java.students.t092859.homework.output;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * XMLResultWriter
 *
 * @author konstantin
 */
public class XMLResultWriter implements DecathlonResultWriter {

	Writer XMLOutput;
	
	/**
	 * @param XMLOutput
	 */
	public XMLResultWriter(Writer XMLOutput) {
		this.XMLOutput = XMLOutput;
	}
	
	/**
	 * Writes provided results to XML
	 * 
	 * @param results - results sorted in order of ascending places
	 * @param places - places corresponding to results
	 */
	@Override
	public void writeResults(List<DecathlonResult> results, List<String> places) {
		String[] summaryAttributeNames = {"score ", "name", "dateofbirth", "country",
				"100M Sprint", "Long Jump", "Shot Put", "High Jump", 
				"400M Sprint", "110M Hurdles", "Discus Throw", "Pole Vault",
				"Javelin Throw", "1500M Race"};
		System.out.println("Writing XML..");
		
		Element root = new Element("decathlonresults");
		Namespace xsi = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.addNamespaceDeclaration(xsi);
		root.setAttribute("noNamespaceSchemaLocation", "decathlon.xsd", xsi);
		
		
		for(int i = 0; i < results.size(); i++)
		{
			DecathlonResult result = results.get(i);
			List<String> resultSummary = result.getSummary();
			
			Element resultElem = new Element("result");
			resultElem.addContent(new Element("place").addContent(places.get(i)));
			resultElem.addContent(new Element("score").addContent(resultSummary.get(0)));
			
			Element athleteElem = new Element("athlete");
			Element performanceElem = new Element("performance");
			
			for(int j = 1; j < 4; j++)
				athleteElem.addContent(new Element(summaryAttributeNames[j]).addContent(resultSummary.get(j)));
			for(int j = 4; j < 14; j++){
				Element event = new Element("event").setAttribute("name", summaryAttributeNames[j]);
				event.addContent(resultSummary.get(j));
				performanceElem.addContent(event);
			}
			resultElem.addContent(athleteElem);
			resultElem.addContent(performanceElem);
			
			root.addContent(resultElem);
		}
		
		XMLOutputter outputter = new XMLOutputter(Format.getPrettyFormat());
		try {
			outputter.output(new Document(root), XMLOutput);
			System.out.println("XML written successfully");
		}
		catch (IOException e) {
			System.err.println("Error accessing XML file for writing");
		}
		IOUtils.closeQuietly(XMLOutput);
	}

}
