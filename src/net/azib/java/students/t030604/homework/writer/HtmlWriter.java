package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

import org.dom4j.Document;
import org.dom4j.io.DocumentResult;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.HTMLWriter;
import org.dom4j.io.OutputFormat;
import org.xml.sax.SAXException;

/**
 * HTML writer - outputs everything to a valid Strict 1.0 XHTML file
 * 
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class HtmlWriter extends AbstractWriter implements IDataWriter {
	
	private FileWriter fileWriter;
	private Transformer transformer;

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#cleanup()
	 * {@inheritDoc}
	 */
	public void cleanup() throws WriterException {
		if (fileWriter != null) {
			try {
				fileWriter.close();
			} catch (IOException fatal) {
				throw new WriterException("cleanup failed", fatal);
			}
		}
	}

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#output(java.util.List)
	 * {@inheritDoc}
	 */
	public void output(List<AthleteScore> results) throws WriterException {
		try {
			Document doc = XmlWriter.generateDocument(results);
			DocumentSource source = new DocumentSource(doc);
			DocumentResult result = new DocumentResult(); 
			transformer.transform(source, result);
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			format.setXHTML(true);
			
			HTMLWriter writer = new HTMLWriter(fileWriter, format);
			try {
				writer.startDTD("html", "-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
				writer.endDTD();
			} catch (SAXException ignored) {}
			Document transformed = result.getDocument();
			transformed.setXMLEncoding("utf-8");
			writer.write(transformed);
			writer.flush();
		} catch (IOException fatal) {
			throw new WriterException("could not output results", fatal);
		} catch (TransformerException fatal) {
			fatal.printStackTrace();
			throw new WriterException("problem occured in xsl file", fatal);
		}
	}

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataWriter#setup(java.lang.String[])
	 * {@inheritDoc}
	 */
	public void setup(String... args) throws WriterException {
		if (args == null || args.length == 0) {
			throw new WriterException("call to this writer must contain parameters", null);
		}
		try {
			fileWriter = new FileWriter(new File(args[0]));
			StreamSource stream = new StreamSource(
					getClass().getClassLoader().getResourceAsStream("net/azib/java/students/t030604/homework/default.xsl"));
			if (stream == null || stream.getInputStream() == null) {
				throw new WriterException("default.xsl could not be located", null);
			}
			transformer = TransformerFactory.newInstance().newTransformer(stream);
		
		} catch (TransformerConfigurationException fatal) {
			throw new WriterException("Transformer configuration failed, is xsl file OK?", fatal);
		} catch (IOException fatal) {
			throw new WriterException("could not initialize writer", fatal);
		}
	}

}
