package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.LoadException;
import net.azib.java.students.t050545.homework.sport.Competition;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Stack;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * HTMLWriter
 * 
 * @author libricon
 */
public class HTMLWriter implements AthleteWriter {
	
	/** destination file */
	private String outFile;
	/** transformer that transform xml to html form */
	private Transformer transformer;
	
	private String argument = "-html";
	private String description = "Results print in html file";
	
	@Override
	public String getArgum() {
		return argument;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void init(Stack<String> arguments) throws LoadException {
		String fileName = arguments.pop();
		
		try {
			transformer = TransformerFactory.newInstance().newTransformer(
					new StreamSource(HTMLWriter.class.getResource("competition.xslt").getFile()));
		}
		catch (TransformerConfigurationException e) {
			throw new LoadException("Configuration exception occur");
		}
		catch (TransformerFactoryConfigurationError e) {
			throw new LoadException("Factory exception");
		}
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
}
