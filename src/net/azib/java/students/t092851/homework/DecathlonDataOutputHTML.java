package net.azib.java.students.t092851.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;

/**
 * DecathlonDataOutputHTML
 *
 * @author Lauri
 */
public class DecathlonDataOutputHTML implements DecathlonDataOutput {

	private DecathlonDataOutputXML xmlOutput;
	private final String xmlFileName;
	private final String xslFileName;
	private final String htmlFileName;
	
	
	public DecathlonDataOutputHTML(String xmlFileName, String xslFileName, String htmlFileName) {
		this.xmlFileName  = xmlFileName;		
		this.xslFileName  = xslFileName;		
		this.htmlFileName = htmlFileName;
		xmlOutput = new DecathlonDataOutputXML(xmlFileName);
	}
	
	
	@Override
	public boolean writeData(DecathlonData data) {
		InputStream  xslStream  = null;
		InputStream  xmlStream  = null;
		OutputStream htmlStream = null;
		
		if (data == null)
			return false;
		
		if (xmlOutput.writeData(data) == false)
			return false;
		
		try {
			try {
				xslStream  = new FileInputStream(xslFileName);
			}
			catch (FileNotFoundException exception) {
				System.out.println("XSL input file \"" + xslFileName + "\" is missing or cannot be read.");
				return false;
			}
			
			try {
				xmlStream  = new FileInputStream(xmlFileName);
			}
			catch (FileNotFoundException exception) {
				System.out.println("XML input file \"" + xmlFileName + "\" is missing or cannot be read.");
				return false;
			}
			
			try {
				htmlStream = new FileOutputStream(htmlFileName);
			}
			catch (FileNotFoundException exception) {
				System.out.println("Output file \"" + htmlFileName + "\" could not be written.");
				return false;
			}
			
			StreamSource xslSource = new StreamSource(xslStream);
			DocumentBuilder builder;
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(xmlStream);
			
			Transformer template = TransformerFactory.newInstance().newTransformer(xslSource);
			template.transform(new DOMSource(doc), new StreamResult(htmlStream));
		}
		catch (Exception e) {
			System.out.println("XSLT operation failed: " + e.getCause());
			return false;
		}
		finally {
			try {
				if (xslStream != null)
					xslStream.close();
			} catch (IOException e) {
			}
			try {
				if (xmlStream != null)
					xmlStream.close();
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
