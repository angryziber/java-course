package net.azib.java.students.t103800.homework.decathlon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import net.azib.java.students.t103800.homework.decathlon.argument.Argument;
import net.azib.java.students.t103800.homework.decathlon.argument.ArgumentException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class is used to export data in different ways. This class uses the singleton pattern.
 * It is possible to export data to the console, to a csv, html and xml file,
 *
 * @see Argument
 * @see Athlete
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class Exporter {

	private static final String XSL_FOR_HTML = "formats/HTMLFormat.xsl";
	private static final String DTD_FOR_XML = "formats/XMLFormat.dtd";

	private static Exporter dataExporter = null;

	private Exporter() {}

	/**
	 * Obtain a reference to the exporter singleton.
	 * @return exporter.
	 */
	public static Exporter getExporter() {
		if(dataExporter == null) dataExporter = new Exporter();
		return dataExporter;
	}

	/**
	 * Exports data about athletes from an array that consists of athlete objects. Creates a high score table.
	 * @param athletes athletes that have taken part in the competition.
	 * @param outputArgument argument that determines the way the data should be exported.
	 * @throws ArgumentException throws when the argument method cannot be used or when the parameter is illegal.
	 * @throws ExporterException throws when something went wrong while exporting data for example some kind of IOError.
	 */
	public void exportAthletes(Athlete[] athletes, Argument outputArgument) throws ArgumentException, ExporterException {
		switch(outputArgument.getMethod()) {
		case CONSOLE:
			exportToConsole(athletes, new PrintStream(System.out));
			break;
		case CSV:
			exportAsCSV(athletes, newFileOutputStream(outputArgument.getParameter()));
			break;
		case XML:
			exportAsXML(athletes, newFileOutputStream(outputArgument.getParameter()));
			break;
		case HTML:
			exportAsHTML(athletes, newFileOutputStream(outputArgument.getParameter()));
			break;
		default:
			throw new ArgumentException("Method " + outputArgument.getMethod() + " can not be used as output method.");
		}
	}

	/**
	 * Exports the high score table to the console or to a custom stream. Data is separated using commas and spaces.
	 * @param athletes athletes that have taken part in the competition.
	 * @param consoleStream stream to export data to.
	 */
	public void exportToConsole(Athlete[] athletes, PrintStream consoleStream) {
		Map<Integer, LinkedList<Athlete>> scoreMap = generateSortedScoresMap(athletes).descendingMap();
		int place = 1;

		for(Map.Entry<Integer, LinkedList<Athlete>> equalPntsAths : scoreMap.entrySet()) {
			for(Athlete athlete : equalPntsAths.getValue()) {
				if(equalPntsAths.getValue().size() > 1) {
					consoleStream.print(place + "-" + (place + equalPntsAths.getValue().size() - 1) + ". ");
				}else consoleStream.print(place + ". ");

				consoleStream.print(equalPntsAths.getKey() + ", ");
				consoleStream.println(athlete.getAsReadableString());
			}
			place += equalPntsAths.getValue().size();
		}
		consoleStream.close();
	}

	/**
	 * Exports the high score table to a file or to a custom stream. Uses the CSV format.
	 * @param athletes athletes that have taken part in the competition.
	 * @param fileOutStream stream to export data to.
	 */
	public void exportAsCSV(Athlete[] athletes, PrintStream fileOutStream) {
		Map<Integer, LinkedList<Athlete>> scoreMap = generateSortedScoresMap(athletes).descendingMap();
		int place = 1;

		for(Map.Entry<Integer, LinkedList<Athlete>> entry : scoreMap.entrySet()) {
			for(Athlete athlete : entry.getValue()) {
				if(entry.getValue().size() > 1) {
					fileOutStream.print(place + "-" + (place + entry.getValue().size() - 1));
				}else fileOutStream.print(place);

				fileOutStream.println("," + athlete.getAsCSVString());
			}
			place += entry.getValue().size();
		}
		fileOutStream.close();
	}

	/**
	 * Exports the high score table to a xml file or to a custom stream. Uses the XML format.
	 * @param athletes athletes that have taken part in the competition.
	 * @param fileOutStream stream to export data to.
	 * @throws ExporterException throws when exporting has failed.
	 */
	public void exportAsXML(Athlete[] athletes, PrintStream fileOutStream) throws ExporterException {
		try {
			File dtdFile = new File(Exporter.class.getName().concat("") + DTD_FOR_XML);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, dtdFile.getPath());
			transformer.transform(generateDataSource(athletes), new StreamResult(fileOutStream));
		} catch (TransformerException e) {
			throw new ExporterException("XML transformer error: " + e.getMessage());
		}
		fileOutStream.close();
	}

	/**
	 * Exports the high score table to a html file or to a custom stream. Uses the HTML format.
	 * @param athletes athletes that have taken part in the competition.
	 * @param fileOutStream stream to export data to.
	 * @throws ExporterException throws when exporting has failed.
	 */
	public void exportAsHTML(Athlete[] athletes, PrintStream fileOutStream) throws ExporterException {
		try {
			InputStream xslStream = Exporter.class.getResourceAsStream(XSL_FOR_HTML);
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xslStream));
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "XMLFormat.dtd");
			transformer.transform(generateDataSource(athletes), new StreamResult(fileOutStream));
		} catch (TransformerException e) {
			throw new ExporterException("HTML transformer error: " + e.getMessage());
		}
		fileOutStream.close();
	}

	/**
	 * Creates a DOM source that is used to export data to XML or HTML format.
	 * @param athletes athletes that have taken part in the competition.
	 * @return source document.
	 * @throws ExporterException throws when something went wrong while exporting.
	 */
	public DOMSource generateDataSource(Athlete[] athletes) throws ExporterException {
		Map<Integer, LinkedList<Athlete>> scoreMap = generateSortedScoresMap(athletes).descendingMap();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		int place = 1;

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();

			Element rootElement = doc.createElement("decathlon");
			doc.appendChild(rootElement);
			doc.setNodeValue("decathlon");

			for(Map.Entry<Integer, LinkedList<Athlete>> entry : scoreMap.entrySet()) {
				Element placeElement = doc.createElement("place");
				rootElement.appendChild(placeElement);

				Attr placeRangeAttr = doc.createAttribute("range");
				if(entry.getValue().size() > 1) {
					placeRangeAttr.setValue(place + "-" + (place + entry.getValue().size() - 1));
				}else placeRangeAttr.setValue(String.valueOf(place));
				placeElement.setAttributeNode(placeRangeAttr);

				Attr scoreAttr = doc.createAttribute("score");
				scoreAttr.setValue(String.valueOf(entry.getKey()));
				placeElement.setAttributeNode(scoreAttr);

				for(Athlete athlete : entry.getValue()) placeElement.appendChild(athlete.toXMLElement(doc));

				place += entry.getValue().size();
			}
			return new DOMSource(doc);
		} catch (ParserConfigurationException e) {
			throw new ExporterException("Error while generating DOM data source: " + e.getMessage());
		}
	}

	/**
	 * Creates a new print stream from a file.
	 * @param file file location.
	 * @return stream.
	 * @throws ExporterException throws when file is missing or the encoding(UTF-8) is unsupported.
	 */
	public PrintStream newFileOutputStream(String file) throws ExporterException {
		try {
			return new PrintStream(new FileOutputStream(file), true, "UTF-8");
		} catch (FileNotFoundException e) {
			throw new ExporterException("File not found(" + file + "): " + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			throw new ExporterException("Unsupported encoding: " + e.getMessage());
		}
	}

	/**
	 * Creates a new navigable map that is used to create the high score list. The map key is used to store the score
	 * and the value is used to store a list of athletes that share the same result.
	 * @param athletes athletes that have taken part in the competition.
	 * @return navigable map that can be used in a reversed direction.
	 */
	public NavigableMap<Integer, LinkedList<Athlete>> generateSortedScoresMap(Athlete[] athletes) {
		NavigableMap<Integer, LinkedList<Athlete>> scoreMap = new TreeMap<Integer, LinkedList<Athlete>>();
		int score;

		for(Athlete athlete : athletes) {
			score = athlete.calculatePoints();
			if(!scoreMap.containsKey(score)) scoreMap.put(score, new LinkedList<Athlete>());
			scoreMap.get(score).add(athlete);
		}
		return scoreMap;
	}
}