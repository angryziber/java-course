package net.azib.java.students.t010687.homework;

import java.io.*;
import java.util.*;

import org.w3c.dom.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult; 
import javax.xml.transform.stream.StreamSource;
/**
 * DataExport
 *
 * @author Matu
 */
public class DataExport {
	// Protected Properties
	protected DocumentBuilderFactory domFactory = null;
	protected DocumentBuilder domBuilder = null;
	private List<ResultsOfTheAthlet> results;
	
	public DataExport(List<ResultsOfTheAthlet> results){
		this.results = results;
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
		    String AthletesRanks[] = getAthletesRanks();
		    int i=0;
			for(ResultsOfTheAthlet Result: results){
				try{
					athleteAsElement = newDoc.createElement("athlete");
					//Only data from DB has uniq ID
					if (Result.getId()> 0){athleteAsElement.setAttribute("id", Result.getId().toString());};
					//***
					curElement = newDoc.createElement("rank");
					curElement.appendChild(newDoc.createTextNode(AthletesRanks[i++]));
					athleteAsElement.appendChild(curElement);
					//***
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
					curElement.appendChild(newDoc.createTextNode(Result.getSprint_100m().toString()));
					athleteAsElement.appendChild(curElement);
					//***					
					curElement = newDoc.createElement("longJump");
					curElement.appendChild(newDoc.createTextNode(Result.getLongJump().toString()));
					athleteAsElement.appendChild(curElement);
					//***							
					curElement = newDoc.createElement("shotPut");
					curElement.appendChild(newDoc.createTextNode(Result.getShotPut().toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("highJump");
					curElement.appendChild(newDoc.createTextNode(Result.getHighJump().toString()));
					athleteAsElement.appendChild(curElement);
					//***						
					curElement = newDoc.createElement("sprint400");
					curElement.appendChild(newDoc.createTextNode(Result.getSprint_400m()));
					athleteAsElement.appendChild(curElement);
					//***		
					curElement = newDoc.createElement("hurdles110");
					curElement.appendChild(newDoc.createTextNode(Result.getHurdles_110m().toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("discusThrow");
					curElement.appendChild(newDoc.createTextNode(Result.getDiscusThrow().toString()));
					athleteAsElement.appendChild(curElement);
					//***					
					curElement = newDoc.createElement("poleVault");
					curElement.appendChild(newDoc.createTextNode(Result.getPoleVault().toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("javelinThrow");
					curElement.appendChild(newDoc.createTextNode(Result.getJavelinThrow().toString()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("race1500");
					curElement.appendChild(newDoc.createTextNode(Result.getRace_1500m()));
					athleteAsElement.appendChild(curElement);
					//***	
					curElement = newDoc.createElement("points");
					curElement.appendChild(newDoc.createTextNode(Result.getPoints().toString()));
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
        JFileChooser fc = new JFileChooser(new File(File.separator+"xml"));
        // Show dialog; this method doesn't return until dialog is closed
        fc.showSaveDialog(new JFrame());
        File file = fc.getSelectedFile();
        if (file == null)return;
		// Save the document to the disk file
		try {
			Transformer aTransformer = TransformerFactory.newInstance().newTransformer();
			DOMSource src = getXMLDocContent();
			if (src !=null){
				aTransformer.transform(src,
						new StreamResult(file));
			}		
		}
		catch (TransformerException e) {
			System.err.println(e.toString());
		}
		
	}
	public void saveDataToHTMLFormat(){
        JFileChooser fc = new JFileChooser(new File(File.separator+"html"));
        // Show dialog; this method doesn't return until dialog is closed
        fc.showSaveDialog(new JFrame());
        File file = fc.getSelectedFile();
        if (file == null)return;
		// Save the document to the disk file
		try {
	        Transformer aTransformer =TransformerFactory.newInstance().newTransformer(
	        		new StreamSource("src/net/azib/java/students/t010687/homework/Results.xsl"));
			DOMSource src = getXMLDocContent();
			if (src !=null){
				aTransformer.transform(src,        
						new StreamResult(file)); 
			}
		}
		catch (TransformerException e) {
			System.err.println(e.toString());
		}
	}
	public void saveDataToCSVFormat(){
        JFileChooser fc = new JFileChooser(new File(File.separator+"html"));
        // Show dialog; this method doesn't return until dialog is closed
        fc.showSaveDialog(new JFrame());
        File file = fc.getSelectedFile();
        if (file == null)return;
		// Save the document to the disk file
	    try {
	      FileOutputStream fos = new FileOutputStream(file);
	      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(fos, "UTF-8")));
	      String AthletesRanks[] = getAthletesRanks();
	      int i=0;
	      for(ResultsOfTheAthlet Result: results){
	    	  pw.println(Result.getName() + "," + Result.getDateOfBirth() + ","
	    			  + Result.getCountry() + "," + Result.getSprint_100m().toString() + "," 
	    			  + Result.getLongJump().toString() + "," + Result.getShotPut().toString()+ "," 
	    			  + Result.getHighJump().toString()+ "," + Result.getSprint_400m() + "," 
	    			  + Result.getHurdles_110m().toString()+ "," + Result.getDiscusThrow().toString()+ "," 
	    			  + Result.getPoleVault().toString()+ "," + Result.getJavelinThrow().toString()+ "," 
	    			  + Result.getRace_1500m() + "," + AthletesRanks[i++]+ "," + Result.getPoints().toString());
	      }
	      pw.close();
	    } catch (Exception e) {
	      System.out.println("Exception: " + e);
	    }	  
	}
	public String[] getAthletesRanks() {
    	Collections.sort(results);
    	int newRank = 0;
    	String Ranks[] = new String[results.size()];
    	for(int curRank= 0; curRank< results.size(); curRank++){
    		newRank = setRank(curRank);
    		if (curRank==newRank){
    			Ranks[curRank] = ((Integer)(curRank+1)).toString();}
    		else{
    			for(int i = curRank; i<= newRank; i++){
    				Ranks[i] = (curRank+1) + "-" + (newRank+1);
    			}
    			curRank = newRank;
    		}
    	}	
    	return Ranks; 
    }
    private int setRank(int curRank){
    	if (curRank < results.size() -1){//if next item exists
    		if (results.get(curRank).getPoints()> results.get(curRank +1).getPoints()){
    			return curRank;
    		}
    		else {return setRank(curRank + 1);}
    	}
    	else{return curRank;}
    }
}
