package net.azib.java.students.t107678.homework;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

/** Logic for making html output
 *
 */
public class HTMLWriter implements Writer {

	String fileName;

	public HTMLWriter(String fileName) throws IOException {
		this.fileName = fileName;
	}

	/** This method is not implemented, since it will not be used never in case of HTMLWriter, since
	 * writer uses logic of writing all results to output at once
	 *
	 * @param  place Participant's final place in competition
	 * @param record Participant's Record
	 */
	@Override
	public void writeNext(Place place, Record record) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	/** All data is written out at once. It is worth of mentioning that I had to "hardcode" paths
	 * in this method, because its the only way I knew to implement logic for XMLWriter
	 *
	 * @param resultsComputation instance of ResultComputation with competition final results
	 */
	@Override
	public void writeOutput(ResultsComputation resultsComputation) throws TransformerException, IOException, ParserConfigurationException {

		XMLWriter xmlWriter = new XMLWriter("src/net/azib/java/students/t107678/homework/tempXMLforHTML");
		xmlWriter.writeOutput(resultsComputation);

		TransformerFactory transformerFactory = TransformerFactory.newInstance();

		Transformer transformer = transformerFactory.newTransformer(new StreamSource("src/net/azib/java/students/t107678/homework/athletes.xsl"));
		transformer.transform(new StreamSource("src/net/azib/java/students/t107678/homework/tempXMLforHTML"), new StreamResult(new FileOutputStream(fileName)));


	}

}

