package net.azib.java.students.t092851.homework;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
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
	
	public DecathlonDataOutputXML(String fileName) {
		this.fileName  = fileName;		
	}

	@Override
	public boolean writeData(DecathlonData data) {
		BufferedWriter writer     = null;
		DateFormat     dateFormat = new SimpleDateFormat("dd.MM.yyyy");		
		
		if (data == null)
			return false;
		
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
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));

			StreamResult result = new StreamResult(writer);
			DOMSource source = new DOMSource(doc);
			transformer.transform(source, result);	
		}
		catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}
