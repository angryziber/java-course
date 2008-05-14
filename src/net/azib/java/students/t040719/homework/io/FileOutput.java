package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.Decathlon;
import net.azib.java.students.t040719.homework.DecathlonConstants;
import net.azib.java.students.t040719.homework.ISOCountry;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.exceptions.ConfigurationException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

/**
 * FileOutput
 *
 * @version 1.0
 * @author Romi Agar
 */
public class FileOutput implements DataOutput {
	private static final Logger LOG = Logger.getLogger(FileOutput.class.getSimpleName());
	
	private File out;			
	
	public FileOutput() {
		this(null);
	}

	FileOutput(File out) {
		this.out = out;
	}
	
	/**
	 * Exiting from program with given error code
	 * @param errorCode error code (int) for exiting
	 */
	void exit(int errorCode) {
		System.exit(errorCode);
	}
	
	/**
	 * @param results a list of athlete objects
	 * @return returns a DOM4J xml document object
	 */
	public static Document makeXMLDocument(List<Athlete> results){
		Document document = DocumentHelper.createDocument();
        Element root = document.addElement("decathlon")
        	.addAttribute(new QName("xmlns:xsi",Namespace.NO_NAMESPACE), "http://www.w3.org/2001/XMLSchema-instance")
        	.addAttribute(new QName("xsi:noNamespaceSchemaLocation",Namespace.NO_NAMESPACE), "DecathlonResults.xsd");
    	String place ="1";
        for (int i=0; i<results.size(); i++){
        	Athlete a = results.get(i);
	        if (i != 0 && results.get(i-1).getDecathlonPoints()>a.getDecathlonPoints() 
	        		&& i < results.size()-1 
	        		&& results.get(i+1).getDecathlonPoints()<a.getDecathlonPoints() 
	        		|| i == results.size()-1 && results.size() > 1
	        		&& results.get(i-1).getDecathlonPoints()>a.getDecathlonPoints())
	        	place = Integer.toString(i+1);
	        else if(i < results.size()-1 && results.get(i+1).getDecathlonPoints() == a.getDecathlonPoints())
	        	place = findPlaceSharers(results, i);
	        
	        Element athlete = root.addElement("athlete");
        	athlete.addElement("name").addText(a.getName());
        	athlete.addElement("birthday").addText(a.getBirthdayString());
        	Element country = athlete.addElement("country");
		    country.addElement("code").addText(a.getCountryCode());
		    country.addElement("name").addText(ISOCountry.getCountryName(a.getCountryCode()));
	        athlete.addElement("score").addText(Integer.toString(a.getDecathlonPoints()));
        	athlete.addElement("place").addText(place);
	        for (int j=0; j<DecathlonConstants.values().length; j++){
		        Element event = athlete.addElement("event")
		            .addAttribute("order", Integer.toString(j+1));
		        event.addElement("name").addText(DecathlonConstants.getOrdinal(j).getName());
	        	event.addElement("result").addText(String.format(Locale.US, "%.2f", a.getDecathlonResult(j)));
	        	event.addElement("unit").addText(DecathlonConstants.getOrdinal(j).getUnit());
		    }
	    }
        return document;
	}
	
	/**
	 * @param results athlete's list
	 * @param i index from where to start looking
	 * @return returns the shared place interval
	 */
	static String findPlaceSharers(List<Athlete> results, int i) {
		String place = Integer.toString(i+1) + "-";
		while (results.get(i).getDecathlonPoints()==results.get(i+1).getDecathlonPoints() && ++i < results.size()-1);
		return place + Integer.toString(i+1);
	}

	/**
	 * Validates xml to given xsd schema file
	 * @param xmlAsString
	 * @param xsdPath path to xsd schema
	 * @return return true, if xml validates to given schema, false otherwise
	 */
	public static boolean isValidXML(String xmlAsString, String xsdPath){
		Validator validator = null;
		try {
			validator = new Validator(xmlAsString, xsdPath);
			validator.useXMLSchema(true);
		}
		catch (ConfigurationException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Error validating XML file.", e);
			else
				LOG.log(Level.SEVERE, "Error validating XML file.");
		}
		catch (SAXException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Error validating XML file.", e);
			else
				LOG.log(Level.SEVERE, "Error validating XML file.");
		}
		if (validator != null)
			return validator.isValid();
		return false;

	}
	
	/**
	 * Outputs the athlete results from given list to an output file
	 * @param results a list of athletes
	 * @param parameter single parameter output file name
	 */
	public void outputResults(List<Athlete> results, String... parameter) {
		if (results == null){
			LOG.severe("Null parameter for athlete list.");
			exit(1);
		}
		else if (parameter == null || parameter.length != 2 || parameter[0].equals("") || !parameter[1].equals("-xml") && !parameter[1].equals("-csv") && !parameter[1].equals("-html")){
			LOG.severe("Must specify output file name and output format (-xml/-html/-csv).");
			exit(2);
		}
		else{
			Document document = makeXMLDocument(results);
			URI xsdPath = null;
			try {
				xsdPath = Decathlon.class.getResource("xml/DecathlonResults.xsd").toURI();
			}
			catch (URISyntaxException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "URI syntax error.", e);
				else
					LOG.log(Level.SEVERE, "URI syntax error.");
			}
			if (!isValidXML(document.asXML(), xsdPath.getPath()))
				LOG.warning("XML file is not valid.");
	        if (out == null)
	        	out = new File(parameter[0]);

			if (parameter[1].equals("-xml"))
				writeXMLToFile(document);
			else if(parameter[1].equals("-html"))
				toHTMLFile(document);				
			else if(parameter[1].equals("-csv"))
				toCSVFile(document);
		}	
	}

	/**
	 * Outputs xml document to comma separated file
	 * @param document xml document
	 */
	void toCSVFile(Document document) {
		URI stylesheetPath = null;
		try {
			stylesheetPath = Decathlon.class.getResource("xml/csv.xsl").toURI();
		}
		catch (URISyntaxException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "URI syntax error.", e);
			else
				LOG.log(Level.SEVERE, "URI syntax error.");
		}
		byte[] transformedDoc = transformDocument(document, stylesheetPath);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(out);
			fos.write(transformedDoc);
		}
		catch (FileNotFoundException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Cannot create new file.", e);
			else
				LOG.log(Level.SEVERE, "Cannot create new file.");
		}
		catch (IOException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Cannot write to file.", e);
			else
				LOG.log(Level.SEVERE, "Cannot write to file.");
		}
		finally{
			if (fos != null)
				try {
					fos.close();
				}
				catch (IOException e) {
					if (System.getProperty("program.debug") != null)
						LOG.log(Level.SEVERE, "Cannot close file output stream.", e);
					else
						LOG.log(Level.SEVERE, "Cannot close file output stream.");
				}
		}	
		System.out.println("Written file: " + out.getAbsolutePath());
	}

	/**
	 * Outputs xml document to HTML file
	 * @param document xml document
	 */
	void toHTMLFile(Document document) {
		URI stylesheetPath = null;
		try {
			stylesheetPath = Decathlon.class.getResource("xml/html.xsl").toURI();
		}
		catch (URISyntaxException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "URI syntax error.", e);
			else
				LOG.log(Level.SEVERE, "URI syntax error.");
		}
		Document transformedDoc = styleDocument(document, stylesheetPath);
		writeXMLToFile(transformedDoc);
	}

	/**
	 * Writes xml document to file
	 * @param doc xml document
	 */
	void writeXMLToFile(Document doc) {
		OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = null;
		try {
			writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(out),"UTF8"),format);
	        writer.write(doc);
	    }
		catch (IOException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.SEVERE, "Could not create xml output file", e);
			else
				LOG.log(Level.SEVERE, "Could not create xml output file");
		}
		finally {
			if (writer != null)
				try {
					writer.close();
				}
				catch (IOException e) {
					if (System.getProperty("program.debug") != null)
						LOG.log(Level.SEVERE, "Could not close writer", e);
					else
						LOG.log(Level.SEVERE, "Could not close writer");
				}
		}
		System.out.println("Written file: " + out.getAbsolutePath());
	}

	/**
	 * @param document xml document
	 * @param stylesheetSource stylesheet URI
	 * @return returns xml document transformed with given stylesheet
	 */
	Document styleDocument(Document document, URI stylesheetSource){
        DocumentResult result = new DocumentResult();;
		if (document == null || stylesheetSource == null){
			LOG.severe("Input paramteres needed.");
			exit(4);
		} else {
	        TransformerFactory factory = TransformerFactory.newInstance();
	        try {
	        	File xsltFile = new File(stylesheetSource.getPath());
	        	Source xsltSource = new StreamSource(xsltFile);
	        	Transformer transformer = factory.newTransformer(xsltSource);
	        	DocumentSource source = new DocumentSource(document);
				transformer.transform( source, result );
			}
			catch (TransformerException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.",e);
				else
					LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.");
				exit(7);
			}
		}
        return result.getDocument();
	}

	/**
	 * @param document xml document
	 * @param stylesheetSource stylesheet URI
	 * @return returns byte array of transformed xml document
	 */
	byte[] transformDocument(Document document, URI stylesheetSource){
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
		if (document == null || stylesheetSource == null){
			LOG.severe("Input paramteres needed.");
			exit(5);
		}else{
		    TransformerFactory factory = TransformerFactory.newInstance();
		    try {
		    	File xsltFile = new File(stylesheetSource.getPath());
		    	Source xsltSource = new StreamSource(xsltFile);
		    	Transformer transformer = factory.newTransformer(xsltSource);
		    	transformer.transform( new StreamSource(new ByteArrayInputStream(document.asXML().getBytes("UTF-8"))), new StreamResult(out));
			}
			catch (TransformerException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.",e);
				else
					LOG.log(Level.SEVERE, "Cannot transform xml according to given stylesheet.");
				exit(6);
			}
			catch (UnsupportedEncodingException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Problem with xml encoding.",e);
				else
					LOG.log(Level.SEVERE, "Problem with xml encoding.");
				exit(6);			}
		}
	    return out.toByteArray();
	}
}
