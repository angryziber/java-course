package net.azib.java.students.t010691.homework;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * OutputDataXml
 * 
 * XML output.
 * Competition results are written to XML file.
 *
 * @author Ilja Lutov
 */
class OutputDataXml extends OutputData {

	/**
	 * Constructor
	 * 
	 * Initializes XML DOM
	 * 
	 * @param filePath path to a file that will contain competition results
	 */
	public OutputDataXml (String filePath) {
		
		this.filePath = filePath;
		
		try {
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.newDocument();
			root = document.createElement("competition");
		}
		catch (ParserConfigurationException e) {
			System.out.println("Error: could not create document");
		}
	}
	
	/**
	 * Adds competitor data to XML DOM tree
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#write(net.azib.java.students.t010691.homework.Competitor)
	 */
	public void write(Competitor athlete, String placeInCompetition) {
		String[] data = athlete.toStringArray();

		int element = 0;	// Current data index
		
		Element competitor = document.createElement("competitor");
		
		Element place = document.createElement("place");
		place.setTextContent(placeInCompetition);
		competitor.appendChild(place);
		
		Element score = document.createElement("score");
		score.setTextContent(data[element++]);
		competitor.appendChild(score);
		
		Element name = document.createElement("name");
		name.setTextContent(data[element++]);
		competitor.appendChild(name);
		
		Element birthDate = document.createElement("birth_date");
		birthDate.setTextContent(data[element++]);
		competitor.appendChild(birthDate);
		
		Element countryCode = document.createElement("country_code");
		countryCode.setTextContent(data[element++]);
		competitor.appendChild(countryCode);
		
		Element results = document.createElement("results");

		// Competition results fields are named according to events enumeration descriptions
		for (CompetitionEvent competitioEvent : CompetitionEvent.values()) {
			Element result = document.createElement(competitioEvent.toString().toLowerCase());
			result.setTextContent(data[element++]);
			results.appendChild(result);
		}
		
		competitor.appendChild(results);
		
		root.appendChild(competitor);	
	}

	/**
	 * Writes the whole XML document to a file
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#close()
	 */
	public void close() {
		try {
			document.appendChild(root);
			
			FileOutputStream fileOutputStream = new FileOutputStream(filePath);
			OutputFormat outputFormat = new OutputFormat(document, "UTF-8", true);
			XMLSerializer xmlSerializer = new XMLSerializer(fileOutputStream, outputFormat);
			xmlSerializer.serialize(document);
			fileOutputStream.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: could not create output file: '" + filePath + "'");
		}
		catch (IOException e) {
			System.out.println("Error: unable to write XML document");
		}
		
		System.out.println("\nDone.\n");
	}
	
	/**
	 * Returns XML DOM tree containing all competition data 
	 * 
	 * @return xml document
	 */
	public Document createDocument() {
		document.appendChild(root);
		
		return document;
	}
	
	// XML DOM tree
	private Document document;
	
	// XML document root
	private Element root;
	
	// Path to a file that stores competition results
	private String filePath;
}
