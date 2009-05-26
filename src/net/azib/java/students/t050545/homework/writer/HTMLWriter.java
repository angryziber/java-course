package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.sport.Competition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Reader;
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
	
	/**
	 * @throws TransformerException
	 * @throws FileNotFoundException
	 * 
	 */
	public HTMLWriter(String fileName) throws FileNotFoundException, TransformerException {

		transformer = TransformerFactory.newInstance().newTransformer(
				new StreamSource(HTMLWriter.class.getResource("competition.xslt").getFile()));
		this.outFile = fileName;

	}

	@Override
	public void printResultTable(Competition comp) throws Exception {
		StringWriter out = new StringWriter();
		XMLWriter xml = new XMLWriter(out);
		xml.printResultTable(comp);

		StringReader in = new StringReader(out.toString());
		transformer.transform(new StreamSource(in), new StreamResult(new FileOutputStream(outFile)));
        out.close();
        in.close();
	}
	
	@Override
	public void close() {
		transformer.reset();

	}

	String outFile;
	Transformer transformer;

	public static void main(String[] args) throws Exception {
		System.out.println(HTMLWriter.class.getResource("competition.xslt").getFile());
	}

}
