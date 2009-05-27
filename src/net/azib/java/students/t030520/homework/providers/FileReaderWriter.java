package net.azib.java.students.t030520.homework.providers;

import net.azib.java.students.t030520.homework.Main;
import net.azib.java.students.t030520.homework.event.FieldEvent;
import net.azib.java.students.t030520.homework.event.TrackEvent;
import net.azib.java.students.t030520.homework.sportsman.EventResult;
import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;
import net.azib.java.students.t030520.homework.util.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * Provides the functionality of reading from file and writing into file.
 *
 * @author t030520
 */
public class FileReaderWriter {

	private static final String XSD_SCHEMA = "SportsmanWithResult.xsd";
	private static final String XSL_SCHEMA = "SportsmanWithResult.xsl";
	private static final String SCHEMA_FACTORY = "http://www.w3.org/2001/XMLSchema";

	/**
	 * @param fileName the file to read data from.
	 * @return the list of sportsman's results.
	 * @throws IOException
	 */
	public List<SportsmanWithResults> readSportspenResultsFromCsv(String fileName) throws IOException {
		List<SportsmanWithResults> results = new ArrayList<SportsmanWithResults>();

		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
		String str;
		while ((str = in.readLine()) != null) {
			results.add(parseRow(str));
		}

		in.close();

		return results;
	}

	/**
	 * @param results the list of sportsman's results.
	 * @param filename the file to write into.
	 * @throws IOException
	 */
	public void writeSportsmenResultToCsv(List<SportsmanWithResults> results, String filename) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "UTF-8"));

		for (SportsmanWithResults result : results) {
			bw.append(result.getPlace() + "," + result.getPoints() + "," + result.getName() + "," 
					+ result.getBirthDate() + "," + result.getCountryCode() + ",");
			int i = 1;
			for (EventResult ev : result.getResults()) {
				bw.append(String.valueOf(ev.getResult()));
				if (i != result.getResults().size()) {
					bw.append(",");
				}
				i++;
			}
			bw.append('\n');
		}

		bw.close();
	}

	/**
	 * @param results the list of sportsman's results.
	 * @param filename the file to write into.
	 * @throws IOException
	 */
	public void writeSportsmenResultToXml(List<SportsmanWithResults> results, String filename) throws IOException {
		Document doc = generateXmlDoc(results);

		OutputFormat format = new OutputFormat(doc);
		format.setIndenting(true);

		XMLSerializer serializer = new XMLSerializer(new FileOutputStream(new File(filename)), format);

		serializer.serialize(doc);
	}
	
	/**
	 * @param results the list of sportsman's results.
	 * @param filename the file to write into.
	 * @throws IOException
	 */
	public void writeSportsmenResultToHtml(List<SportsmanWithResults> results, String filename) throws IOException {
	
		TransformerFactory tFactory = TransformerFactory.newInstance();
	
		try {
			Transformer transformer = tFactory.newTransformer(new StreamSource(Main.class.getResourceAsStream(XSL_SCHEMA)));
			transformer.transform(new DOMSource(generateXmlDoc(results)), new StreamResult(new FileOutputStream(filename)));
		} catch (TransformerException e) {
			System.out.println("Could not transform xml into html.");
			System.exit(1);
		}
	}

	private SportsmanWithResults parseRow(String str) {
		SportsmanWithResults result = new SportsmanWithResults();
		String[] sportsmenData = str.split(",");

		if (sportsmenData.length != 13) {
			throwException();
		}

		// Set name
		if (Utils.isEmpty(sportsmenData[0])) {
			throwException();
		} else {
			result.setName(sportsmenData[0]);
		}

		// Set birthday
		if (Utils.isEmpty(sportsmenData[1]) || !Utils.isValidDate(sportsmenData[1])) {
			throwException();
		} else {
			result.setBirthDate(Utils.convertToDate(sportsmenData[1]));
		}

		// Set country code
		if (Utils.isEmpty(sportsmenData[2]) || sportsmenData[2].length() != 2) {
			throwException();
		} else {
			result.setCountryCode(sportsmenData[2]);
		}

		// Enter sprint100 results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[3]), TrackEvent.SPRINT100));

		// Enter longJump results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[4]), FieldEvent.LONGJUMP));

		// Enter shotPut results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[5]), FieldEvent.SHOTPUT));

		// Enter highJump results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[6]), FieldEvent.HIGHJUMP));

		// Enter sprint400 results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[7]), TrackEvent.SPRINT400));

		// Enter hurdles110 results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[8]), TrackEvent.HURDLES110));

		// Enter discusThrow results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[9]), FieldEvent.DISCUSTHROW));

		// Enter poleVault results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[10]), FieldEvent.POLEVAULT));

		// Enter javelinThrow results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[11]), FieldEvent.JAVELINTHROW));

		// Enter race1500 results
		result.getResults().add(new EventResult(getFloatInput(sportsmenData[12]), TrackEvent.RACE1500));

		return result;
	}

	private Document generateXmlDoc(List<SportsmanWithResults> results) throws IOException {
		Document doc = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			Element rootElement = doc.createElement("sportsmens");
			doc.appendChild(rootElement);
	
			for (SportsmanWithResults result : results) {
				Element sportsmenElement = createSportsmenElement(doc, result);
				rootElement.appendChild(sportsmenElement);
			}
	
			// Validate generated doc. 
			validateXml(doc);
		} catch (ParserConfigurationException e) {
			System.out.println("Could not create an xml.");
			System.exit(1);
		}

		return doc;
	}

	private void validateXml(Document doc) throws IOException {
		SchemaFactory factory = SchemaFactory.newInstance(SCHEMA_FACTORY);

		try {
			Schema schema = factory.newSchema(new StreamSource(Main.class.getResourceAsStream(XSD_SCHEMA)));
			Validator validator = schema.newValidator();
			DOMSource source = new DOMSource(doc);
			validator.validate(source);
		} catch (SAXException ex) {
			System.out.println("Generated xml document is invalid.");
			System.exit(1);
		}
	}

	/**
	 * Helper method which creates a XML sportsman element 
	 * @param doc an XML document
	 * @param result The result for which we need to create an xml representation
	 * @return XML element snippet representing a result
	 */
	private Element createSportsmenElement(Document doc, SportsmanWithResults result) {

		Element sportsmenElement = doc.createElement("sportsmen");
		sportsmenElement.setAttribute("name", result.getName());
		sportsmenElement.setAttribute("birthday", result.getBirthDate().toString());
		sportsmenElement.setAttribute("countrycode", result.getCountryCode());

		//create place element attach it to sportsmenElement
		Element placeElement = doc.createElement("place");
		placeElement.setTextContent(result.getPlace());
		sportsmenElement.appendChild(placeElement);

		//create points element attach it to sportsmenElement
		Element pointsElement = doc.createElement("points");
		pointsElement.setTextContent(String.valueOf(result.getPoints()));
		sportsmenElement.appendChild(pointsElement);

		//create results elements attach it to sportsmenElement
		for (EventResult ev : result.getResults()) {
			Element resElement = doc.createElement(ev.getType().getName().toLowerCase());
			resElement.setTextContent(String.valueOf(ev.getResult()));
			sportsmenElement.appendChild(resElement);
		}

		return sportsmenElement;
	}

	private float getFloatInput(String str) {
		if (Utils.isEmpty(str) || !Utils.isValidFloat(str)) {
			throwException();
		}
		return Utils.convertToFloat(str);
	}

	private void throwException() {
		System.out.println("Wrong file format.");
		System.exit(1);
	}
}
