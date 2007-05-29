package net.azib.java.students.t030630.homework;

import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * a class that generates XML and HTML files based on personal information and
 * results of athletes at competition
 * 
 * @author Anton, Sergei
 */
public class XMLHTMLGenerator {

	/**
	 * generates XML or HTML file
	 * 
	 * @param fileName
	 *            .xml or .html file name
	 * @param athletes
	 *            list of athletes and their results
	 */
	public XMLHTMLGenerator(String fileName, Collection<Athlete> athletes) {

		if (fileName.contains(".html")) {
			String xmlFileName = fileName.substring(0, fileName.indexOf(".")) + ".xml";
			generateXML(new File(xmlFileName), athletes);
			generateHTML(new File(xmlFileName), XMLHTMLGenerator.class.getResourceAsStream("competition.xsl"), new File(fileName));
		}
		else
			generateXML(new File(fileName), athletes);
	}

	/**
	 * generates XML file
	 * 
	 * @param xmlFile
	 *            .xml file name
	 * @param athletes
	 *            list of athletes and their results
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 */
	private void generateXML(File xmlFile, Collection<Athlete> athletes) throws TransformerFactoryConfigurationError {
		Document doc = null;
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = builder.newDocument();
		}
		catch (ParserConfigurationException e1) {
			System.err.println("Parser Configuration exception while building newDocument");
		}
		Element comp = doc.createElement("competition");
		doc.appendChild(comp);

		int man = 0;// id of athlete
		for (Athlete athlete : athletes) {

			Element athl = doc.createElement("athlete");
			athl.setAttribute("id", String.valueOf(++man));
			comp.appendChild(athl);

			Element athlName = doc.createElement("athleteName");
			athlName.appendChild(doc.createTextNode(String.valueOf(athlete.getName())));
			athl.appendChild(athlName);

			Element athlDate = doc.createElement("dateOfBirth");
			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			athlDate.appendChild(doc.createTextNode(String.valueOf(df.format(athlete.getDateOfBirth()))));
			athl.appendChild(athlDate);

			Element athlCountry = doc.createElement("country");
			athlCountry.appendChild(doc.createTextNode(athlete.getCountry()));
			athl.appendChild(athlCountry);

			/* Points */
			Element athlPoints = doc.createElement("points");
			athlPoints.appendChild(doc.createTextNode(String.valueOf(athlete.getPoints())));
			athl.appendChild(athlPoints);

			/* Place */
			Element athlPlace = doc.createElement("place");
			athlPlace.appendChild(doc.createTextNode(athlete.getPlace()));
			athl.appendChild(athlPlace);

			Element events = doc.createElement("events");
			athl.appendChild(events);

			/* 1. 100m sprint */
			Element eventSprint = doc.createElement("event");
			eventSprint.setAttribute("name", "100 m sprint");
			events.appendChild(eventSprint);

			Element resultSprint = doc.createElement("result");
			resultSprint.appendChild(doc.createTextNode(String.valueOf(athlete.getSec100mSprint()) + " sec"));
			eventSprint.appendChild(resultSprint);

			/* 2. Long Jump */
			Element eventLongJump = doc.createElement("event");
			eventLongJump.setAttribute("name", "Long Jump");
			events.appendChild(eventLongJump);

			Element resultLongJump = doc.createElement("result");
			resultLongJump.appendChild(doc.createTextNode(String.valueOf(athlete.getMLongJump()) + " m"));
			eventLongJump.appendChild(resultLongJump);

			/* 3. Shot Put */
			Element eventShotPut = doc.createElement("event");
			eventShotPut.setAttribute("name", "Shot Put");
			events.appendChild(eventShotPut);

			Element resultShotPut = doc.createElement("result");
			resultShotPut.appendChild(doc.createTextNode(String.valueOf(athlete.getMShotPut()) + " m"));
			eventShotPut.appendChild(resultShotPut);

			/* 4. High Jump */
			Element eventHighJump = doc.createElement("event");
			eventHighJump.setAttribute("name", "High Jump");
			events.appendChild(eventHighJump);

			Element resultHighJump = doc.createElement("result");
			resultHighJump.appendChild(doc.createTextNode(String.valueOf(athlete.getMHighJump()) + " m"));
			eventHighJump.appendChild(resultHighJump);

			/* 5. 400m Sprint */
			Element eventLongSprint = doc.createElement("event");
			eventLongSprint.setAttribute("name", "400m Sprint");
			events.appendChild(eventLongSprint);

			Element resultLongSprint = doc.createElement("result");
			resultLongSprint.appendChild(doc.createTextNode(String.valueOf(athlete.getMinSec400mSprint().getInsec()) + " sec"));
			eventLongSprint.appendChild(resultLongSprint);

			/* 6. 110m Hurdles */
			Element eventHurdles = doc.createElement("event");
			eventHurdles.setAttribute("name", "110m Hurdles");
			events.appendChild(eventHurdles);

			Element resultHurdles = doc.createElement("result");
			resultHurdles.appendChild(doc.createTextNode(String.valueOf(athlete.getSec110mHurdles()) + " sec"));
			eventHurdles.appendChild(resultHurdles);

			/* 7. Discus Throw */
			Element eventDiscus = doc.createElement("event");
			eventDiscus.setAttribute("name", "Discus Throw");
			events.appendChild(eventDiscus);

			Element resultDiscus = doc.createElement("result");
			resultDiscus.appendChild(doc.createTextNode(String.valueOf(athlete.getMDiscusThrow()) + " m"));
			eventDiscus.appendChild(resultDiscus);

			/* 8. Pole Vault */
			Element eventPole = doc.createElement("event");
			eventPole.setAttribute("name", "Pole Vault");
			events.appendChild(eventPole);

			Element resultPole = doc.createElement("result");
			resultPole.appendChild(doc.createTextNode(String.valueOf(athlete.getMPoleVault()) + " m"));
			eventPole.appendChild(resultPole);

			/* 9. Javelin Throw */
			Element eventJavelin = doc.createElement("event");
			eventJavelin.setAttribute("name", "Javelin Throw");
			events.appendChild(eventJavelin);

			Element resultJavelin = doc.createElement("result");
			resultJavelin.appendChild(doc.createTextNode(String.valueOf(athlete.getMJavelinthrow()) + " m"));
			eventJavelin.appendChild(resultJavelin);

			/* 10. 1500m race */
			Element eventRace = doc.createElement("event");
			eventRace.setAttribute("name", "1500m race");
			events.appendChild(eventRace);

			Element resultRace = doc.createElement("result");
			resultRace.appendChild(doc.createTextNode(String.valueOf(athlete.getMinSec1500mRace().getInsec()) + " sec"));
			eventRace.appendChild(resultRace);

		}
		try { // writing to file
			Result xmlResultStream = new StreamResult(xmlFile);
			Source source = new DOMSource(doc);
			Transformer xmlFormer = TransformerFactory.newInstance().newTransformer();
			xmlFormer.setOutputProperty(OutputKeys.INDENT, "yes");
			xmlFormer.transform(source, xmlResultStream);
		}
		catch (TransformerConfigurationException e) {
			System.err.println("XML file generation failed");
		}
		catch (TransformerException e) {
			System.err.println("XML file transformation failed");
		}

		System.out.println("XML file generated!");
	}

	/**
	 * generates HTML file based on XML file using appropriate style of
	 * sheet(.xsl file)
	 * 
	 * @param xmlFile
	 *            xml. file name
	 * @param xsltFile
	 *            .xslt file name
	 * @param htmlFile
	 *            html. file name
	 * @throws TransformerException
	 */
	public void generateHTML(File xmlFile, InputStream xslFile, File htmlFile) {
		try {
			Result htmlResultStream = new StreamResult(htmlFile);
			Source xmlSource = new StreamSource(xmlFile);
			Source xsltSource = new StreamSource(xslFile);
			Transformer htmlFormer = TransformerFactory.newInstance().newTransformer(xsltSource);
			htmlFormer.transform(xmlSource, htmlResultStream);
		}
		catch (TransformerException e) {
			System.err.println("Error while transforming XML file to HTML file");
		}
		System.out.println("HTML file generated!");
	}

}
