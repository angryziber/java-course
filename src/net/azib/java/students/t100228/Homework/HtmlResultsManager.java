package net.azib.java.students.t100228.Homework;

import org.jdom.output.XMLOutputter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Deals with generating an HTML file which contains the table of ordered competition results
 * @author Martin
 */
public class HtmlResultsManager {

	/**
	 * Generates an HTML file from data contained in {@code records}
	 * @param fileName Path of the output HTML file
	 * @param records {@link ArrayList} of {@link Record}s which contains the competition results
	 */
	public void outputResults(String fileName, ArrayList<Record> records){
		File htmlFile = new File(fileName);
		File xmlFile;
		try
		{
			xmlFile = File.createTempFile("decathlon", ".tmp");

			xmlFile.deleteOnExit();

			XmlResultsManager xmlResultsManager = new XmlResultsManager();
			xmlResultsManager.outputResults(xmlFile.getAbsolutePath(), records);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();

			Transformer transformer = transformerFactory.newTransformer(new StreamSource("src\\net\\azib\\java\\students\\t100228\\Homework\\decathlon.xsl"));
			transformer.transform(new StreamSource(xmlFile.getAbsolutePath()), new StreamResult(new FileOutputStream(htmlFile)));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
