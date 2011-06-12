package net.azib.java.students.t100224.homework.io;

import net.azib.java.students.t100224.homework.model.Result;
import org.apache.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.util.List;


public class HtmlPrinter implements ResultsPrinter {

	private final Logger LOG = Logger.getLogger(getClass().getName());

	/**
	 * Prints all calculated results of athletes to HTML file using a Document Object Model tree
	 *
	 * @param results - Array list of athletes and their decathlon results
	 */
	@Override
	public void printResults(List<Result> results, String filename) {
		DOMTreeLoader dom = new DOMTreeLoader();
		DOMSource source = dom.createDOMTree(results);
		InputStream xsl = HtmlPrinter.class.getResourceAsStream("athletes.xsl");
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));
			transformer.transform(source, new StreamResult(filename));
		} catch (TransformerConfigurationException e) {
			LOG.error(e.getMessage());
		} catch (TransformerException e) {
			LOG.error(e.getMessage());
		}
	}

}
