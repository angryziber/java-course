package net.azib.java.students.t020556.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

/**
 * DecathlonResultXmlWriter
 *
 * @author Agu Aarna
 */
public class DecathlonResultXmlWriter implements IDecathlonResultWriter {

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	private String fName = "default.xml";
	private String rootName = "DecathlonResults";
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#writeResults
	 * 		(net.azib.java.students.t020556.homework.IDecathlonResultReader)
	 */
	public void writeResults(IDecathlonResultReader reader) {
		Document xmlDoc = new DocumentImpl();
		Element root = xmlDoc.createElement(rootName);
		
		PriorityQueue<Competitor> compQ = reader.readResults();
		if(compQ == null){
			LOG.severe("Unable to read results from the provided reader");
			return;
		}
		
		Competitor comp = null;
		int i = 1;
		while((comp = compQ.poll()) != null){
			Element xmlComp = xmlDoc.createElementNS(null, "Competitor");
			
			//place
			xmlComp.appendChild(createNode("Place", "" + (i++), xmlDoc));
			
			//name
			xmlComp.appendChild(createNode("Name", comp.getName(), xmlDoc));

			//Date of birth
			xmlComp.appendChild(
				createNode("DateOfBirth", formatter.format(comp.getDateOfBirth()), xmlDoc));

			//Locale
			xmlComp.appendChild(
				createNode("Country", comp.getLocale().toString().toUpperCase(), xmlDoc));
			
			//score
			xmlComp.appendChild(
				createNode("Score", "" + Math.round(comp.getFinalResult()), xmlDoc));
			
			//results
			String[] results = comp.getResults();
			int j = 0;
			for(DecathlonEvent field : DecathlonEvent.values()){
				xmlComp.appendChild(createNode(field.name(), results[j++], xmlDoc));
			}
			root.appendChild(xmlComp);			
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fName);
			OutputFormat of = new OutputFormat("XML", "UTF-8", true);
			
			XMLSerializer ser = new XMLSerializer(fos, of);
			ser.asDOMSerializer();
			ser.serialize(root);
		}
		catch (FileNotFoundException e) {
			LOG.log(Level.SEVERE, "Error working with file " + fName, e);
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, "Error with IO!", e);
		}
		finally{
			try {
				fos.close();
			}
			catch (IOException e) {
				//shouldn't happen
			}
		}		
	}
	
	private Element createNode(String name, String value, Document creater){
		Element node = creater.createElementNS(null, name);
		node.appendChild(creater.createTextNode(value));
		return node;
	}
	
	/**
	 * setStream method obtains the stream but does not handle it's state in any way
	 * so the stream has to be closed by the caller
	 * 
	 * @author Agu Aarna
	 * 
	 * @param out - output stream
	 * 
	 * @version 1
	 */
	public void setFileName(String fName){
		this.fName = fName;
	}

	public void transform(OutputStream out){
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputStream in = DecathlonResultStreamWriter.class.getResourceAsStream(fName);
			Document xml = db.parse(in);
			
			Transformer t = TransformerFactory.newInstance().newTransformer(new StreamSource(in));
			t.transform(new DOMSource(xml), new StreamResult(out));
			
			XPath xpath = XPathFactory.newInstance().newXPath();
			System.out.println(xpath.evaluate("/", xml));
		}
		catch (ParserConfigurationException e) {
			LOG.log(Level.SEVERE, "Document builder could not be found!", e);
		}
		catch (SAXException e) {
			LOG.log(Level.SEVERE, "Unable to parse the set document " + fName, e);
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to parse the set document " + fName, e);
		}
		catch (TransformerConfigurationException e) {
			LOG.log(Level.SEVERE, "Unable to create transformer", e);
		}
		catch (TransformerFactoryConfigurationError e) {
			LOG.log(Level.SEVERE, "Unable to create transformer", e);
		}
		catch (TransformerException e) {
			LOG.log(Level.SEVERE, "Unable to transform xml " + fName, e);
		}
		catch (XPathExpressionException e) {
			LOG.log(Level.SEVERE, "Unable to evaluate XPATH for root element", e);
		}
	}
}
