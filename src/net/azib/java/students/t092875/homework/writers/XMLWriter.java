package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;
import net.azib.java.students.t092875.homework.competiotions.Competiotion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * XMLWriter
 *
 * @author Mihhail
 */
public class XMLWriter implements DecathlonWriter {
	protected String filename;
	/**
	 * @param filename - file, where the xml file will saved
	 */
	public XMLWriter(String filename){
		this.filename = filename;
	}
	/**
	 * saves the athletes data in an XML file
	 * 
	 * @param athletes - List of athletes to be parsed into XML
	 */
	@Override
	public void write(List<Athlete> athletes) {
		Document doc = this.generateXML(athletes);
		OutputFormat of = new OutputFormat("XML","UTF-8",true);
		of.setIndent(1);
		of.setIndenting(true);
		File xmlFile = new File(filename);
		try {
			if(!xmlFile.exists()){
				xmlFile.createNewFile();
			}
			XMLSerializer serializer = new XMLSerializer(new FileOutputStream(xmlFile),of);
			serializer.asDOMSerializer();
			serializer.serialize(doc.getDocumentElement());
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * generates the xml to be saved in the file
	 * @param athletes - the List with the athlete objects
	 * @return Document containing the XML to be saved 
	 */
	Document generateXML(List<Athlete> athletes){
		Document doc = new DocumentImpl();
		Element root = doc.createElement("athletes");
		for (Athlete athlete : athletes) {
			Element athl = doc.createElementNS(null, "athlete");
			athl.setAttribute("name", athlete.getName());
			SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
			athl.setAttribute("dob", format.format(athlete.getDateOfBirth()).toString());
			athl.setAttribute("origin", athlete.getOrigin());
			athl.setAttribute("place", athlete.getPlace());
			for (Competiotion comp : Competiotion.values()) {
				Element result = doc.createElement("event");
				result.setAttribute("event_name", comp.toString());
				Node points = doc.createTextNode(athlete.getEventResult(comp.ordinal()));
				result.appendChild(points);
				athl.appendChild(result);
			}
			Element totalResult = doc.createElement("total_result");
			Node points = doc.createTextNode(""+athlete.getResult());
			totalResult.appendChild(points);
			athl.appendChild(totalResult);
			root.appendChild(athl);
		}
		doc.appendChild(root);
		return doc;
	}
}
