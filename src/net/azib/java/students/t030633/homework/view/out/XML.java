package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.DecathlonCalculator;
import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

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

	public XML() {
	}

	public XML(OutputStream out) {
		this.output = out;
	}

	private Document formDocument(List<Athlete> athletes) {

		Element root = new Element("competition");
		Document doc = new Document(root);

		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale(System.getProperty("user.country")));

		for (Athlete athlete : athletes) {
			Element athleteElement = new Element("athlete");

			athleteElement.addContent(new Element("name").setText(athlete.getName()));
			athleteElement.addContent(new Element("country").setText(athlete.getCountry()));

			athleteElement.addContent(new Element("birthdate").setText(df.format(athlete.getBirthDate())));

			Element resultsElement = new Element("results");
			for (Event event : athlete.getResults().keySet()) {
				Element resultElement = new Element("result");
				resultElement.addContent(new Element("event").setText(event.getName()));
				resultElement.addContent(new Element("performance").setText(String.valueOf(athlete.getResults().get(event))));
				resultsElement.addContent(resultElement);
			}
			athleteElement.addContent(resultsElement);

			athleteElement.addContent(new Element("score").setText(String.valueOf(athlete.getScore())));

			root.addContent(athleteElement);
		}
		return doc;

	}

	public void write(List<Athlete> athletes) throws IOException {

		if (this.output == null) {
			if (DecathlonCalculator.outputProperty == null)
				throw new IOException("Output file not specified.");
			this.output = new FileOutputStream(new File(DecathlonCalculator.class.getResource(".").getPath(),
					DecathlonCalculator.outputProperty));
		}

		try {
			new XMLOutputter(Format.getRawFormat().setIndent("  ").setLineSeparator(System.getProperty("line.separator")))
					.output(formDocument(athletes), output);
		}
		catch (IOException e) {
			throw new IOException("XML Outputter error.");
		}

	}

}
