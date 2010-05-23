package net.azib.java.students.t050724.homework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XMLWriter
 * 
 * @author xom
 */
public class XMLWriter {

	SupportClass supporter = new SupportClass();

	/**
	 * Writes the data of the parameter "athletes" to a .xml file that is
	 * specified by the parameter "path". "athletes.dtd" file is needed to check
	 * the validity of the .xml file data.
	 * 
	 * @param athletes
	 *            ArrayList of Athlete that is to be printed out to console.
	 * @param path
	 *            String representation of the file or path, where to write the
	 *            file.
	 */
	protected void createXML(ArrayList<Athlete> athletes, String path) {

		path = supporter.setFilePath(path);

		try {
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.newDocument();

			document = buildDocument(athletes, document);

			writeXML(document, path);

		}
		catch (Exception e) {
			System.out.println("There are problems with creating the XML file!");
		}

	}

	private Document buildDocument(ArrayList<Athlete> athletesToXML, Document doc) throws Exception {

		Element athletes = doc.createElement("Athletes");
		doc.appendChild(athletes);
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd.MM.yyyy");

		for (Athlete athleteToXML : athletesToXML) {

			Element athlete = doc.createElement("Athlete");
			athletes.appendChild(athlete);

			Element place = doc.createElement("Place");
			athlete.appendChild(place);
			place.appendChild(doc.createTextNode(athleteToXML.getPlace()));

			Element score = doc.createElement("Score");
			athlete.appendChild(score);
			score.appendChild(doc.createTextNode(Integer.toString(athleteToXML.getScore())));

			Element name = doc.createElement("Name");
			athlete.appendChild(name);
			name.appendChild(doc.createTextNode(athleteToXML.getName()));

			Element date = doc.createElement("Date");
			athlete.appendChild(date);
			date.appendChild(doc.createTextNode(simpleDate.format(athleteToXML.getDate())));

			Element country = doc.createElement("Country");
			athlete.appendChild(country);
			country.appendChild(doc.createTextNode(athleteToXML.getCountry()));

			Element resultHm = doc.createElement("Hm");
			athlete.appendChild(resultHm);
			resultHm.appendChild(doc.createTextNode(Double.toString(athleteToXML.getHm())));

			Element resultLongJump = doc.createElement("LongJump");
			athlete.appendChild(resultLongJump);
			resultLongJump.appendChild(doc.createTextNode(Double.toString(athleteToXML.getLongJump())));

			Element resultShotPut = doc.createElement("ShotPut");
			athlete.appendChild(resultShotPut);
			resultShotPut.appendChild(doc.createTextNode(Double.toString(athleteToXML.getShotPut())));

			Element resultHighJump = doc.createElement("HighJump");
			athlete.appendChild(resultHighJump);
			resultHighJump.appendChild(doc.createTextNode(Double.toString(athleteToXML.getHighJump())));

			Element resultFhm = doc.createElement("Fhm");
			athlete.appendChild(resultFhm);
			resultFhm.appendChild(doc.createTextNode(supporter.getAthleteResultWithMins(athleteToXML.getFhm())));

			Element resultHtmHurdles = doc.createElement("HtmHurdles");
			athlete.appendChild(resultHtmHurdles);
			resultHtmHurdles.appendChild(doc.createTextNode(Double.toString(athleteToXML.getHtmHurdles())));

			Element resultDiscusThrow = doc.createElement("DiscusThrow");
			athlete.appendChild(resultDiscusThrow);
			resultDiscusThrow.appendChild(doc.createTextNode(Double.toString(athleteToXML.getDiscusThrow())));

			Element resultPoleVault = doc.createElement("PoleVault");
			athlete.appendChild(resultPoleVault);
			resultPoleVault.appendChild(doc.createTextNode(Double.toString(athleteToXML.getPoleVault())));

			Element resultJavelinThrow = doc.createElement("JavelinThrow");
			athlete.appendChild(resultJavelinThrow);
			resultJavelinThrow.appendChild(doc.createTextNode(Double.toString(athleteToXML.getJavelinThrow())));

			Element resultTfhm = doc.createElement("Tfhm");
			athlete.appendChild(resultTfhm);
			resultTfhm.appendChild(doc.createTextNode(supporter.getAthleteResultWithMins(athleteToXML.getTfhm())));

		}
		return doc;
	}

	private void writeXML(Document documentToWrite, String path) throws Exception {

		DOMSource source = new DOMSource(documentToWrite);
		File file = new File(path);
		StreamResult result = new StreamResult(file);
		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, supporter.setFilePath("athletes.dtd"));

		transformer.transform(source, result);
	}

}
