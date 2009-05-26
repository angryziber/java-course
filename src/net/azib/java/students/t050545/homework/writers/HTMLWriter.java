package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.sport.Competition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * HTMLWriter
 * 
 * @author libricon
 */
public class HTMLWriter implements SportmanWriter {
	
	/** This writes writes to file in HTML form all competition data
	 * @param fileName destination
	 * @throws TransformerException
	 * @throws FileNotFoundException
	 * 
	 */
	public HTMLWriter(String fileName) throws FileNotFoundException, TransformerException {
        // New transformer
		transformer = TransformerFactory.newInstance().newTransformer(
				new StreamSource(HTMLWriter.class.getResource("competition.xslt").getFile()));
		this.outFile = fileName;

	}

	/** Method writes competition in HTML by using XSL file in the writer package
	 *  @param comp competition itself
	 *  @throws Exception 
	 */
	@Override
	public void printResultTable(Competition comp) throws Exception {
		// stringwriter is used instead of pipes, 
		// because XMLWRITER write to out, and transformer need to read from out
		StringWriter out = new StringWriter();
		XMLWriter xml = new XMLWriter(out);
		xml.printResultTable(comp);

		StringReader in = new StringReader(out.toString());
		transformer.transform(new StreamSource(in), new StreamResult(new FileOutputStream(outFile)));
        out.close();
        in.close();
	}
	
	/** 
	 *  This method is only part of interface
	 */
	@Override
	public void close() {
		transformer.reset();

	}

	/** destination file */
	String outFile;
	/** transformer that transform xml to html form */
	Transformer transformer;

}
