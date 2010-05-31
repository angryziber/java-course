package net.azib.java.students.t092851.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * DecathlonDataOutputXML
 *
 * @author Lauri
 */
public class DecathlonDataOutputXML implements DecathlonDataOutput {
	
	private final String fileName;
	
	/**
	 * @param fileName output XML file name, may be set to 'null' if
	 * 		the goal is not to write a file
	 */	
	public DecathlonDataOutputXML(String fileName) {
		this.fileName  = fileName;		
	}
	
	
	/**
	 * @param data decathlon competition data to write into XML file
	 * @return true on success
	 */	
	@Override
	public boolean writeData(DecathlonData data) {
		BufferedWriter writer     = null;
		DOMSource      source     = getDOMSource(data);
		
		if (source == null)
			return false;
		
		try
		{
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			StreamResult result = new StreamResult(writer);
			Transformer  transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);	
		}
		catch (Exception e) {
			System.out.println("Writing to XML file \"" + fileName + "\"failed: " + e.toString());
			return false;
		}
		finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
		
		return true;
	}
	
	
	/**
	 * @param data decathlon competition data to prepare into XML format
	 * @return intermediate structured data in XML-like format; can be used for direct XSLT
	 */	
	public DOMSource getDOMSource(DecathlonData data) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		DOMSource  source;
		
		if (data == null)
			return null;
		
		try
		{
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.newDocument();
			Element root = doc.createElement("athletes");
			doc.appendChild(root);
			
			for (Participant participant : data) {
				
				Element athlete = doc.createElement("participant");
				root.appendChild(athlete);
				
				Element place = doc.createElement("place");
				place.setTextContent(participant.getPlace());
				athlete.appendChild(place);
				
				Element points = doc.createElement("points");
				points.setTextContent(String.valueOf(participant.getPoints()));
				athlete.appendChild(points);
				
				Element name = doc.createElement("name");
				name.setTextContent(participant.getName());
				athlete.appendChild(name);
				
				Element dob = doc.createElement("dob");
				dob.setTextContent(dateFormat.format(participant.getBirthDate()));
				athlete.appendChild(dob);
				
				Element country = doc.createElement("country");
				country.setTextContent(participant.getCountry());
				athlete.appendChild(country);
				
				for (DecathlonEvent event : DecathlonEvent.values()) {
					Element result = doc.createElement(event.getDatabaseHeader());
					result.setTextContent(String.valueOf(participant.getResult(event)));
					athlete.appendChild(result);
				}
			}
			
			source = new DOMSource(doc);
		}
		catch (Exception e) {
			System.out.println("Constructing XML data failed: " + e.toString());
			return null;
		}
		return source;
	}

}
