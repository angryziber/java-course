package net.azib.java.students.t092859.homework.output;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;

/**
 * HTMLResultWriter
 *
 * @author konstantin
 */
public class HTMLResultWriter implements DecathlonResultWriter {

	Writer HTMLOutput;
	
	/**
	 * @param output
	 */
	public HTMLResultWriter(Writer HTMLOutput) {
		this.HTMLOutput = HTMLOutput;
	}
	
	/**
	 * Writes provided results to HTML
	 * First generates XML, then transforms it to HTML
	 * 
	 * @param results - results sorted in order of ascending places
	 * @param places - places corresponding to results
	 */
	@Override
	public void writeResults(List<DecathlonResult> results, List<String> places) {
		System.out.println("Writing HTML..");
		
		Writer xmlWriter = new StringWriter();
		XMLResultWriter XMLgenerator = new XMLResultWriter(xmlWriter);
		
		XMLgenerator.writeResults(results, places);
		Source xmlSource = new StreamSource(new StringReader(xmlWriter.toString()));
		
		StreamSource xslSource = new StreamSource(HTMLResultWriter.class.getResourceAsStream("decathlon.xsl"));
		StreamResult result = new StreamResult(HTMLOutput);
		try {
			Transformer template = TransformerFactory.newInstance().newTransformer(xslSource);
		    template.transform(xmlSource, result);
		}
		catch (TransformerException e) {
			System.err.println("Error occured while tranforming XML to HTML");
		}
		finally {
			IOUtils.closeQuietly(HTMLOutput);
		}
		System.out.println("HTML written successfully");
	}
}
