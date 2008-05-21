package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // XSD date format
		DateFormat ldf = DateFormat.getDateInstance(); // Local date format

		int placeHigh = 1;
		int placeLow = 1;
		int placeCounter = 1;
		int lastHighScore = Integer.MAX_VALUE;

		for (int i = 0; i < athletes.size(); i++) {

			Athlete athlete = athletes.get(i);
			Element athleteElement = new Element("athlete");

			// place calculation
			int score = athlete.getScore();
			if (score != lastHighScore) {
				placeHigh = placeCounter;
				lastHighScore = score;
			}

			placeLow = placeCounter;

			for (int j = 1; (i + j) < athletes.size(); j++) {
				if (score == athletes.get(i + j).getScore())
					placeLow++;
				else
					break;
			}

			placeCounter++;

			athleteElement.addContent(new Element("place").setText(formPlaceText(placeHigh, placeLow)));

			athleteElement.addContent(new Element("name").setText(athlete.getName()));
			athleteElement.addContent(new Element("country").setText(athlete.getCountry()));

			Date birthdate = athlete.getBirthDate();
			athleteElement.addContent(new Element("birthdate").setText(df.format(birthdate)).setAttribute("local",
					ldf.format(birthdate)));

			Element resultsElement = new Element("results");
			Map<Event, Double> results = athlete.getResults();
			for (Event event : results.keySet()) {
				Element resultElement = new Element("result");
				resultElement.addContent(new Element("event").setText(event.getName()));
				double performance = results.get(event);
				StringBuilder perfBuilder = new StringBuilder();
				if (performance > 60.0D)
					perfBuilder.append((int) Math.floor(performance / 60)).append(":");
				double remainder = ((double) Math.round((performance % 60) * 100)) / 100;
				if (remainder < 10D)
					perfBuilder.append("0");
				perfBuilder.append(String.format(Locale.US, "%.2f", remainder));
				resultElement.addContent(new Element("performance").setText(perfBuilder.toString()));
				resultsElement.addContent(resultElement);
			}
			athleteElement.addContent(resultsElement);

			athleteElement.addContent(new Element("score").setText(String.valueOf(score)));

			root.addContent(athleteElement);
		}
		return doc;

	}

	private String formPlaceText(int high, int low) {
		if (high == low)
			return String.valueOf(high);
		else
			return String.valueOf(high) + "-" + String.valueOf(low);
	}

	public void write(List<Athlete> athletes) throws IOException {

		if (output == null) {
			if (fileName == null)
				throw new IOException("Output file not specified.");
			output = new FileOutputStream(new File(fileName));
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
		fileName = param[0]; // Parameter should be a file name
	}

}
