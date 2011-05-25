package net.azib.java.students.t092855.homework;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Decathlon XML output. <br>
 *     For outputting decathlon data to XML file.
 *
 * @author t092855
 */
public class OutputXML implements OutputStrategy {

	/**
	 *  Writes decathlon data to XML file.
	 * @param competition data
	 * @param args output XML file name or path
	 */
	@Override
	public void writeOutput(Competition competition, String... args) {

		if (competition.getCompetitors().isEmpty())
			return;

		Document documentXML;

		try {
			documentXML = createDecathlonXML(competition);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", 4);
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(documentXML);
			Result result = new StreamResult(new OutputStreamWriter(new FileOutputStream(args[0]),"UTF-8"));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
		} catch (Exception e) {
			System.out.println(Error.ERROR_XML_CREATION_FAILED.getErrorText());
		}
	}

	Document createDecathlonXML(Competition competition) throws ParserConfigurationException {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
 		documentBuilderFactory.setNamespaceAware(true);

		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document decathlonDocument = documentBuilder.newDocument();

		Element decathlonCompetition = decathlonDocument.createElement("decathlonCompetition");
		decathlonDocument.appendChild(decathlonCompetition);

		Node pi = decathlonDocument.createProcessingInstruction
					("xml-stylesheet", "type=\"text/xsl\" href=\"decathlon.xsl\"");
        decathlonDocument.insertBefore(pi, decathlonCompetition);

		Iterator<Athlete> iterator = competition.getCompetitors().iterator();
		do {
			Athlete athlete = iterator.next();
			if (athlete != null) {
				decathlonCompetition.appendChild(formatAthleteForXML(decathlonDocument,
						competition.getAthletePlace(athlete),
						athlete));
			}
		}  while (iterator.hasNext());

		return decathlonDocument;
	}

	private Element formatAthleteForXML(Document dDoc, String athletePlace, Athlete athlete) {
		Element elementAthlete = dDoc.createElement("athlete");

		Element rank = dDoc.createElement("rank");
		rank.appendChild(dDoc.createTextNode(athletePlace));
		elementAthlete.appendChild(rank);

		Element totalPoints = dDoc.createElement("totalPoints");
		totalPoints.appendChild(dDoc.createTextNode(String.valueOf(athlete.getAthleteEvents().getTotalPoints())));
		elementAthlete.appendChild(totalPoints);

		Element athleteName = dDoc.createElement("name");
		athleteName.appendChild(dDoc.createTextNode(athlete.getName()));
		elementAthlete.appendChild(athleteName);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Element athleteBirthday = dDoc.createElement("birthday");
		athleteBirthday.appendChild(dDoc.createTextNode(dateFormat.format(athlete.getBirthday())));
		elementAthlete.appendChild(athleteBirthday);

		Element country = dDoc.createElement("country");
		country.appendChild(dDoc.createTextNode(athlete.getCountry()));
		elementAthlete.appendChild(country);

		Element results = dDoc.createElement("results");

		String[] eventNames = {"race100m", "longJump", "shotPut",
				"highJump", "race400m", "hurdles110m", "discusThrow",
				"poleVault", "javelinThrow","race1500m"};
		for(int i = 0; i < eventNames.length; i++) {
			Element event = dDoc.createElement(eventNames[i]);
			event.appendChild(dDoc.createTextNode(String.valueOf(athlete.getAthleteEvents().getDecathlonResults()[i])));
			results.appendChild(event);
		}
		elementAthlete.appendChild(results);

		return elementAthlete;
	}
}
