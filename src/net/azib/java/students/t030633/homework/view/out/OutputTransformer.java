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

	public OutputTransformer(URL stylesheet) {
		this.stylesheet = stylesheet;
	}

	public void write(List<Athlete> athletes, String... fileName) throws IOException {

		initializeOutput(fileName); // Output is dependent on extending class

		/*
		 * Create a temporary XML buffer (in the form of ByteArrayOutputStream)
		 * and write XML into it. Hopefully we have enough memory to buffer the
		 * entire amount of data.
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

	/**
	 * Output initialization. Defaults to writing output to a file but can be
	 * overridden to make the transformer write to some other output, like
	 * System.out.
	 * 
	 * @param fileName -
	 *            parameters from the write method
	 * 
	 * @throws IOException
	 */
	protected void initializeOutput(String[] fileName) throws IOException {
		if (output == null) { // Not null when testing
			try { // Output file name should have been given as a parameter
				output = new FileOutputStream(new File(fileName[0]));
			}
			catch (ArrayIndexOutOfBoundsException e) {
				throw new IOException("Output file not specified.", e);
			}
		}
	}

	// This method is for testing
	void setOutputStream(OutputStream output) {
		this.output = output;
	}

}
