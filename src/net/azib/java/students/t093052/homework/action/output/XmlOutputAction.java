package net.azib.java.students.t093052.homework.action.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.DecathlonComputation;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * This class represents the xml output action.
 * */
public class XmlOutputAction implements OutputAction {
	private static final String SCHEMA_FACTORY = 
		"http://www.w3.org/2001/XMLSchema";
	private static final String XSD_SCHEMA = "athletes.xsd";
	
	private Document document = null;
	private Element rootElement;
	private FileWriter fileWriter;
	
	
	public XmlOutputAction(String filename) throws IOException {
		fileWriter = new FileWriter(new File(filename));
		init();
	}
	
	private void init() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			document = db.newDocument();
			rootElement = document.createElement("athletes");
		} catch (ParserConfigurationException e) {
			System.out.println("Could not create xml.");
			System.exit(1);
		}
	}
	
	@Override
	public void addToOutput(int place, Athlete athlete) throws Exception {
		Element athleteElement = document.createElement("athlete");
		athleteElement.setAttribute("name", athlete.getName());
		athleteElement.setAttribute("dateOfBirth", athlete.getDateOfBirth());
		athleteElement.setAttribute("country", athlete.getCountry());

		Element placeElement = document.createElement("place");
		placeElement.setTextContent(String.valueOf(place));
		athleteElement.appendChild(placeElement);

		Element pointsElement = document.createElement("points");
		pointsElement.setTextContent(String.valueOf(athlete.getPoints()));
		athleteElement.appendChild(pointsElement);

		Element resultsElement = document.createElement("results");
		for (Entry<String, String> entry : athlete.getResults().entrySet()) {
			Element resultElement = document.createElement(
					entry.getKey().toLowerCase());
			resultElement.setTextContent(entry.getValue());
			resultsElement.appendChild(resultElement);
		}
		athleteElement.appendChild(resultsElement);
		
		rootElement.appendChild(athleteElement);
	}

	@Override
	public void finishOutput() throws Exception {
		validateXml(document);
		document.appendChild(rootElement);
		createoutputFile();
	}

	Transformer getTransformer(TransformerFactory tFactory) 
			throws TransformerConfigurationException {
		return tFactory.newTransformer();
	}
	
	private void createoutputFile() {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = getTransformer(tFactory);
			transformer.transform(new DOMSource(document), 
					new StreamResult(fileWriter));
			System.out.println("Output file created successfully");
		} catch (TransformerException e) {
			System.out.println("Could not create output file");
			System.exit(1);
		}
	}
	
	private void validateXml(Document doc) throws IOException {
		SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_FACTORY);

		try {
			Schema schema = factory.newSchema(new StreamSource(
				DecathlonComputation.class.getResourceAsStream(XSD_SCHEMA)));
			Validator validator = schema.newValidator();
			DOMSource source = new DOMSource(doc);
			validator.validate(source);
		} catch (SAXException ex) {
			System.out.println("Xml document is invalid.");
			System.exit(1);
		}
	}
}
