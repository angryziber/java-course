package net.azib.java.students.t092877.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class XMLWriter {


	public static void output(Competition decathlon, File pathname, boolean outputToHtml) {

		Document doc = null;
		List<Athlete> athletes = decathlon.getAthletesList();
		Utils.sortAthletes(athletes);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}

		Element rootEl = doc.createElement("competition");
		rootEl.setAttribute("xsi:noNamespaceSchemaLocation", "decathlon.xsd");
		rootEl.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		doc.appendChild(rootEl);

		Element cnameEl = doc.createElement("name");
		Text cnameText = doc.createTextNode(decathlon.getName());
		cnameEl.appendChild(cnameText);
		rootEl.appendChild(cnameEl);

		Element locationEl = doc.createElement("location");
		Text locationText = doc.createTextNode(decathlon.getLocation());
		locationEl.appendChild(locationText);
		rootEl.appendChild(locationEl);

		Element dateEl = doc.createElement("date");
		Text dateText = doc.createTextNode(decathlon.getDate());
		dateEl.appendChild(dateText);
		rootEl.appendChild(dateEl);

		Element athletesEl = doc.createElement("athletes");
		rootEl.appendChild(athletesEl);

		Iterator<Athlete> iterAthletes = athletes.iterator();
		while (iterAthletes.hasNext()) {
			Athlete athlete = iterAthletes.next();

			Element athleteEl = doc.createElement("athlete");
			athletesEl.appendChild(athleteEl);

			Element anameEl = doc.createElement("name");
			Text anameText = doc.createTextNode(athlete.getName());
			anameEl.appendChild(anameText);
			athleteEl.appendChild(anameEl);

			Element bornEl = doc.createElement("date_of_birth");
			Text bornText = doc.createTextNode(athlete.getDateOfBirth());
			bornEl.appendChild(bornText);
			athleteEl.appendChild(bornEl);

			Element countryEl = doc.createElement("country_code");
			Text countryText = doc.createTextNode(athlete.getCountryCode());
			countryEl.appendChild(countryText);
			athleteEl.appendChild(countryEl);

			Element scoreEl = doc.createElement("score");
			Text scoreText = doc.createTextNode(String.valueOf(athlete.getTotalScore()));
			scoreEl.appendChild(scoreText);
			athleteEl.appendChild(scoreEl);

			Element placeEl = doc.createElement("place");
			Text placeText = doc.createTextNode(athlete.getPlace());
			placeEl.appendChild(placeText);
			athleteEl.appendChild(placeEl);

			Element resultsEl = doc.createElement("results");
			athleteEl.appendChild(resultsEl);

			List<Result> results = athlete.getResults();

			Iterator<Result> iterResults = results.iterator();

			while (iterResults.hasNext()) {

				Result result = iterResults.next();

				Element eventEl = doc.createElement("event");
				eventEl.setAttribute("type", result.getEvent().getType());
				resultsEl.appendChild(eventEl);

				Element eventNameEl = doc.createElement("name");
				Text eventNameText = doc.createTextNode(result.getEvent().getName());
				eventNameEl.appendChild(eventNameText);
				eventEl.appendChild(eventNameEl);

				Element eventResultEl = doc.createElement("result");
				eventEl.appendChild(eventResultEl);

				Element eventResultValueEl = doc.createElement("value");
				Text eventResultValueText = null;

				if (!result.getEvent().getName().equals("1500m") && !result.getEvent().getName().equals("400m")) {

					eventResultValueText = doc.createTextNode(Utils.convertToOriginalUnits(result.getValue(), result.getEvent().getType()));

				} else {

					eventResultValueText = doc.createTextNode(String.valueOf(result.getValue()));


				}

				eventResultValueEl.appendChild(eventResultValueText);
				eventResultEl.appendChild(eventResultValueEl);

				Element eventResultUnitsEl = doc.createElement("units");
				Text eventResultUnitsText = doc.createTextNode(result.getEvent().getUnits());
				eventResultUnitsEl.appendChild(eventResultUnitsText);
				eventResultEl.appendChild(eventResultUnitsEl);
			}
		}

		try {

			OutputFormat format = new OutputFormat(doc);
			format.setIndenting(true);

			XMLSerializer serializer;

			if (outputToHtml)
				serializer = new XMLSerializer(new FileOutputStream("decathlon.xml"), format);
			else
				serializer = new XMLSerializer(new FileOutputStream(pathname), format);

			serializer.serialize(doc);

		} catch(IOException ie) {
		    ie.printStackTrace();
		}

		if (outputToHtml)
			transformToHtml(pathname);
	}

	public static void transformToHtml(File pathname) {

		try {

			    TransformerFactory tf = TransformerFactory.newInstance();
			    Transformer transformer = tf.newTransformer(new javax.xml.transform.stream.StreamSource("decathlon.xsl"));

			    transformer.transform(new javax.xml.transform.stream.StreamSource("decathlon.xml"),
			    					  new javax.xml.transform.stream.StreamResult(new FileOutputStream(pathname)));
		}
		catch (Exception e) {
			e.printStackTrace( );
		}
	}
}

