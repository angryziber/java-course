package net.azib.java.students.t030633.homework.view.out;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.view.Files;
import net.azib.java.students.t030633.homework.view.Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Transformer
 * 
 * @author t030633
 */
public class OutputTransformer implements Output {

	private OutputStream out;
	private URL stylesheetURL;

	public OutputTransformer(URL stylesheet, OutputStream out) {
		this.stylesheetURL = stylesheet;
		this.out = out;
	}

	/**
	 * @param source -
	 *            File, source file to transform
	 * @param destination -
	 *            OutputStream for transformation result
	 * @param stylesheet -
	 *            URL for transformation XSL
	 * @throws IOException
	 *             if transformation fails
	 */
	private void transform(File source, OutputStream destination, URL stylesheet) throws IOException {
		InputStream inputStream = null;
		Transformer transformer;
		try {
			inputStream = stylesheet.openStream();
			transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(inputStream));
			transformer.transform(new StreamSource(source), new StreamResult(destination));
		}
		catch (Exception e) {
			throw new IOException("Transformer error.", e);
		}
		finally {
			if (inputStream != null)
				inputStream.close();
		}
	}

	public void write(List<Athlete> out) throws IOException {
		File temp = Files.getTempFile();
		new XML(new FileOutputStream(temp)).write(out);
		transform(temp, this.out, this.stylesheetURL);
	}

	public void close() throws IOException {
		if (this.out != null)
			this.out.close();
	}

}
