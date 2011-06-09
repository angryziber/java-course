package net.azib.java.students.t100224.homework.xml;

import net.azib.java.students.t100224.homework.interfaces.IResultsPrinter;
import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.List;

public class XMLPrinter implements IResultsPrinter {

	private final Logger LOG = Logger.getLogger(getClass().getName());
	private String filename;

	public XMLPrinter(String filename) {
		this.filename = filename;
	}

	/**
	 * Prints all calculated results of athletes to XML file using a Document Object Model tree
	 *
	 * @param results - Array list of athletes and their decathlon results
	 */
	@Override
	public void printResults(List<Result> results) {
		DOMTreeLoader dom = new DOMTreeLoader();
		DOMSource source = dom.createDOMTree(results);
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, new StreamResult(filename));
		} catch (TransformerConfigurationException e) {
			LOG.error(e.getMessage());
		} catch (TransformerException e) {
			LOG.error(e.getMessage());
		}
	}

}
