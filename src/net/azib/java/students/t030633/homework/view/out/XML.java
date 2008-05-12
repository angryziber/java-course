package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Forms XML and writes it to OutputStream.
 * 
 * @author t030633
 */
public class XML implements Output {

	private OutputStream output = null;
	private String fileName;
	private String filePath;

	public XML() {
	}

	public XML(OutputStream out) {
		this.output = out;
	}

	/**
	 * @param athletes -
	 *            a List of athletes to put in a Document
	 * @return JDOM Document for later generation
	 */
	private Document formDocument(List<Athlete> athletes) {

		Element root = new Element("competition");
		Document doc = new Document(root);

		// User probably expects to see dates in local format (short, because
		// only the birth date matters)
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

		for (Athlete athlete : athletes) {
			Element athleteElement = new Element("athlete");

			athleteElement.addContent(new Element("name").setText(athlete.getName()));
			athleteElement.addContent(new Element("country").setText(athlete.getCountry()));

			athleteElement.addContent(new Element("birthdate").setText(df.format(athlete.getBirthDate())));

			Element resultsElement = new Element("results");
			Map<Event, Double> results = athlete.getResults();
			for (Event event : results.keySet()) {
				Element resultElement = new Element("result");
				resultElement.addContent(new Element("event").setText(event.getName()));
				resultElement.addContent(new Element("performance").setText(String.valueOf(results.get(event))));
				resultsElement.addContent(resultElement);
			}
			athleteElement.addContent(resultsElement);

			athleteElement.addContent(new Element("score").setText(String.valueOf(athlete.getScore())));

			root.addContent(athleteElement);
		}
		return doc;

	}

	public void write(List<Athlete> athletes) throws IOException {

		if (output == null) {
			if (fileName == null)
				throw new IOException("Output file not specified.");
			output = new FileOutputStream(new File(filePath, fileName));
		}

		try {
			// Using JDOM to generate XML
			new XMLOutputter(Format.getPrettyFormat().setIndent("  ").setLineSeparator(System.getProperty("line.separator")))
					.output(formDocument(athletes), output);
		}
		catch (IOException e) {
			throw new IOException("XML Outputter error.");
		}

	}

	public void setParameters(String... param) {
		fileName = param[1]; // Parameter 1 should be a file name
		filePath = param[0]; // Parameter 0 should be file path
	}

}
