package net.azib.java.students.t030657.homework;

import java.io.File;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Karina
 * public class HtmlWriter
 * Writes the data to hte .html file, using ready-made .xml file
 *
 */

public class HtmlWriter extends XmlWriter {
	
	private static final String xsltFile = "decathlon.xsl";
	
	public HtmlWriter(File file) {
		super(file);
	}

	@Override
	Transformer getTransformer() throws TransformerConfigurationException {
		return TransformerFactory.newInstance().newTransformer(new StreamSource(xsltFile));
	}
}
