package net.azib.java.students.t050724.homework;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * HTMLWriter
 * 
 * @author xom
 */
public class HTMLWriter {

	SupportClass supporter = new SupportClass();
	XMLWriter xmlWriter = new XMLWriter();

	/**
	 * Writes the data of the parameter "athletes" to a .html file that is
	 * specified by the parameter "path". Also creates an .xml file that is
	 * needed for the .html file creation. "athletes.xsl" file is needed to
	 * create the .html file.
	 * 
	 * @param athletes
	 *            ArrayList of Athlete that is to be printed out to console.
	 * @param path
	 *            String representation of the file or path, where to write the
	 *            file.
	 */
	protected void createHTML(ArrayList<Athlete> athletes, String path) {

		path = supporter.setFilePath(path);

		xmlWriter.createXML(athletes, "athletes.xml");

		try {

			StreamSource source = new StreamSource(supporter.setFilePath("athletes.xml"));
			StreamResult result = new StreamResult(new FileOutputStream(path));

			Transformer transformer = TransformerFactory.newInstance().newTransformer(
					new javax.xml.transform.stream.StreamSource(supporter.setFilePath("athletes.xsl")));

			transformer.transform(source, result);
		}
		catch (Exception e) {
			System.out.println("There are problems creating the HTML file!");
		}

	}

}
