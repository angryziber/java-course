package net.azib.java.students.t092861.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author Stanislav / 092861
 * 
 */
public class IOxml extends AbstractIO {

	/**
	 * Used for counting the xml validation errors.
	 */
	public static int errorCount = 0;

	/**
	 * File name or the path to the file.
	 */
	public String param = "";

	/**
	 * Temporary file.
	 */
	private File temp = null;

	/**
	 * Default constructor.
	 * 
	 * @param param
	 *            - parameters of the input/output
	 * @param ctrl
	 *            - controller
	 */
	public IOxml(String param, Controller ctrl) {
		super(ctrl);
		this.param = param;
	}

	/**
	 * Overridden constructor.
	 * 
	 * @param temp
	 *            - temporary output file
	 * @param ctrl
	 *            - controller
	 */
	public IOxml(File temp, Controller ctrl) {
		super(ctrl);
		this.temp = temp;
	}

	@Override
	ArrayList<Athlete> input() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void output(ArrayList<Athlete> athletes){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			
			factory.setValidating(true);
			factory.setNamespaceAware(true);
			factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
					"http://www.w3.org/2001/XMLSchema");

			factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", new InputSource(
					new FileInputStream(Const.PACKAGE + "XMLSchema.xsd")));
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Root element
			Document doc = builder.newDocument();
			
			Element root = doc.createElement("CompetitionResults");
			doc.appendChild(root);
			this.arrangeInOrder(athletes);

			for (Athlete a : athletes) {

				// Athlete element
				Element athlete = doc.createElement("athlete");
				root.appendChild(athlete);

				// Place element
				Element place = doc.createElement("place");
				Text placeText = doc.createTextNode(String
						.valueOf(a.getPlace()));
				place.appendChild(placeText);
				athlete.appendChild(place);

				// Name element
				Element name = doc.createElement("name");
				Text nameText = doc.createTextNode(a.getName());
				name.appendChild(nameText);
				athlete.appendChild(name);

				// Birthday element
				Element birtday = doc.createElement("birthday");
//				birtday.setAttribute("date", this.convertDateToString(a.getBirthday()));
				Text birtdayText = doc.createTextNode(this.convertDateToString(a.getBirthday()));
				birtday.appendChild(birtdayText);
				athlete.appendChild(birtday);

				// Country code element
				Element countryCode = doc.createElement("country");
				Text countryCodeText = doc.createTextNode(a.getCountry());
				countryCode.appendChild(countryCodeText);
				athlete.appendChild(countryCode);

				/*     ********** Athletes's results element begin ********** */
				Element athleteResults = doc.createElement("athlete_results");

				Element sprint_100Name = doc.createElement("sprint_100");
				Text sprint_100Text = doc.createTextNode(String.valueOf(a.getSprint100()));
				sprint_100Name.appendChild(sprint_100Text);
				athleteResults.appendChild(sprint_100Name);

				Element long_jumpName = doc.createElement("long_jump");
				Text long_jumpText = doc.createTextNode(String.valueOf(a.getLongJump()));
				long_jumpName.appendChild(long_jumpText);
				athleteResults.appendChild(long_jumpName);

				Element short_putName = doc.createElement("short_put");
				Text short_putText = doc.createTextNode(String.valueOf(a.getShortPut()));
				short_putName.appendChild(short_putText);
				athleteResults.appendChild(short_putName);

				Element high_jumpName = doc.createElement("high_jump");
				Text high_jumpText = doc.createTextNode(String.valueOf(a.getHighJump()));
				high_jumpName.appendChild(high_jumpText);
				athleteResults.appendChild(high_jumpName);

				Element sprint_400Name = doc.createElement("sprint_400");
				Text sprint_400Text = doc.createTextNode(this.convertTimeToString(a.getSprint400()));
				sprint_400Name.appendChild(sprint_400Text);
				athleteResults.appendChild(sprint_400Name);

				Element discus_throwName = doc.createElement("discus_throw");
				Text discus_throwText = doc.createTextNode(String.valueOf(a.getDiscusThrow()));
				discus_throwName.appendChild(discus_throwText);
				athleteResults.appendChild(discus_throwName);

				Element pole_vaultName = doc.createElement("pole_vault");
				Text pole_vaultText = doc.createTextNode(String.valueOf(a.getPoleVault()));
				pole_vaultName.appendChild(pole_vaultText);
				athleteResults.appendChild(pole_vaultName);

				Element javelin_throwName = doc.createElement("javelin_throw");
				Text javelin_throwText = doc.createTextNode(String.valueOf(a.getJavelinThrow()));
				javelin_throwName.appendChild(javelin_throwText);
				athleteResults.appendChild(javelin_throwName);

				Element race_1500Name = doc.createElement("race_1500");
				Text race_1500Text = doc.createTextNode(this.convertTimeToString(a.getSprint1500()));
				race_1500Name.appendChild(race_1500Text);
				athleteResults.appendChild(race_1500Name);

				athlete.appendChild(athleteResults);
				/*     ********** Athletes's results element end ********** */

				// Score element
				Element score = doc.createElement("score");
				Text scoreText = doc.createTextNode(Integer.toString(a.getScore()));
				score.appendChild(scoreText);
				athlete.appendChild(score);
			}

			// write the content into xml file
			File file = null;
			if (temp == null) {
				file = getOutputFile(getParameters());
			} else {
				file = temp;
			}

			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);

			Schema schema = loadSchema(Const.PACKAGE + "XMLSchema.xsd");

			validateXML(schema, file.getPath());
			out.println("\nSuccessful XML output to " + "\"" + file.getName()
					+ "\"" + " file!");
			
		} catch (TransformerConfigurationException e) {
			out.println("\nError! Serious configuration error.");
			e.printStackTrace();
			
		} catch (TransformerException e) {
			out.println("\nError occured during the transformation process .");
			e.printStackTrace();
			
		} catch (ParserConfigurationException e) {
			out.println("\nError! Serious configuration error.");
			e.printStackTrace();
			
		} catch (IllegalArgumentException e) {
			out.println("\nError! Method has been passed an illegal or inappropriate argument.");
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			out.println("\nError! Attempt to open the file denoted by a specified pathname has failed.");
			e.printStackTrace();
		}
	}
	
	public void validateXML(Schema schema, String xmlName) {
		try {

			// creating a Validator instance
			Validator validator = schema.newValidator();
			out.println();
			out.println("Validator Class: "	+ validator.getClass().getName());

			// setting my own error handler
			validator.setErrorHandler(new MyErrorHandler());

			// preparing the XML file as a SAX source
			SAXSource source = new SAXSource(new InputSource(new java.io.FileInputStream(xmlName)));

			// validating the SAX source against the schema
			validator.validate(source);
			if (errorCount > 0) {
				out.println("Failed with errors: " + errorCount);
			} else {
				out.println("Validation Passed.");
			}

		} catch (Exception e) {
			// catching all validation exceptions
			out.println();
			out.println(e.toString());
		}
	}

	public static Schema loadSchema(String name) {
		Schema schema = null;
		try {
			String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			SchemaFactory factory = SchemaFactory.newInstance(language);
			schema = factory.newSchema(new File(name));
		} catch (Exception e) {
			out.println(e.toString());
		}
		return schema;
	}

	static class MyErrorHandler implements ErrorHandler {
		public void fatalError(SAXParseException e) throws SAXException {
			out.println(e.toString());
			throw e;
		}

		public void error(SAXParseException e) throws SAXException {
			out.println(e.toString());
			errorCount++;
			// continue with validatin process
			// throw e;
		}

		public void warning(SAXParseException e) throws SAXException {
			out.println(e.toString());
		}
	}

	@Override
	public String getParameters() {
		return param;
	}

}
