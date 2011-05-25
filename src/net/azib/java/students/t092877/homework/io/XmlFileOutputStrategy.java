package net.azib.java.students.t092877.homework.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

import net.azib.java.students.t092877.homework.util.Utils;
import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.model.Competition;
import net.azib.java.students.t092877.homework.model.Result;
import org.apache.commons.io.FileUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;


/**
 * XmlFileOutputStrategy.java
 * Purpose: provides implementation for xml-file output
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class XmlFileOutputStrategy implements Strategy {

	private File filepath;
	private boolean htmlTransform;

	/**
	 * Creates a new XmlFileOutputStrategy instance from File pathname and boolean flag htmlTransform.
	 *
	 * @param filepath the specified file pathname
	 * @param htmlTransform a flag for HTML-transformation
	 */
	public XmlFileOutputStrategy(File filepath, boolean htmlTransform) {

		this.filepath = filepath;
		this.htmlTransform = htmlTransform;
	}


	/**
	 * Executes the implementation for xml-file output.
	 *
	 * @param competition an instance of decathlon competition
	 */
	@Override
	public void execute(Competition competition) {

		Document doc = null;
		List<Athlete> athletes = competition.getAthletesList();

		if (athletes == null) {

			System.err.println("\n>>> ERROR: output to file terminated...");
			System.err.println("The input file provided has invalid format or empty.");
			System.exit(1);
		}

		Utils.sortAthletes(athletes);

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();

		} catch (ParserConfigurationException e) {
			System.err.println(">>> ERROR: unable to configure parser");
			e.printStackTrace();
			System.exit(1);
		}

		File xmlFilepath;

		if (htmlTransform) {

			xmlFilepath = new File(filepath.getAbsolutePath().replaceAll("\\.\\w{3,4}", ".xml"));
		} else
			xmlFilepath = filepath;

		buildDocumentObjectModel(competition, doc);
		serializeDocumentObjectModel(xmlFilepath, doc);
		copyAdditionalFiles(getPathname(filepath), htmlTransform);

		if (htmlTransform){

			transformToHtmlFormat(xmlFilepath);
			xmlFilepath.delete();
		}

		System.out.printf("\nThe file with results for decathlon competition %s was saved to %s\n",
					competition, filepath);
	}


	/**
	 * Builds a document object model.
	 *
	 * @param comp an instance of decathlon competition
	 * @param doc an instance of document object model
	 */
	private void buildDocumentObjectModel(Competition comp, Document doc) {

		// DOM Magic
		Element rootEl = doc.createElement("competition");
		rootEl.setAttribute("xsi:noNamespaceSchemaLocation", "schema.xsd");
		rootEl.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		doc.appendChild(rootEl);

		Element cnameEl = doc.createElement("name");
		Text cnameText = doc.createTextNode(comp.getName());
		cnameEl.appendChild(cnameText);
		rootEl.appendChild(cnameEl);

		Element locationEl = doc.createElement("location");
		Text locationText = doc.createTextNode(comp.getLocation());
		locationEl.appendChild(locationText);
		rootEl.appendChild(locationEl);

		Element dateEl = doc.createElement("date");
		Text dateText = doc.createTextNode(comp.getDate());
		dateEl.appendChild(dateText);
		rootEl.appendChild(dateEl);

		Element athletesEl = doc.createElement("athletes");
		rootEl.appendChild(athletesEl);

		Iterator<Athlete> iterAthletes = comp.getAthletesList().iterator();

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
				Text eventResultUnitsText = null;

				if (!result.getEvent().getName().equals("1500m") && !result.getEvent().getName().equals("400m")) {
					eventResultUnitsText = doc.createTextNode(result.getEvent().getUnits());
				} else {
					eventResultUnitsText = doc.createTextNode("seconds");
				}

				eventResultUnitsEl.appendChild(eventResultUnitsText);
				eventResultEl.appendChild(eventResultUnitsEl);
			}
		}
	}


	/**
	 * Copies such files as schemas and stylesheets to output-file destination directory.
	 *
	 * @param pathname the absolute path to destination directory, excluding the file name
	 * @param htmlTransform a flag for HTML-transformation
	 */
	private void copyAdditionalFiles(String pathname, Boolean htmlTransform) {

		String filename;

		if (htmlTransform)
			filename = "stylesheet.css";
		else
			filename = "schema.xsd";

		InputStream instream = XmlFileOutputStrategy.class.getResourceAsStream(filename);

		try {
			FileUtils.copyInputStreamToFile(instream, new File(pathname + filename));
		} catch (IOException e) {
			System.err.println("\n>>> ERROR: unable to copy file");
			e.printStackTrace();
			System.exit(1);
		}
	}

	/**
	 * Returns an absolute path to destination directory, excluding the file name.
	 *
	 * @param filepath the full pathname to destination directory
	 * @returna an absolute path to destination directory without a file name
	 */
	private String getPathname(File filepath) {

		return filepath.getAbsolutePath().replaceAll("\\w*\\.[\\w]{3,4}", "");
	}

	/**
	 * Serializes document object model to file.
	 *
	 * @param filename the output file pathname
	 * @param doc an instance of document object model
	 */
	private void serializeDocumentObjectModel(File filename, Document doc) {

		try {

			OutputFormat format = new OutputFormat(doc);
			format.setIndenting(true);

			XMLSerializer serializer;
			serializer = new XMLSerializer(new FileOutputStream(filename), format);
			serializer.serialize(doc);

		} catch(IOException e) {
			System.err.println("\n>>> ERROR: serialization operation unsuccessful");
		    e.printStackTrace();
		    System.exit(1);
		}
	}

	/**
	 * Transforms xml-file with specified xsl-stylesheet to html format.
	 *
	 * @param xml xml-file pathname
	 */
	private void transformToHtmlFormat(File xml) {

		try {

			    TransformerFactory tf = TransformerFactory.newInstance();
			    Transformer transformer = tf.newTransformer(new javax.xml.transform.stream.StreamSource
			    		             (XmlFileOutputStrategy.class.getResourceAsStream("stylesheet.xsl")));

			    transformer.transform(new javax.xml.transform.stream.StreamSource(xml),
			    					  new javax.xml.transform.stream.StreamResult(new OutputStreamWriter
			    							                              (new FileOutputStream(filepath), "utf-8")));

		} catch (TransformerException e) {
			System.err.println("\n>>> ERROR: transformer configuration failed");
			e.printStackTrace( );
			System.exit(1);
		} catch (UnsupportedEncodingException e) {
			System.err.println("\n>>> ERROR: unsupported encoding");
			e.printStackTrace();
			System.exit(1);
		} catch (FileNotFoundException e) {
			System.err.println("\n>>> ERROR: file not found");
			e.printStackTrace();
			System.exit(1);
		}
	}
}
