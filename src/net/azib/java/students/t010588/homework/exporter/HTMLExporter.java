package net.azib.java.students.t010588.homework.exporter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Exports results into HTML file
 *
 * @author Vjatseslav Rosin, 010588
 */
public class HTMLExporter extends XMLExporter {

	private static final String DEFAULT_STYLE_FILE_NAME = "style.xsl";

	/**
	 * @param htmlFile
	 *            destination to export
	 */
	public HTMLExporter(File htmlFile) {
		super(htmlFile);
	}

	protected boolean store(File file) throws InternalException {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(DEFAULT_STYLE_FILE_NAME));
			DOMSource source = new DOMSource(document);

			FileOutputStream os = new FileOutputStream(file);
			transformer.transform(source, new StreamResult(os));
			return true;
		}
		catch (IOException e) {
			return false;
		}
		catch (TransformerException e) {
			throw new InternalException(e.getMessage());
		}
	}
}
