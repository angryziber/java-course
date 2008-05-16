package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.IDataWriter;
import net.azib.java.students.t030604.homework.domain.AthleteScore;

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
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class HtmlWriter extends AbstractWriter implements IDataWriter {
	
	private FileWriter fileWriter;
	private Transformer transformer;

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#cleanup()
	 */
	public void cleanup() throws WriterException {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#output(java.util.List)
	 */
	public void output(List<AthleteScore> results) throws WriterException {
		try {
			Document doc = new XmlWriter().generateDocument(results);
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

	/* (non-Javadoc)
	 * @see main.java.homework.IDataWriter#setup(java.lang.String[])
	 */
	public void setup(String... args) throws WriterException {
		try {
		fileWriter = new FileWriter(new File("output.html"));
		transformer = 
			TransformerFactory.newInstance()
				.newTransformer(new StreamSource(getClass().getClassLoader().getResourceAsStream("default.xsl")));
		
		} catch (TransformerConfigurationException fatal) {
			throw new WriterException("could not initialize writer", fatal);
		} catch (IOException fatal) {
			throw new WriterException("could not initialize writer", fatal);
		}
	}

}
