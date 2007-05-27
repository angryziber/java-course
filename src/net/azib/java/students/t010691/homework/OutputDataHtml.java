package net.azib.java.students.t010691.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

/**
 * OutputDataHtml
 * 
 * HTML output.
 * Uses XML transformation to generate HTML document.
 *
 * @author Ilja Lutov
 */
class OutputDataHtml extends OutputData {

	/**
	 * Constructor
	 * 
	 * Creates instance of XML output resource that
	 * serves as actual output of competition data
	 * 
	 * @param filePath path to a file that will contain competition results
	 */
	public OutputDataHtml (String filePath) {
		this.filePath = filePath;
		xmlOutputResource = new OutputDataXml("");
	}
	
	/**
	 * Passes competitor data to XML output
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#write(net.azib.java.students.t010691.homework.Competitor)
	 */
	public void write(Competitor competitor, String place) {
		xmlOutputResource.write(competitor, place);
	}

	/**
	 * Retrieves generated document from XML output resoutrce and
	 * transforms it to HTML format
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#close()
	 */
	public void close() {
		Document xmlDocument = xmlOutputResource.createDocument();
		Source xmlSource = new DOMSource(xmlDocument);
		Source xslSource = new StreamSource(new File("").getAbsolutePath() + "\\src\\net\\azib\\java\\students\\t010691\\homework\\decathlon.xsl");
		
		try {
			BufferedWriter outputFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
			Result transformationResult = new StreamResult(outputFile);
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer(xslSource);
			transformer.transform(xmlSource, transformationResult);
			outputFile.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: could not create output file: '" + filePath + "'");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Error: encoding is not supported");			
		}
		catch (TransformerConfigurationException e) {
			System.out.println("Error: unable to configure XSL transformer");
		}
		catch (TransformerException e) {
			System.out.println("Error: XSL transformation failed");
		}
		catch (IOException e) {
			System.out.println("Error: could not close resource");
		}
		
		System.out.println("\nDone.\n");
	}

	// XML output resource
	OutputDataXml xmlOutputResource;
	
	// Path to a file that will store competition results
	private String filePath;
}
