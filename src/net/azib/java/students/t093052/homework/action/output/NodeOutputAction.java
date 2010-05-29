package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.Athlete;
import net.azib.java.students.t093052.homework.CompetitionType;
import net.azib.java.students.t093052.homework.DecathlonComputation;

import java.io.FileOutputStream;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/**
 * This class holds the common methods of xml and html output actions
 * */
public abstract class NodeOutputAction extends AbstractOutputAction {
	private static final String SCHEMA_FACTORY = 
		"http://www.w3.org/2001/XMLSchema";
	private static final String XSD_SCHEMA = "athletes.xsd";
	
	private Document document = null;
	private Element rootElement;
	
	abstract Transformer getTransformer(TransformerFactory tFactory) 
		throws TransformerConfigurationException;
	
	public NodeOutputAction(String filename) throws IOException {
		super(new FileOutputStream(filename));
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
	void append(String placeInterval, Athlete athlete) {
		Element athleteElement = document.createElement("athlete");
		athleteElement.setAttribute("name", athlete.getName());
		athleteElement.setAttribute("dateOfBirth", athlete.getDateOfBirthAsString());
		athleteElement.setAttribute("country", athlete.getCountry());

		addElement(athleteElement, "place", placeInterval);
		addElement(athleteElement, "points", String.valueOf(athlete.getPoints()));

		Element resultsElement = document.createElement("results");
		for (Entry<CompetitionType, String> entry : athlete.getResults().entrySet()) {
			addElement(resultsElement, entry.getKey().getName().toLowerCase(), 
					entry.getValue());
		}
		athleteElement.appendChild(resultsElement);
		
		rootElement.appendChild(athleteElement);
	}
	
	private void addElement(Element parent, String name, String value) {
		Element element = document.createElement(name);
		element.setTextContent(value);
		parent.appendChild(element);
	}

	@Override
	public void finishOutput() throws IOException {
		validateXml(document);
		document.appendChild(rootElement);
		createoutputFile();
		super.finishOutput();
	}
	
	private void createoutputFile() {
		TransformerFactory tFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = getTransformer(tFactory);
			transformer.transform(new DOMSource(document), 
					new StreamResult(getWriter()));
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
