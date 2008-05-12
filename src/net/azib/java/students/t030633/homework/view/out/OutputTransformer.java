package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;

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
 * Transforms XML using XSL stylesheet.
 * 
 * @author t030633
 */
public class OutputTransformer implements Output {

	private URL stylesheet;
	protected OutputStream output;
	private String fileName;
	private String filePath;

	public OutputTransformer(URL stylesheet) {
		this.stylesheet = stylesheet;
	}
	
	public OutputTransformer(URL stylesheet, OutputStream output) {
		this.stylesheet = stylesheet;
		this.output = output;
	}

	public void write(List<Athlete> athletes) throws IOException {
		
		init(); // Initialize from properties
		
		/*
		 * Create a temporary file and write XML into it
		 */
		File temp = File.createTempFile("athletes", ".tmp");
		new XML(new FileOutputStream(temp)).write(athletes);
		temp.deleteOnExit();

		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(stylesheet.openStream()));
			transformer.transform(new StreamSource(temp), new StreamResult(output));
		}
		catch (TransformerException e) {
			throw new IOException(e.getMessage());
		}
		finally {
			output.close();
		}

	}

	public void init() throws IOException {
		if (output == null) { // Not null when testing
			if (fileName == null)
				throw new IOException("Output file not specified.");
			output = new FileOutputStream(new File(filePath, fileName));
		}
	}

	public void setParameters(String... param) {
		fileName = param[1]; // Parameter 1 should be a file name
		filePath = param[0]; // Parameter 0 should be file path
	}
	
}
