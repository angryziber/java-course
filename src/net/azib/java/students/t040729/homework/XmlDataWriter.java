package net.azib.java.students.t040729.homework;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Competition results to XML file writer
 *
 * @author ValleTon
 */
public class XmlDataWriter implements CompetitionDataOut {
	protected Properties properties;
	protected String fileName;
	
	/**
	 * @param fileName
	 */
	public XmlDataWriter(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void putCompetitionData(List<Athlete> athletes) throws TransformerFactoryConfigurationError, Exception {
		Document doc = getNewDocument();
		Element root = getPreparedRoot(doc);
		
		putAthletesToXmlDoc(athletes, doc, root);
		transformXml(doc);
	}

	private void transformXml(Document doc) throws TransformerFactoryConfigurationError, TransformerException{
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, properties.getProperty("encoding"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.STANDALONE, (doc.getXmlStandalone())?"yes":"no");

		File outFile = new File(fileName);
        Result result = new StreamResult(outFile);
        transformer.transform(new DOMSource(doc), result);
	}

	protected void putAthletesToXmlDoc(List<Athlete> athletes, Document doc, Element root) throws Exception {

		for (Athlete athlete : athletes){
				root.appendChild(getAthleteElement(doc, athlete));
		}
	}

	private Element getAthleteElement(Document doc, Athlete athlete) throws DOMException, Exception {
		Element athleteElement = doc.createElement("athlete");
		Element nameElement = doc.createElement("name");
		Element dobElement = doc.createElement("birthdate");

		athleteElement.setAttribute("place", athlete.getPlace());
		athleteElement.setAttribute("points", String.valueOf(athlete.getTotalPoints()));
		athleteElement.setAttribute("country", athlete.getCountryCode());
		athleteElement.appendChild(nameElement);
		nameElement.appendChild(doc.createTextNode(athlete.getName()));
		athleteElement.appendChild(dobElement);
		
		dobElement.appendChild(doc.createTextNode(athlete.getCustomBirthDate(properties.getProperty("xml_dateformat_string"))));
		if (athlete.getCustomBirthDate(properties.getProperty("xml_dateformat_string")).isEmpty()){
			dobElement.setAttribute("xsi:nil", "true");
		}
		athleteElement.appendChild(getResultsElement(doc, athlete));
		
		return athleteElement;
	}

	protected Element getPreparedRoot(Document doc) {
		Element root = doc.createElement("decathlon"); 
		doc.appendChild(root);
		root.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.setAttribute("xsi:noNamespaceSchemaLocation", "decathlon.xsd");
		return root;
	}

	protected Document getNewDocument() throws ParserConfigurationException {
		DocumentBuilder bd = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = bd.newDocument(); 
		doc.setXmlStandalone(true);
		return doc;
	}
	
	private Element getResultsElement(Document doc, Athlete athlete){

		Element resultsElement = doc.createElement("results");	
		Element resultElement;
		for (Event evt : Event.values()){
			resultElement = doc.createElement(evt.toString().toLowerCase());
			resultElement.appendChild(doc.createTextNode(athlete.getFormattedResult((byte) evt.ordinal())));
			resultsElement.appendChild(resultElement);
		}
		return resultsElement;
	}
	
	@Override
	public void setAppProperties(Properties properties) {
		this.properties = properties;
	}
}
