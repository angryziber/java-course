package net.azib.java.students.t093052.homework.action.output;

import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;

/**
 * This class represents the xml output action.
 * */
public class XmlOutputAction extends NodeOutputAction {

	public XmlOutputAction(String filename) throws IOException {
		super(filename);
	}

	@Override
	Transformer getTransformer(TransformerFactory tFactory) 
			throws TransformerConfigurationException {
		return tFactory.newTransformer();
	}
}
