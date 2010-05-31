package net.azib.java.students.t092851.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * DecathlonDataOutputHTML
 *
 * @author Lauri
 */
public class DecathlonDataOutputHTML implements DecathlonDataOutput {

	private final String fileName;
	
	
	/**
	 * @param fileName output HTML file name
	 */	
	public DecathlonDataOutputHTML(String fileName) {
		this.fileName = fileName;
	}

	
	/**
	 * @param data decathlon competition data to write into HTML file
	 * @return true on success
	 */	
	@Override
	public boolean writeData(DecathlonData data) {
		InputStream  xslStream  = null;
		OutputStream htmlStream = null;
		DOMSource    source     = (new DecathlonDataOutputXML(null)).getDOMSource(data);
		
		if (source == null)
			return false;
		
		try {
			
			// Load XSL from resource
			{
				String resourceFileName = "results.xsl";
				
				xslStream = DecathlonCalculator.class.getResourceAsStream(resourceFileName);
				if (xslStream == null) {
					System.out.println("Resource file \"" + resourceFileName + "\" not found!");
					return false;
				}
			}
			
			// Create HTML file
			try {
				htmlStream = new FileOutputStream(fileName);
			}
			catch (FileNotFoundException exception) {
				System.out.println("Output file \"" + fileName + "\" could not be written.");
				return false;
			}
			
			// Transform
			StreamSource    xslSource = new StreamSource(xslStream);
			Transformer     template  = TransformerFactory.newInstance().newTransformer(xslSource);
			
			template.transform(source, new StreamResult(htmlStream));
		}
		catch (Exception e) {
			System.out.println("XSLT operation failed: " + e.toString());
			return false;
		}
		finally {
			try {
				if (xslStream != null)
					xslStream.close();
			} catch (IOException e) {
			}
			try {
				if (htmlStream != null)
					htmlStream.close();
			} catch (IOException e) {
			}
		}
		
		return true;
	}

}
