package net.azib.java.students.t020556.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

/**
 * DecathlonResultXmlWriter
 *
 * @author Agu Aarna
 */
public class DecathlonResultXmlWriter implements IDecathlonResultWriter {

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	private URL htmlTransformer = DecathlonResultXmlWriter.class.getResource("style.xsl");
	private OutputStream out = null;
	private boolean isXmlFormat = true;
	
	private String rootName = "DecathlonResults";
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#writeResults
	 * 		(net.azib.java.students.t020556.homework.IDecathlonResultReader)
	 */
	public void writeResults(IDecathlonResultReader reader) {
		writeResults(reader.readResults());
	}
	
	/**
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#
	 * 		writeResults(java.util.PriorityQueue)
	 */
	public void writeResults(PriorityQueue<Competitor> compQ) {
		if(out == null){
			LOG.severe("Output stream not set! Unable to write formatted data!");
			return;
		}
		
		try {
			Document xmlDoc = buildDocument(compQ);

			Source src = new DOMSource(xmlDoc);
			Result res = new StreamResult(out);
			
			Transformer transformer = null;
			if(isXmlFormat){
				transformer = TransformerFactory.newInstance().newTransformer();
				transformer.setOutputProperty("indent", "yes");
			}
			else{
				File xsl = new File(this.htmlTransformer.toURI());
				transformer = TransformerFactory.newInstance().newTransformer(
						new StreamSource(new FileInputStream(xsl)));
			}
			
			transformer.transform(src, res);
		}
		catch (FileNotFoundException e) {
			LOG.log(Level.SEVERE, "XSL transformer " + this.htmlTransformer + " file not found", e);
		}
		catch (TransformerConfigurationException e) {
			LOG.log(Level.SEVERE, "Error creating XML htmlTransformer!", e);
		}
		catch (TransformerFactoryConfigurationError e) {
			LOG.log(Level.SEVERE, "Error creating XML htmlTransformer!", e);
		}
		catch (TransformerException e) {
			LOG.log(Level.SEVERE, "Transformation failed!", e);
		}
		catch (NullPointerException e){
			LOG.log(Level.SEVERE, "Null object referenced!", e);
		}
		catch (URISyntaxException e) {
			LOG.log(
				Level.SEVERE, 
				"XSL transformer " + this.htmlTransformer + " file URI is malformed", 
				e);
		}
	}

	private Document buildDocument(PriorityQueue<Competitor> compQ){
		try {
			//document
			Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			//root
			Element root = xmlDoc.createElement(rootName);
			xmlDoc.appendChild(root);
			addCompetitors(compQ, xmlDoc, root);
			
			//xsl
			ProcessingInstruction style = xmlDoc.createProcessingInstruction(
					"xml-stylesheet", "type=\"text/xsl\" href=\"" + htmlTransformer + "\"");
			root.getParentNode().insertBefore(style, root);
			
			return xmlDoc;
		}
		catch (ParserConfigurationException e) {
			LOG.log(Level.SEVERE, "Unable to create document for XML generation!", e);
			return null;
		}
	}

	private void addCompetitors(
		PriorityQueue<Competitor> compQ, Document creater, Element root){
		
		if(compQ == null){
			LOG.severe("Unable to read results from the provided reader");
			return;
		}

		PriorityQueue<Competitor> compQLocal = new PriorityQueue<Competitor>(compQ);
		Competitor comp = null;
		int i = 1;
		while((comp = compQLocal.poll()) != null){
			Element xmlComp = creater.createElement("Competitor");
			
			//place
			xmlComp.appendChild(createNode("Place", "" + (i++), creater));
			
			//name
			xmlComp.appendChild(createNode("Name", comp.getName(), creater));

			//Date of birth
			xmlComp.appendChild(
				createNode("DateOfBirth", formatter.format(comp.getDateOfBirth()), creater));

			//Locale
			xmlComp.appendChild(
				createNode("Country", comp.getLocale().toString().toUpperCase(), creater));
			
			//score
			xmlComp.appendChild(
				createNode("Score", "" + Math.round(comp.getFinalResult()), creater));
			
			//results
			String[] results = comp.getResults();
			int j = 0;
			for(DecathlonEvent field : DecathlonEvent.values()){
				xmlComp.appendChild(createNode(field.name(), results[j++], creater));
			}
			root.appendChild(xmlComp);	
		}		
	}
		
	private Element createNode(String name, String value, Document creater){
		Element node = creater.createElement(name);
		node.appendChild(creater.createTextNode(value));
		return node;
	}
	
	/**
	 * setStream sets the output stream. 
	 * 
	 * @author Agu Aarna
	 * 
	 * @param out - the required output stream
	 * 
	 * @version 1
	 */
	public void setStream(OutputStream out){
		this.out = out;
	}
	
	/**
	 * with setFormat method you can specify the format of the output.
	 * 
	 * @author Agu Aarna
	 * 
	 * @param xmlFormat - 
	 * 		<ul>
	 * 			<li><b>true</b> - the output will be in xml format</li>
	 * 			<li><b>false</b> - the output will be in html format</li>
	 * 		</ul>
	 */
	public void setFormat(boolean xmlFormat){
		this.isXmlFormat = xmlFormat;
	}
}
