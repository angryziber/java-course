package net.azib.java.students.t030682.homework;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.Validator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

/**
 * DataInputClass is a class containing all methods for outputting Decathlon Competition information
 * 
 * @author t030682
 */
public class DataOutputClass { 

	/**
	 * This method is needed for counting final places based on sorted competition list
	 * @param results Sorted List with Decathlon competitition data
	 * @return int[] array of places
	 * @author t030682
	 */
	private int[] countPlaces(List<DecathlonResultsRecord> results) {
		int places[] = new int[results.size()];
		int tmpPlace;
		int numberOfSamePlaces = 0;
		int tmpScore = 0;
		for (DecathlonResultsRecord decRecord : results) {
			tmpPlace = (results.indexOf(decRecord));
			if (decRecord.totalScore == tmpScore) {
				//if some athletes share scores, they share places also
				++numberOfSamePlaces;
				tmpPlace = tmpPlace-numberOfSamePlaces;
			} else numberOfSamePlaces = 0;
			places[results.indexOf(decRecord)] = tmpPlace + 1;
			tmpScore = decRecord.totalScore;
		}
		return places;
	}

	/**
	 * consoleWriter print final results with scores and all information to console
	 * @param results Sorted List with Decathlon competitition data
	 * @author t030682
	 */
	public void consoleWriter(List<DecathlonResultsRecord> results) {
		System.out.println("+++++++++++++++++\nAthletes results:\n+++++++++++++++++\n");
		for (DecathlonResultsRecord consoleResult : results) 
			System.out.println(countPlaces(results)[results.indexOf(consoleResult)] + ":   " + consoleResult);
	}

	/**
	 * csvWriter saves final results to some file
	 * @param results Sorted List with Decathlon competitition data
	 * @param filename CSV file location for saving to
	 * @author t030682
	 */
	public void csvWriter(List<DecathlonResultsRecord> results, String filename) {
		try {
			FileWriter fstream = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fstream);
			for (DecathlonResultsRecord csvResult : results) {
				out.write(countPlaces(results)[results.indexOf(csvResult)] + "," + csvResult.totalScore + ",\"" + csvResult.name + "\","
						+ csvResult.dateOfBirth + "," + csvResult.country + "," + csvResult.resultOf100mSprint + "," + csvResult.resultOfLongJump
						+ "," + csvResult.resultOfShotPut + "," + csvResult.resultOfHighJump + "," + csvResult.resultOf400mSprint + ","
						+ csvResult.resultOf110mHurdles + "," + csvResult.resultOfDiscusThrow + "," + csvResult.resultOfPoleVault + ","
						+ csvResult.resultOfJavelinThrow + "," + csvResult.resultOf1500Race);
				out.newLine();
			}
			out.close();
			System.out.println("Output saved in CSV format to: " + filename);
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	/**
	 * This method build DOM document from an array list of Decathlon records
	 * @param results Sorted List with Decathlon competitition data
	 * @return Document DOM document
	 * @author t030682
	 */
	public Document buildDocument (List<DecathlonResultsRecord> results) {
		Element root = new Element("Decathlon");
		Element[] athlete = new Element[countPlaces(results).length];
		root.addNamespaceDeclaration(Namespace.getNamespace("xsi","http://www.w3.org/2001/XMLSchema-instance"));
		root.addNamespaceDeclaration(Namespace.getNamespace("noNamespaceSchemaLocation","decathlon.xsd"));
		for (DecathlonResultsRecord docResult : results) {
			root.addContent("\n "); 
			athlete[results.indexOf(docResult)] = new Element("athlete");
			
			Element place = new Element("place");
			place.setText(Integer.toString(countPlaces(results)[results.indexOf(docResult)]));
			Element score = new Element("points");
			score.addContent(Integer.toString(docResult.totalScore));
			Element name = new Element("name");
			name.addContent(docResult.name);
			Element birthdate = new Element("dateOfBirth");
			birthdate.addContent(docResult.dateOfBirth); 
			Element country = new Element("country");
			country.addContent(docResult.country);
			Element resultOf100mSprint = new Element("resultOf100mSprint");
			resultOf100mSprint.addContent(Double.toString(docResult.resultOf100mSprint));
			Element resultOfLongJump = new Element("resultOfLongJump");
			resultOfLongJump.addContent(Double.toString(docResult.resultOfLongJump));
			Element resultOfShotPut = new Element("resultOfShotPut");
			resultOfShotPut.addContent(Double.toString(docResult.resultOfShotPut));
			Element resultOfHighJump = new Element("resultOfHighJump");
			resultOfHighJump.addContent(Double.toString(docResult.resultOfHighJump));
			Element resultOf400mSprint = new Element("resultOf400mSprint");
			resultOf400mSprint.addContent(Double.toString(docResult.resultOf400mSprint));
			Element resultOf110mHurdles = new Element("resultOf110mHurdles");
			resultOf110mHurdles.addContent(Double.toString(docResult.resultOf110mHurdles));
			Element resultOfDiscusThrow = new Element("resultOfDiscusThrow");
			resultOfDiscusThrow.addContent(Double.toString(docResult.resultOfDiscusThrow));
			Element resultOfPoleVault = new Element("resultOfPoleVault");
			resultOfPoleVault.addContent(Double.toString(docResult.resultOfPoleVault));
			Element resultOfJavelinThrow = new Element("resultOfJavelinThrow");
			resultOfJavelinThrow.addContent(Double.toString(docResult.resultOfJavelinThrow));
			Element resultOf1500mRace = new Element("resultOf1500mRace");
			resultOf1500mRace.addContent(Double.toString(docResult.resultOf1500Race));
			
			athlete[results.indexOf(docResult)].addContent("\n  ").addContent(place).addContent("\n  ").addContent(score).
			addContent("\n  ").addContent(name).addContent("\n  ").addContent(birthdate).addContent("\n  ").addContent(country).
			addContent("\n  ").addContent(resultOf100mSprint).addContent("\n  ").addContent(resultOfLongJump).addContent("\n  ").
			addContent(resultOfShotPut).addContent("\n  ").addContent(resultOfHighJump).addContent("\n  ").addContent(resultOf400mSprint).
			addContent("\n  ").addContent(resultOf110mHurdles).addContent("\n  ").addContent(resultOfDiscusThrow).addContent("\n  ").
			addContent(resultOfPoleVault).addContent("\n  ").addContent(resultOfJavelinThrow).addContent("\n  ").addContent(resultOf1500mRace).
			addContent("\n ");
		
			root.addContent(athlete[results.indexOf(docResult)]);
		}
		return new Document(root);
	}
	
	/**
	 * xmlWriter saves final results from DOM document to some file
	 * @param doc DOM Document with Decathlon competitition data
	 * @param filename XML file location for saving to
	 * @author t030682
	 */
	public void xmlWriter (Document doc, String filename) throws FileNotFoundException, IOException {
		XMLOutputter outputter = new XMLOutputter();
		outputter.output(doc, new FileOutputStream(filename));
		System.out.println("Output saved in XML format to: " + filename);
	}
	
	/**
	 * htmlWriter saves final results from DOM document to some file
	 * @param doc DOM Document with Decathlon competitition data
	 * @param filename HTML file location for saving to
	 * @author t030682 
	 */
	public void htmlWriter (Document doc, String filename) throws TransformerException, FileNotFoundException, IOException{
		XMLOutputter outputter = new XMLOutputter();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		outputter.output(doc, out);
		Transformer serializer = TransformerFactory.newInstance().newTransformer(new StreamSource(DataOutputClass.class.getResource("decathlon.xsl").toString()));
		serializer.transform(new StreamSource(new ByteArrayInputStream(out.toByteArray())), new StreamResult(new File(filename)));
		System.out.println("Output saved inn HTML format to: " + filename);
		
	} 
	
    public void validateXML(String filename) throws SAXException, IOException, ParserConfigurationException {

        try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			factory.setNamespaceAware(true);
			factory.setValidating(true);
			String schemaSource = DataOutputClass.class.getResource("decathlon.xsd").toString();
			Source schemaSourceSrc = new StreamSource(schemaSource);        // has various constructors to pass xsd as a file,url,stream and so on ...
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = schemaFactory.newSchema(schemaSourceSrc);
			
			factory.setSchema(schema);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = (Document) builder.parse(filename);
			System.out.println(document);
		}
        catch (SAXException e)  
        {  
        e.printStackTrace();  
        }  
        catch (IOException e)  
        {  
        e.printStackTrace();  
        }  
        
    }

}