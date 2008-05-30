package net.azib.java.students.t001370.homework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * DecathlonOutputHTML
 * Class for writing decathlon competition data to HTML file. 
 * @author maksim
 */
public class DecathlonOutputHTML extends DecathlonOutput{
	private static final Logger LOG = Logger.getLogger(DecathlonOutputHTML.class.getName());

	private final PrintStream output;

	/**
	 * DecathlonOutputHTML constructor
	 * @return
	 */
	DecathlonOutputHTML(){
		this.output = System.out;
	}
	
	/**
	 * DecathlonOutputHTML constructor. Mostly used for testing purpose
	 * @param out - print stream for user interaction
	 */
	DecathlonOutputHTML(PrintStream out){
		this.output = out;
	}
	
	@Override
	public void writeData(Collection<Athlete> compatetors, File outputFile) throws DecathlonException {
		
		InputStream stylesheet = null;
		try{
			//get stylesheet for transforming xml to html 
			stylesheet = DecathlonDataWriter.class.getResourceAsStream("decathlon.xsl");
			Transformer transformer = TransformerFactory.newInstance().
					newTransformer(new StreamSource(stylesheet));
			
			//make xml document
			DOMSource source = new DOMSource(new DecathlonOutputXML().createDecathlonXMLDocument(compatetors));
			//transform xml to html and write to file
			transformer.transform(source, new StreamResult(new FileOutputStream(outputFile)));
		}
		catch(Exception e){
			output.println(Errors.ERROR_COULD_NOT_CREATE_HTML.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_COULD_NOT_CREATE_HTML.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			
			throw new DecathlonException();
		}
		finally{
			try {
				stylesheet.close();
			}
			catch (IOException e) {
				output.println(Errors.ERROR_COULD_NOT_CLOSE_STYLESHEET.getErrorText());
				
				LOG.log(Level.INFO, Errors.ERROR_COULD_NOT_CLOSE_STYLESHEET.getErrorText());
				LOG.log(Level.INFO, e.getMessage());
			}
		}
	}
}
