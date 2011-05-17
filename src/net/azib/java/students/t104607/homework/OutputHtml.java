package net.azib.java.students.t104607.homework;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/**
 * @author 104607 IASM
 */
public class OutputHtml extends OutputXml{

	@Override
	void closeDocument(Writer out) throws IOException, TransformerException {
		InputStream xsl = OutputHtml.class.getResourceAsStream("decathlon.xsl");
		Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(xsl));
		transformer.transform(new DOMSource(xml), new StreamResult(out));

		out.close();
	}
}
