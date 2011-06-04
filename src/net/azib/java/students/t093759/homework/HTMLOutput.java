package net.azib.java.students.t093759.homework;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.InputStream;

/**
 * This class should be used to output a list of athletes as html data.
 *
 * @author dionis
 *         5/30/114:55 AM
 */
public class HTMLOutput extends XMLOutput implements AthletesOutput {

	@Override
	void transform(String fileName, Document doc) throws TransformerException {
		InputStream xsl = getClass().getResourceAsStream("output.xsl");
		Transformer serializer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));
		serializer.transform(new DOMSource(doc), new StreamResult(new File(fileName)));
	}
}
