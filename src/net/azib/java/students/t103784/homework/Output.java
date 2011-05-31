package net.azib.java.students.t103784.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * This class is used to output the athletes and their results.
 *
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class Output {
	String parameter = Main.outputParameter;

	/**
	 * Outputs athletes to console.
	 * <p/>
	 * Goes through the list of athletes supplied and
	 * prints all of their data into the console.
	 * Also calculates the athletes' places before printing the list.
	 *
	 * @param contestants The list of athletes supplied.
	 */
	public void outputToConsole(List<Athlete> contestants) {
		PlaceCalculator.calculatePlace(contestants);
		for (Athlete athlete : contestants) {
			System.out.println("Name: " + athlete.getName());
			System.out.println("Date of Birth: " + athlete.getBirthDate());
			System.out.println("Country: " + athlete.getCountry());
			for (int i = 0; i < 10; i++) {
				System.out.println(athlete.getEvents(i) + athlete.getPerformance(i));
			}
			System.out.println("Score: " + athlete.getScore());
			System.out.println("Place: " + athlete.getPlace() + "\n");
		}

	}

	/**
	 * Outputs athletes to a .csv file.
	 * <p/>
	 * Goes through the list of athletes supplied and
	 * prints all of their data into a .csv file, each
	 * athlete on a separate line, with values separated
	 * with a comma, and place and score are the first values.
	 * Also calculates the athletes' places before printing the list.
	 *
	 * @param contestants The list of athletes supplied.
	 * @throws java.io.FileNotFoundException Is thrown when the output file is undefined.
	 */
	public void outputToCSV(List<Athlete> contestants) throws FileNotFoundException {
		try {
			PlaceCalculator.calculatePlace(contestants);
			PrintStream out;
			if (parameter != null) {
				out = new PrintStream((new FileOutputStream
						(parameter)));
			} else {
				out = new PrintStream((new FileOutputStream
						("src/net/azib/java/students/t103784/homework/tmp/sampleOutput.csv")));
			}
			for (Athlete athlete : contestants) {
				out.print(athlete.getPlace() + ",");
				out.print(athlete.getScore() + ",");
				out.print(athlete.getName() + ",");
				out.print(athlete.getBirthDate() + ",");
				out.print(athlete.getCountry() + ",");
				for (int i = 0; i < 10; i++) {
					out.print(athlete.getPerformance(i) + ",");
					if (i == 9) out.print(athlete.getPerformance(i));
				}
				out.print(System.getProperty("line.separator"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Outputs athletes to a .html file.
	 * <p/>
	 * Goes through the list of athletes supplied and
	 * prints all of their data into a .xml file, which
	 * is then converted to a .html file using a pre-defined
	 * .xsl stylesheet file.
	 * Also calculates the athletes' places before printing the list.
	 *
	 * @param contestants The list of athletes supplied.
	 * @throws java.io.FileNotFoundException Is thrown when the output file is undefined.
	 * @throws javax.xml.parsers.ParserConfigurationException
	 *                                       Is thrown when the parsing configuration is amiss.
	 * @throws javax.xml.transform.TransformerException
	 *                                       Is thrown when the transformer gets and invalid value somewhere.
	 * @throws org.xml.sax.SAXException      Is thrown when the SAX parser gets an error somewhere.
	 */
	public void outputToHTML(List<Athlete> contestants) throws TransformerException,
			IOException, SAXException, ParserConfigurationException {
		outputToXML(contestants);
		try {
			TransformerFactory tFactory = TransformerFactory.
					newInstance();
			Transformer transformer = tFactory.
					newTransformer(new javax.xml.transform.stream.StreamSource
							("src/net/azib/java/students/t103784/homework/decathlonHTML.xsl"));
			if (parameter != null && parameter.contains(".html")) {
				transformer.transform
						(new javax.xml.transform.
								stream.StreamSource("src/net/azib/java/students/t103784/homework/tmp/temp.xml"),
								new javax.xml.transform.
										stream.StreamResult(new FileOutputStream
										(parameter)));

			} else {
				transformer.transform
						(new javax.xml.transform.
								stream.StreamSource("src/net/azib/java/students/t103784/homework/tmp/temp.xml"),
								new javax.xml.transform.
										stream.StreamResult(new FileOutputStream
										("src/net/azib/java/students/t103784/homework/tmp/temp.html")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Outputs athletes to a .xml file.
	 * <p/>
	 * Goes through the list of athletes supplied and
	 * prints all of their data into a .xml file.
	 * Each athlete is a child of the root element and each of the
	 * athlete's results is a child of the athlete element.
	 * DOM is used to build the .xml file.
	 * Also calculates the athletes' places before printing the list.
	 *
	 * @param contestants The list of athletes supplied.
	 * @throws java.io.FileNotFoundException Is thrown when the output file is undefined.
	 * @throws javax.xml.parsers.ParserConfigurationException
	 *                                       Is thrown when the parsing configuration is amiss.
	 * @throws javax.xml.transform.TransformerException
	 *                                       Is thrown when the transformer gets and invalid value somewhere.
	 * @throws org.xml.sax.SAXException      Is thrown when the SAX parser gets an error somewhere.
	 */
	public void outputToXML(List<Athlete> contestants) throws IOException,
			ParserConfigurationException, TransformerException, SAXException {
		PlaceCalculator.calculatePlace(contestants);
		String root = "decathlon";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory
				.newDocumentBuilder();
		Document results = documentBuilder.newDocument();

		Element rootElement = results.createElement(root);
		results.appendChild(rootElement);
		int i = 0;
		for (Athlete athlete : contestants) {
			Element em = results.createElement("athlete");

			Element nameElement = results.createElement("name");
			String name = athlete.getName();
			nameElement.appendChild(results.createTextNode(name));

			Element birthDateElement = results.createElement("dateofbirth");
			String dateOfBirth = athlete.getBirthDate();
			birthDateElement.appendChild(results.createTextNode(dateOfBirth));

			Element countryElement = results.createElement("country");
			String country = athlete.getCountry();
			countryElement.appendChild(results.createTextNode(country));

			Element hundredMetersElement = results.createElement("hundredmeters");
			String hundredMetersResult = String.valueOf(athlete.getPerformance
					(i));
			hundredMetersElement.appendChild(results.createTextNode
					(hundredMetersResult));
			i++;

			Element longJumpElement = results.createElement("longjump");
			String longJumpResult = String.valueOf(athlete.getPerformance(i));
			longJumpElement.appendChild(results.createTextNode(longJumpResult));
			i++;

			Element shotPutElement = results.createElement("shotput");
			String shotPutResult = String.valueOf(athlete.getPerformance(i));
			shotPutElement.appendChild(results.createTextNode(shotPutResult));
			i++;

			Element highJumpElement = results.createElement("highjump");
			String highJumpResult = String.valueOf(athlete.getPerformance(i));
			highJumpElement.appendChild(results.createTextNode(highJumpResult));
			i++;

			Element fourHundredMetersElement = results.createElement
					("fourhundredmeters");
			String fourHundredMetersResult = String.valueOf
					(athlete.getPerformance(i));
			fourHundredMetersElement.appendChild(results.createTextNode
					(fourHundredMetersResult));
			i++;

			Element hurdlesElement = results.createElement("hurdles");
			String hurdlesResult = String.valueOf(athlete.getPerformance(i));
			hurdlesElement.appendChild(results.createTextNode(hurdlesResult));
			i++;

			Element discusElement = results.createElement("discus");
			String discusResult = String.valueOf(athlete.getPerformance(i));
			discusElement.appendChild(results.createTextNode(discusResult));
			i++;

			Element poleVaultElement = results.createElement("polevault");
			String poleVaultResult = String.valueOf(athlete.getPerformance(i));
			poleVaultElement.appendChild(results.createTextNode(poleVaultResult));
			i++;

			Element javelinElement = results.createElement("javelin");
			String javelinResult = String.valueOf(athlete.getPerformance(i));
			javelinElement.appendChild(results.createTextNode(javelinResult));
			i++;

			Element raceElement = results.createElement("race");
			String raceResult = String.valueOf(athlete.getPerformance(i));
			raceElement.appendChild(results.createTextNode(raceResult));
			i = 0;

			Element scoreElement = results.createElement("score");
			String score = String.valueOf(athlete.getScore());
			scoreElement.appendChild(results.createTextNode(score));

			Element placeElement = results.createElement("place");
			String place = String.valueOf(athlete.getPlace());
			placeElement.appendChild(results.createTextNode(place));

			em.appendChild(nameElement);
			em.appendChild(birthDateElement);
			em.appendChild(countryElement);
			em.appendChild(hundredMetersElement);
			em.appendChild(longJumpElement);
			em.appendChild(shotPutElement);
			em.appendChild(highJumpElement);
			em.appendChild(fourHundredMetersElement);
			em.appendChild(hurdlesElement);
			em.appendChild(discusElement);
			em.appendChild(poleVaultElement);
			em.appendChild(javelinElement);
			em.appendChild(raceElement);
			em.appendChild(scoreElement);
			em.appendChild(placeElement);

			rootElement.appendChild(em);
		}

		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();
		Transformer transformer = transformerFactory.
				newTransformer();
		transformer.setOutputProperty
				(OutputKeys.ENCODING, "UTF-8");
		if (parameter != null && parameter.contains(".xml")) {
			transformer.transform
					(new DOMSource(results), new StreamResult(parameter));
			System.out.println();
		} else {
			transformer.transform
					(new DOMSource(results), new StreamResult("src/net/azib/java/students/t103784/homework/tmp/temp.xml"));
		}
	}
}
