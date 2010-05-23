package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.DecathlonComputation;

import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

/**
 * This class represents the html output action.
 * */
public class HtmlOutputAction extends XmlOutputAction {
	private static final String XSL_FILE = "athletes.xsl";
	
	public HtmlOutputAction(String filename) throws IOException {
		super(filename);
	}
	
	@Override
	Transformer getTransformer(TransformerFactory tFactory)
			throws TransformerConfigurationException {
		StreamSource xslSource = new StreamSource(
				DecathlonComputation.class.getResourceAsStream(XSL_FILE));
		return tFactory.newTransformer(xslSource);
	}
}
