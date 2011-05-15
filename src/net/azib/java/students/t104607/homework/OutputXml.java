package net.azib.java.students.t104607.homework;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.List;
/*
http://www.w3schools.com/schema/schema_example.asp
http://java.sun.com/developer/technicalArticles/xml/validationxpath/
 */

/**
 * @author 104607 IASM
 */
public class OutputXml {
	public void save(OutputStream outputStream, List<Athlete> athletes) throws IOException, TransformerException, ParserConfigurationException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream));

		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
        Document xml = docBuilder.newDocument();
		Element root = xml.createElement("decathlon");
        xml.appendChild(root);
		for (Athlete athlete : athletes) {
			Element record = xml.createElement("athlete");
			//athlete.setTextContent("Siim Susi");
	        //athlete.setAttribute("name", "Siim Susi");
			//athlete.setAttribute("country", "EE");
			//athlete.setAttribute("bday", "1976-01-01");
			Element element = xml.createElement("name");
			element.setTextContent(athlete.getName());
			record.appendChild(element);
			element = xml.createElement("country");
			element.setTextContent(athlete.getCountry());
			record.appendChild(element);
			element = xml.createElement("birthday");
			element.setTextContent(athlete.getBirthday());
			record.appendChild(element);
			element = xml.createElement("event");
			//element.setTextContent("sprint_100m");
			element.setAttribute("name", "sprint_100m");
			Element event = xml.createElement("result");
			event.setTextContent(athlete.getSprint100m());
			element.appendChild(event);
			record.appendChild(element);
			root.appendChild(record);
		}
		//Text text = xml.createTextNode("Filler, ... I could have had a foo!");
        //athlete.appendChild(text);
		//root.appendChild(athlete);
		//Comment comment = xml.createComment("Just a thought");
		//root.appendChild(comment);

		xml.setXmlStandalone(true);
		Transformer serializer = TransformerFactory.newInstance().newTransformer();
		serializer.setOutputProperty(OutputKeys. OMIT_XML_DECLARATION, "yes");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
		serializer.transform(new DOMSource(xml), new StreamResult(out));

		try {
			System.out.println("\nStarting validate !!!");
			long t = System.currentTimeMillis();
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(OutputXml.class.getResource("decathlon.xsd"));
			Validator validator = schema.newValidator();
			validator.validate(new DOMSource(xml));
			System.out.println("Output is validated !!!");
			System.out.println("Processing time: " + (System.currentTimeMillis() - t) + "ms");
		} catch (SAXException e) {
			e.printStackTrace();
		}

		out.close();
	}
}
