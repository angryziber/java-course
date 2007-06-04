package net.azib.java.students.t010687.homework;
import java.io.*;
import java.util.*;
import org.w3c.dom.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
import javax.xml.transform.stream.StreamSource;
/**
 * Results2XML
 *
 * @author Matu
 */
public class Results2XML {
	// Protected Properties
	protected DocumentBuilderFactory domFactory = null;
	protected DocumentBuilder domBuilder = null;
	private List<ResultsOfTheAthlet> Results;
	
	public Results2XML(List<ResultsOfTheAthlet> Results){
		this.Results = Results;
	}
	private DOMSource getXMLDocContent(){
		try{
			domFactory = DocumentBuilderFactory.newInstance();
			domBuilder = domFactory.newDocumentBuilder();
			Document newDoc = domBuilder.newDocument();
			Element rootElement = newDoc.createElement("DecathlonCompetitionResults");
			Element athleteAsElement;
			Element curElement;
			newDoc.appendChild(rootElement);
			for(ResultsOfTheAthlet Result: Results){
				try{
					athleteAsElement = newDoc.createElement("athlete");
					//Only data from DB has uniq ID
					if (Result.getId()> 0){athleteAsElement.setAttribute("id", Result.getId().toString());};
					
					curElement = newDoc.createElement("name");
					curElement.appendChild(newDoc.createTextNode(Result.getName()));
					athleteAsElement.appendChild(curElement);
					//***
					curElement = newDoc.createElement("dob");
					curElement.appendChild(newDoc.createTextNode(Result.getDateOfBirth()));
					athleteAsElement.appendChild(curElement);
					//***
					curElement = newDoc.createElement("country");
					curElement.appendChild(newDoc.createTextNode(Result.getCountry()));
					athleteAsElement.appendChild(curElement);
					//***
					curElement = newDoc.createElement("sprint100");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getSprint_100m()).toString()));
					athleteAsElement.appendChild(curElement);
					//***					
					curElement = newDoc.createElement("longJump");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getLongJump()).toString()));
					athleteAsElement.appendChild(curElement);
					//***							
					curElement = newDoc.createElement("shotPut");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getShotPut()).toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("highJump");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getHighJump()).toString()));
					athleteAsElement.appendChild(curElement);
					//***						
					curElement = newDoc.createElement("sprint400");
					curElement.appendChild(newDoc.createTextNode(Result.getSprint_400m()));
					athleteAsElement.appendChild(curElement);
					//***		
					curElement = newDoc.createElement("hurdles110");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getHurdles_110m()).toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("discusThrow");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getDiscusThrow()).toString()));
					athleteAsElement.appendChild(curElement);
					//***					
					curElement = newDoc.createElement("poleVault");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getPoleVault()).toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("javelinThrow");
					curElement.appendChild(newDoc.createTextNode(((Float)Result.getJavelinThrow()).toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("race1500");
					curElement.appendChild(newDoc.createTextNode(Result.getRace_1500m()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("points");
					curElement.appendChild(newDoc.createTextNode(((Long)Result.getPoints()).toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					rootElement.appendChild(athleteAsElement);
				}
				catch(Exception exp){
				}
			}
			return new DOMSource(newDoc);
		}
		catch(FactoryConfigurationError exp){
			System.err.println(exp.toString());
			return null;
		}
		catch(ParserConfigurationException exp){
			System.err.println(exp.toString());
			return null;
		}
		catch(Exception exp){
			System.err.println(exp.toString());
			return null;
		}
	}
	
	public void saveDataToXMLFormat(){
		// Save the document to the disk file
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		try {
			Transformer aTransformer = tranFactory.newTransformer();
			DOMSource src = getXMLDocContent();
			if (src !=null){
				aTransformer.transform(src,
						new StreamResult(new File("C:\\Minu.xml")));
			}
		}
		catch (TransformerException e) {
			System.err.println(e.toString());
		}
		
	}
	public void saveDataToHTMLFormat(){
		// Save the document to the disk file
		TransformerFactory tranFactory = TransformerFactory.newInstance();
		try {
	        Transformer aTransformer =tranFactory.newTransformer(new StreamSource("src/net/azib/java/students/t010687/homework/Results.xsl"));
			DOMSource src = getXMLDocContent();
			if (src !=null){
				aTransformer.transform(src,        
	        	new StreamResult(new FileOutputStream("C:\\Proov.html")));       
			}
		}
		catch (TransformerException e) {
			System.err.println(e.toString());
		}
		catch (FileNotFoundException e) {
			System.err.println(e.toString());
		}
		
	}
}
