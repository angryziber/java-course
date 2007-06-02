package net.azib.java.students.t030655.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.PriorityQueue;

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


/**
 * DecathlonOutputWriter - provides methods to write to console, file, XML-file and HTML-file.
 *
 * @author Triin Nestor
 */
public class DecathlonOutputWriter {
	
	/**
	 * Extracts data from PriorityQueue of competitors and writes to console. 
	 * 
	 * @param pq - PriorityQueue of competitors
	 */
	public void writeToConsole (PriorityQueue<Competitor> pq){
		PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>(pq);
		Competitor comp = null;
		while ((comp = compQueue.poll()) != null){
			System.out.println(comp.getPlace() + comp.getTotalPoints() + " points - " + comp.getName() + ", " + comp.getDateOfBirth() + ", " + comp.getCountry());
			double[] results = new double[10];
			results = comp.getResults();
			System.out.print("Results:");
			for (int i=0; i<10; i++){
				System.out.print("  " + results[i]);	
			}
			System.out.println("\n");
		}
		
	}
	
	/**
	 * Method extracts data form PriorityQueue of competitors and writes into file.
	 * 
	 * @param filename - string of file name with path
	 * @param pq - PriorityQueue of competitors
	 */
	public void writeToFile (String filename, PriorityQueue<Competitor> pq){
		PriorityQueue<Competitor> compQueue = new PriorityQueue<Competitor>(pq);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filename);
			PrintStream printStream = new PrintStream(out, true, "UTF-8");
			for (Competitor comp : compQueue){
				printStream.println(comp.getString().replace(" ", ","));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to write to file!");
			e.printStackTrace();
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding!");
			e.printStackTrace();
		}
		finally {
			try {
				out.close();
			}
			catch (IOException e) {
				System.out.println("Unable to close stream!");
				e.printStackTrace();
			}
		}

	}
	
	/**
	 * Method creates XML or HTML file according to the parameter outId. If outId is 0, 
	 * then destination is XML file. Otherwise, destination is HTML file. 
	 * 
	 * @param outId - id to select output type
	 * @param file - file name with path
	 * @param pq
	 */
	public void writeToXmlOrHtml (int outId, String file, PriorityQueue<Competitor> pq){
		Document xmlDoc = createDocument(pq);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			Source src = new DOMSource(xmlDoc);
			Result res = new StreamResult(out);
			Transformer transformer;
				if (outId == 0){
					transformer = TransformerFactory.newInstance().newTransformer();
					transformer.setOutputProperty("indent", "yes");
				}
				else{
					File xsl = new File(DecathlonOutputWriter.class.getResource("style.xsl").toURI());
					transformer = TransformerFactory.newInstance().newTransformer(new StreamSource
							(new FileInputStream(xsl)));
				}
				transformer.transform(src, res);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
			e.printStackTrace();
		}
		catch (TransformerConfigurationException e) {
			System.out.println("Error in creating transformer!");
			e.printStackTrace();
		}
		catch (TransformerFactoryConfigurationError e) {
			System.out.println("Error in creating transformer!");
			e.printStackTrace();
		}
		catch (URISyntaxException e) {
			System.out.println("Incorrect URI!");
			e.printStackTrace();
		}
		catch (TransformerException e) {
			System.out.println("Transformation failed!");
			e.printStackTrace();
		}
		
	}
	
	private Document createDocument (PriorityQueue<Competitor> pq){
		
		//creating document
		Document xmlDocument = null;
		try {
			xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		}
		catch (ParserConfigurationException e) {
			System.out.println("Unable to create XML document model!");
			e.printStackTrace();
		}
		Element rootElement = xmlDocument.createElement("DecathlonResults");
		xmlDocument.appendChild(rootElement);
		
		//adding elements to rootElement
		PriorityQueue<Competitor> competitorsQueue = new PriorityQueue<Competitor>(pq);
		Competitor competitor = null;
		while ((competitor = competitorsQueue.poll()) != null){
			Element xmlElement = xmlDocument.createElement("Competitor");
			rootElement.appendChild(xmlElement);
			xmlElement.appendChild(createNode("Place", competitor.getPlace().replace(" ", ""), xmlDocument));
			xmlElement.appendChild(
					createNode("Points", Integer.toString(competitor.getTotalPoints()), xmlDocument));
			xmlElement.appendChild(createNode("Name", competitor.getName(), xmlDocument));
			xmlElement.appendChild(
					createNode("DateOfBirth", competitor.getDateOfBirth(), xmlDocument));
			xmlElement.appendChild(createNode("Country", competitor.getCountry(), xmlDocument));
			
			Element xmlSubElement = xmlDocument.createElement("Results");
			xmlElement.appendChild(xmlSubElement);
			double[] masResults = competitor.getResults();
			xmlSubElement.appendChild(
					createNode("Sprint100m", Double.toString(masResults[0]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("LongJump", Double.toString(masResults[1]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("ShotPut", Double.toString(masResults[2]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("HighJump", Double.toString(masResults[3]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("Sprint400m", Double.toString(masResults[4]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("Hurdles110m", Double.toString(masResults[5]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("DiscusThrow", Double.toString(masResults[6]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("PoleVault", Double.toString(masResults[7]),	xmlDocument));
			xmlSubElement.appendChild(
					createNode("JavelinThrow", Double.toString(masResults[8]), xmlDocument));
			xmlSubElement.appendChild(
					createNode("Race1500m", Double.toString(masResults[9]), xmlDocument));
			
		}
		return xmlDocument;
	}
	
	private Element createNode(String name, String value, Document xmlDoc){
		Element node = xmlDoc.createElement(name);
		node.appendChild(xmlDoc.createTextNode(value));
		return node;
	}
}
