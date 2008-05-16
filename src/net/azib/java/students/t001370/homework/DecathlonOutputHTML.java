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
 *
 * @author maksim
 */
public class DecathlonOutputHTML extends DecathlonOutput{
	private static final Logger LOG = Logger.getLogger(DecathlonOutputHTML.class.getName());

	private final PrintStream output;

	DecathlonOutputHTML(){
		this.output = System.out;
	}
	
	DecathlonOutputHTML(PrintStream out){
		this.output = out;
	}
	
	@Override
	public void writeData(Collection<Athlete> compatetors, File outputFile) {
		
		InputStream stylesheet = null;
		try{
			stylesheet = DecathlonDataWriter.class.getResourceAsStream("decathlon.xsl");
			Transformer transformer = TransformerFactory.newInstance().
					newTransformer(new StreamSource(stylesheet));
			
			DOMSource source = new DOMSource(new DecathlonOutputXML().createDecathlonXMLDocument(compatetors));
			transformer.transform(source, new StreamResult(new FileOutputStream(outputFile)));
		}
		catch(Exception e){
			output.println(Errors.ERROR_0001.getErrorText());
			
			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}
		finally{
			try {
				stylesheet.close();
			}
			catch (IOException e) {
				output.println(Errors.ERROR_0002.getErrorText());
				
				LOG.log(Level.INFO, e.getMessage());
				System.exit(1);
			}
		}
	}
}
