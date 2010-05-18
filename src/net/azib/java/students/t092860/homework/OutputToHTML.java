package net.azib.java.students.t092860.homework;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;

/**
 * OutputToHTML
 *
 * @author scythe
 */
class OutputToHTML extends OutputToXML {
	
	private static Logger logger = Logger.getLogger("global");
	
	OutputToHTML(File filepath)
	{
		super(filepath);
		file = filepath;
	}
	
	public void set(List<Data> dataList) throws Exception
	{		
		String stringXML = getXML(dataList);
		InputStream srcXML = new ByteArrayInputStream(stringXML.getBytes("UTF-8"));
		
		InputStream streamXSL = this.getClass().getResourceAsStream("template.xsl");
		StreamSource srcXSL = new StreamSource(streamXSL);
		
		StreamResult trgtHTML = new StreamResult(file);
		TransformerFactory tFactory = TransformerFactory.newInstance();	
		Transformer transformer = tFactory.newTransformer(srcXSL);
		/*transformer.setOutputProperty( OutputKeys.METHOD, "xml");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		transformer.setOutputProperty( OutputKeys.INDENT, "yes");
		transformer.setOutputProperty( OutputKeys.ENCODING, "ISO-8859-1");*/
		
		transformer.transform(new StreamSource(srcXML), trgtHTML);

		logger.info("Output to HTML file success");
	}
	
	private File file;
}
