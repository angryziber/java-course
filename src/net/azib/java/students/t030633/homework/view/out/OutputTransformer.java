package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.DecathlonCalculator;
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

	public OutputTransformer(URL stylesheet) {
		this.stylesheet = stylesheet;
	}

	public void write(List<Athlete> athletes) throws IOException {
		init(); // Initialize from property
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
		if (this.output == null) {
			if (DecathlonCalculator.outputProperty == null)
				throw new IOException("Output file not specified.");
			this.output = new FileOutputStream(new File(DecathlonCalculator.class.getResource(".").getPath(),
					DecathlonCalculator.outputProperty));
		}
	}
}
