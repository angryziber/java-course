package net.azib.java.students.t100228.Homework;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Deals with generating an XML document with the results of athletes
 * @author Martin
 */
public class XmlResultsManager {
	/**
	 * Generates an XML file with the results of athletes
	 * @param fileName Path of the XML file
	 * @param records Array of {@link Record}s which contains the results of competitors
	 */
	public void outputResults(String fileName, ArrayList<Record> records){
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder documentBuilder;
		try
		{
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document xmlDocument = documentBuilder.newDocument();

			Element rootElement = xmlDocument.createElement("competition");
			xmlDocument.appendChild(rootElement);

			for(Record record : records)
			{
				Element elementRes = xmlDocument.createElement("result");

				Element elementName = xmlDocument.createElement("place");
				elementName.appendChild(xmlDocument.createTextNode(record.getPlace()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("score");
				elementName.appendChild(xmlDocument.createTextNode(record.getScore().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("name");
				elementName.appendChild(xmlDocument.createTextNode(record.getName()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("birthDate");
				elementName.appendChild(xmlDocument.createTextNode(record.getBirthDate()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("nationality");
				elementName.appendChild(xmlDocument.createTextNode(record.getNationality()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("hundred_meters");
				elementName.appendChild(xmlDocument.createTextNode(record.getHundredMResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("long_jump");
				elementName.appendChild(xmlDocument.createTextNode(record.getLongJumpResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("shot_put");
				elementName.appendChild(xmlDocument.createTextNode(record.getShotPutResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("high_jump");
				elementName.appendChild(xmlDocument.createTextNode(record.getHighJumpResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("four_hundred_meters");
				elementName.appendChild(xmlDocument.createTextNode(record.getFourHundredMResult()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("one_hundred_and_ten_meters");
				elementName.appendChild(xmlDocument.createTextNode(record.getOneHundredTenResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("discus_throw");
				elementName.appendChild(xmlDocument.createTextNode(record.getDiscusResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("pole_vault");
				elementName.appendChild(xmlDocument.createTextNode(record.getPoleVaultResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("javelin_throw");
				elementName.appendChild(xmlDocument.createTextNode(record.getJavelinResult().toString()));
				elementRes.appendChild(elementName);

				elementName = xmlDocument.createElement("one_thousand_five_hundred_meters");
				elementName.appendChild(xmlDocument.createTextNode(record.getThousandFiveHundredResult()));
				elementRes.appendChild(elementName);

				rootElement.appendChild(elementRes);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			Source src = new DOMSource(xmlDocument);
			Result dest = new StreamResult(new File(fileName));
			transformer.transform(src, dest);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
