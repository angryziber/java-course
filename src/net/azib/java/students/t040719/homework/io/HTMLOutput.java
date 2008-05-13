package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;
import net.azib.java.students.t040719.homework.Decathlon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * HTMLOutput - class for generating HTML output
 *
 * @version 1.0
 * @author Romi Agar
 */
public class HTMLOutput implements DataOutput {
	private static final Logger LOG = Logger.getLogger(HTMLOutput.class.getSimpleName());
	private File out;			
	
	public HTMLOutput() {
		this(null);
	}

	HTMLOutput(File out) {
		this.out = out;
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
		else if (parameter == null || parameter.length == 0 || parameter[0].equals("")){
			LOG.severe("No output file name given.");
			exit(2);
		}
		else{
			Document xmlDoc = XMLOutput.makeXMLDocument(results);
			URI xsdPath = null;
			URI stylesheetPath = null;
			try {
				xsdPath = Decathlon.class.getResource("xml/DecathlonResults.xsd").toURI();
				stylesheetPath = Decathlon.class.getResource("xml/html.xsl").toURI();
			}
			catch (URISyntaxException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "URI syntax error.", e);
				else
					LOG.log(Level.SEVERE, "URI syntax error.");
			}
			if (xsdPath != null && !XMLOutput.isValidXML(xmlDoc.asXML(), xsdPath.getPath())){
				LOG.warning("XML is not valid.");
			}
			Document transformedDoc = XMLOutput.styleDocument(xmlDoc, stylesheetPath);
			if (out == null)
	        	out = new File(parameter[0]);
			OutputFormat format = OutputFormat.createPrettyPrint();
	        XMLWriter writer;
	        if (out == null)
	        	out = new File(parameter[0]);
			try {
				writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(out),"UTF8"),format);
		        writer.write(transformedDoc);
		        writer.close();
		    }
			catch (IOException e) {
				if (System.getProperty("program.debug") != null)
					LOG.log(Level.SEVERE, "Could not create xml output file", e);
				else
					LOG.log(Level.SEVERE, "Could not create xml output file");
				exit(3);
			}
		}
	}
	
	/**
	 * Exiting from program with given error code
	 * @param errorCode error code (int) for exiting
	 */
	void exit(int errorCode) {
		System.exit(errorCode);
	}

}
