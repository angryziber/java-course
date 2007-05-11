package net.azib.java.students.t020556.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
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
import org.xml.sax.SAXException;

/**
 * DecathlonResultXmlWriter
 *
 * @author Agu Aarna
 */
public class DecathlonResultXmlWriter implements IDecathlonResultWriter {

	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());

	private URL fileUrl = DecathlonResultXmlWriter.class.getResource("/");
	private URL transformer = DecathlonResultXmlWriter.class.getResource("style.xsl");
	
	private String rootName = "DecathlonResults";
	private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

	/**
	 * @see net.azib.java.students.t020556.homework.IDecathlonResultWriter#writeResults
	 * 		(net.azib.java.students.t020556.homework.IDecathlonResultReader)
	 */
	public void writeResults(IDecathlonResultReader reader) {
		FileOutputStream fos = null;
		try {
			//document
			Document xmlDoc = 
				DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			//root
			Element root = xmlDoc.createElement(rootName);
			xmlDoc.appendChild(root);
			addCompetitors(reader.readResults(), xmlDoc, root);
			
			//xsl
			ProcessingInstruction style = xmlDoc.createProcessingInstruction(
					"xml-stylesheet", "type=\"text/xsl\" href=\"" + transformer + "\"");
			root.getParentNode().insertBefore(style, root);

			//output
			fos = new FileOutputStream(createFileName(fileUrl));

			Source src = new DOMSource(xmlDoc);
			Result res = new StreamResult(fos);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty("indent", "yes");
			
			transformer.transform(src, res);
		}
		catch (FileNotFoundException e) {
			LOG.log(Level.SEVERE, "Specified XML file not found", e);
		}
		catch (TransformerConfigurationException e) {
			LOG.log(Level.SEVERE, "Error creating XML transformer!", e);
		}
		catch (TransformerFactoryConfigurationError e) {
			LOG.log(Level.SEVERE, "Error creating XML transformer!", e);
		}
		catch (TransformerException e) {
			LOG.log(Level.SEVERE, "Transformation failed!", e);
		}
		catch (ParserConfigurationException e) {
			LOG.log(Level.SEVERE, "Unable to create document for XML generation!", e);
		}
		catch (NullPointerException e){
			LOG.log(Level.SEVERE, "Null object referenced!", e);
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
		Element node = creater.createElement(name);
		node.appendChild(creater.createTextNode(value));
		return node;
	}
	
	private String createFileName(URL fileURL){
		try {
			File file = new File(fileUrl.toURI());
			String fName = file.getPath();
			if(file.isDirectory()){
				fName += File.separator + "default.xml";
				LOG.warning("No file set! Using default file name \"" + fName + "\"");
			}
			return fName;
		}
		catch (URISyntaxException e) {
			LOG.log(Level.SEVERE, "Failed creating file name!", e);
			return null;
		}
		
	}
	
	private void addCompetitors(
		PriorityQueue<Competitor> compQ, Document creater, Element root){
		
		if(compQ == null){
			LOG.severe("Unable to read results from the provided reader");
			return;
		}

		Competitor comp = null;
		int i = 1;
		while((comp = compQ.poll()) != null){
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
	
	/**
	 * setFileName sets the file name. The file with that name will be created and in
	 * case xsl transformation transformed into html
	 * 
	 * @author Agu Aarna
	 * 
	 * @param fURL - url representng the file
	 * 
	 * @version 1
	 */
	public void setFile(URL fURL){
		this.fileUrl = fURL;
	}

	/**
	 * transform method transforms the created xml file to an html format. Note that the
	 * xml file has to be already created in order for it to be transformed.
	 * 
	 * @see net.azib.java.students.t020556.homework.DecathlonResultWriter#writeResults
	 * 		(net.azib.java.students.t020556.homework.DecathlonResultReader)
	 * 
	 * @author Agu Aarna
	 * 
	 * @param out - output stream
	 * 
	 * @version 1
	 */
	public void transform(OutputStream out){
		try {
			DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document xml = db.parse(new FileInputStream(createFileName(fileUrl)));
			
			Transformer t = 
				TransformerFactory.newInstance().newTransformer(
					new StreamSource(new FileInputStream(
						createFileName(this.transformer))));
			t.transform(new DOMSource(xml), new StreamResult(out));
		}
		catch (FileNotFoundException e) {
			LOG.log(Level.SEVERE, "Specified XML file not found", e);
		}
		catch (ParserConfigurationException e) {
			LOG.log(Level.SEVERE, "Document builder could not be found!", e);
		}
		catch (SAXException e) {
			LOG.log(Level.SEVERE, "Unable to parse the set XML document", e);
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, "Unable to parse the set document", e);
		}
		catch (TransformerConfigurationException e) {
			LOG.log(Level.SEVERE, "Unable to create transformer", e);
		}
		catch (TransformerFactoryConfigurationError e) {
			LOG.log(Level.SEVERE, "Unable to create transformer", e);
		}
		catch (TransformerException e) {
			LOG.log(Level.SEVERE, "Unable to transform xml", e);
		}
		catch (NullPointerException e){
			LOG.log(Level.SEVERE, "Null object referenced!", e);
		}
	}
}
