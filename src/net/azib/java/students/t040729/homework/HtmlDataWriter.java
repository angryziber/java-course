package net.azib.java.students.t040729.homework;

import java.io.File;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * HtmlDataWriter
 *
 * @author ValleTon
 */
public class HtmlDataWriter extends XmlDataWriter {

	/**
	 * Constructor for HTML writer implementation.
	 * @param fileName Filename where to generate HTML.
	 */
	public HtmlDataWriter(String fileName) {
		super(fileName);
	}

	@Override
	public void putCompetitionData(List<Athlete> athletes) throws TransformerFactoryConfigurationError, Exception {
		Document doc = getNewDocument();
		Element root = getPreparedRoot(doc);
		
		super.putAthletesToXmlDoc(athletes, doc, root);
		transformXml(doc);
	}

	private void transformXml(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(getClass().getResource(".").getPath()+"decathlon.xsl"));

		transformer.setOutputProperty(OutputKeys.ENCODING, properties.getProperty("encoding"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "html");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "-//W3C//DTD HTML 4.01//EN");
		transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://www.w3.org/TR/html4/strict.dtd");
		File outFile = new File(fileName);
        Result result = new StreamResult(outFile);
        transformer.transform(new DOMSource(doc), result);
	}
}
