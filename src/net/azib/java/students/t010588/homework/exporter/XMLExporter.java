package net.azib.java.students.t010588.homework.exporter;

import net.azib.java.students.t010588.homework.Athlete;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Exports results into XML file
 *
 * @author Vjatseslav Rosin, 010588
 */
public class XMLExporter implements AthleteExporter {

	protected Document document;

	private File file;

	/**
	 * @param xmlFile
	 *            destination to export
	 */
	public XMLExporter(File xmlFile) {
		this.file = xmlFile;
		init();
	}

	/**
	 * Initializing of DOM tree
	 */
	protected void init() {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.newDocument();

			Element root = document.createElement(XMLConstants.NODE_ROOT);
			Attr xsi = document.createAttribute("xmlns:xsi");
			xsi.setNodeValue("http://www.w3.org/2001/XMLSchema-instance");

			Attr schemaLocation = document.createAttribute("xsi:noNamespaceSchemaLocation");
			schemaLocation.setNodeValue("decathlon.xsd");

			root.setAttributeNode(xsi);
			root.setAttributeNode(schemaLocation);

			document.appendChild(root);
		}
		catch (ParserConfigurationException e) {

		}
	}

	public void exportAthletes(List<Athlete> athletes) throws InternalException {
		for (Athlete athlete : athletes) {
			addAthlete(athlete);
		}
		store(file);
	}

	protected boolean store(File file) throws InternalException {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			DOMSource source = new DOMSource(document);

			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
			return true;
		}
		catch (TransformerException e) {
			throw new InternalException(e.getMessage());
		}
	}

	private void addAthlete(Athlete athlete) {
		Node root = document.getDocumentElement();

		Node nodeAthlete = document.createElement(XMLConstants.NODE_ATHLETE);

		for (int i = 0; i < athlete.getResults().length; i++) {
			Node nodeResult = document.createElement(XMLConstants.NODE_RESULT);

			Attr attrIndex = document.createAttribute(XMLConstants.ATTR_INDEX);
			attrIndex.setTextContent(String.valueOf(i + 1));
			nodeResult.getAttributes().setNamedItem(attrIndex);

			Attr attrValue = document.createAttribute(XMLConstants.ATTR_VALUE);
			attrValue.setTextContent(athlete.getResults()[i].toString());
			nodeResult.getAttributes().setNamedItem(attrValue);

			Attr attrPoints = document.createAttribute(XMLConstants.ATTR_POINTS);
			attrPoints.setTextContent(athlete.getResults()[i].getPoints() + "");
			nodeResult.getAttributes().setNamedItem(attrPoints);

			nodeAthlete.appendChild(nodeResult);
		}

		String place = "";
		if (athlete.getFirstPlace() == athlete.getLastPlace())
			place = athlete.getFirstPlace() + "";
		else
			place = athlete.getFirstPlace() + "-" + athlete.getLastPlace();

		Attr attrPlace = document.createAttribute(XMLConstants.ATTR_ATHLETE_PLACE);
		attrPlace.setTextContent(place + "");
		nodeAthlete.getAttributes().setNamedItem(attrPlace);

		Attr attrName = document.createAttribute(XMLConstants.ATTR_ATHLETE_NAME);
		attrName.setTextContent(athlete.getName());
		nodeAthlete.getAttributes().setNamedItem(attrName);

		Attr attrBirthday = document.createAttribute(XMLConstants.ATTR_ATHLETE_BIRTHDAY);
		attrBirthday.setTextContent(DATE_FORMAT.format(athlete.getBirhday()));
		nodeAthlete.getAttributes().setNamedItem(attrBirthday);

		Attr attrCountry = document.createAttribute(XMLConstants.ATTR_ATHLETE_COUNTRY);
		attrCountry.setTextContent(String.valueOf(athlete.getCountry()));
		nodeAthlete.getAttributes().setNamedItem(attrCountry);

		Attr attrScore = document.createAttribute(XMLConstants.ATTR_ATHLETE_SCORE);
		attrScore.setTextContent(athlete.getScore() + "");
		nodeAthlete.getAttributes().setNamedItem(attrScore);

		root.appendChild(nodeAthlete);
	}
}
