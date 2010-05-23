package net.azib.java.students.t092860.homework;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Class to write data to HTML file.
 */
public class OutputToHTML extends OutputToXML {
	
	private static Logger logger = Logger.getLogger("global");
	
	/**
	 * Constructor
	 * 
	 * @param out a stream to write data to
	 */
	OutputToHTML(OutputStream out) throws FileNotFoundException {
		super();
		output = out;
	}
	
	/**
	 * Writes list of athletes (with results) to the stream given by the constructor
	 * 
	 * @param dataList list of athletes data (with results)
	 * @throws Exception if data cannot be written.
	 */
	public void set(List<Data> dataList) throws Exception {
		String stringXML = getXML(dataList);
		InputStream stmXML = new ByteArrayInputStream(stringXML.getBytes("UTF-8"));
		StreamSource srcXML = new StreamSource(stmXML);

		InputStream streamXSL = this.getClass().getResourceAsStream("template.xsl");
		StreamSource srcXSL = new StreamSource(streamXSL);

		StreamResult trgtHTML = new StreamResult(output);
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer(srcXSL);
		transformer.setOutputProperty(OutputKeys.METHOD, "html");
		transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

		transformer.transform(srcXML, trgtHTML);

		logger.info("Output to HTML file success");
	}
	
	private OutputStream output;
}
