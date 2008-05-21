package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Transforms XML using XSL stylesheet. You can generate output in almost any
 * format if you have XSL for it.
 * 
 * @author t030633
 */
public class OutputTransformer implements Output {

	private URL stylesheet; // The stylesheet could be anywhere...
	protected OutputStream output;
	private String fileName;

	public OutputTransformer(URL stylesheet) {
		this.stylesheet = stylesheet;
	}

	public void write(List<Athlete> athletes) throws IOException {

		init(); // Initialize from properties

		/*
		 * Create a temporary XML buffer (in the form of ByteArrayOutputStream) and write XML into it
		 * Hopefully we have enough memory to buffer the entire amount of data
		 */
		ByteArrayOutputStream temp = new ByteArrayOutputStream();
		new XML(temp).write(athletes);

		try {
			// Do the transform: XML -> XSL -> New Format
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(stylesheet.openStream()));
			transformer.transform(new StreamSource(new ByteArrayInputStream(temp.toByteArray())), new StreamResult(output));
		}
		catch (TransformerException e) {
			throw new IOException(e.getMessage());
		}
		finally {
			output.close();
		}

	}

	public void init() throws IOException {
		if ((fileName == null) && (output == null)) // When parameters have not been set
			throw new IOException("Output file not specified.");
		else if (output == null) { // Not null when testing
			output = new FileOutputStream(new File(fileName));
		}
	}

	public void setParameters(String... param) {
		fileName = param[0]; // Parameter should be a file name
	}
	
	// This method is mostly used for testing
	void setOutputStream(OutputStream output) {
		this.output = output;
	}

}
