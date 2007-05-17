package net.azib.java.students.t050209.homework;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



/**
 * HandleFileIO
 * This file handles input and output of files.
 *
 * @author Kaupo Laan
 */
public class HandleFileIO {
	
	/**
	 * verifyUserResults verifies inserted data. 
	 * It checkes if the inserted data is for field event or running event.
	 * Depending of this data the inserted String is converted to Double format. 
	 * 
	 * @param dataTempString - user inserted string
	 * 
	 */
	private static Double verifyUserResults(int i, String dataTempString) {
		Double result = 0.0;
		
		if (DecathlonPoints.values()[i].checkIfRunningEvent()){					
			try{
				DateFormat formatter = new SimpleDateFormat("mm:ss.SS");				
				DateFormat finalFormatMinutes = new SimpleDateFormat("mm");
				DateFormat finalFormatSeconds = new SimpleDateFormat("ss.SS");
				
				result = Double.parseDouble(finalFormatMinutes.format(formatter.parse(dataTempString))) * 60 +
						 Double.parseDouble(finalFormatSeconds.format(formatter.parse(dataTempString)));
			}
			catch (ParseException e){
				try{
					DateFormat formatter = new SimpleDateFormat("ss.SS");				
					
					result = Double.parseDouble(formatter.format(formatter.parse(dataTempString)));
				}
				catch(ParseException pe) {
					System.out.println("Data in invalid format");					
				}
			}
		}
		else{
			try{
				result = Double.parseDouble(dataTempString);
			}
			catch (Exception e){
				System.out.println("Data in invalid format");
			}
		}		
		return result;
	}	
	
	/**
	 * Handles comma separeted values file (CSV) input 
	 * 
	 * At first, the CSV file location is asked.
	 * Then the data is read and verified.
	 * Finally the file is closed.
	 * 
	 * @param dataTempString - user inserted string
	 * 
	 */
	public static List<Sportsman> handleCSVInput() {
		List<Sportsman> sportsmanList = new LinkedList<Sportsman>();
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					                new FileInputStream(HandleDecathlonIO.insertFilePath()), "UTF-8"));			
			String line = null;
			
			while((line = in.readLine()) != null)
			{
				Sportsman sportsman = new Sportsman();
				StringTokenizer st = new StringTokenizer(line, ",");
				while (st.hasMoreTokens())
				{
					// Read sportsman name
					sportsman.setSportsmanName(st.nextToken());
					
					// Read sportsman date of birth
					DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
					try{
						sportsman.setSportsmanDateOfBirth((String)df.parse(st.nextToken()).toString());
					}
					catch(ParseException e){
						System.out.println("Data in illegal format");
					}
					
					// Read sportsman country code
					String countryCodeTempString = st.nextToken();
					try{
						countryCodeTempString.equals(Locale.getISOCountries());
						sportsman.setSportsmanCountry(countryCodeTempString);
					}
					catch (Error e){
						System.out.println("Country code doesnt't exist");
					}
					
					// Read sportsman results
					String  dataTempString;
					List<Double> results = new LinkedList<Double>();
					
					for (int i = 0; i < 10; i++) {
						dataTempString = st.nextToken();
						try{
							results.add(verifyUserResults(i, dataTempString));
							sportsman.setSportsmanResults(results);
						}
						catch(Error e){
							System.out.println("Data invalid format");
						}
					}
					sportsman.calculateAndStoreSportsmanScore();
					sportsmanList.add(sportsman);
				}
			} 
			// close the file
			in.close(); 
	        	        
		}
		catch (IOException e) {
			System.out.println("Data read failed");			
		}
		return sportsmanList;
	}

	/**
	 * Handles comma separeted values file (CSV) output 
	 * 
	 * At first, the CSV file location is asked.
	 * Then the data is written and verified.
	 * Finally the file is closed.
	 * 
	 * 
	 */
	public static void handleCSVOutput(List<Sportsman> sportsmanList){
		String filePath = "";
		do {
			System.out.println("Insert output CSV file data path");
			try{
				filePath = HandleDecathlonIO.insertFilePath();
			}
			catch (IOException e){
				System.out.println("File path insertion error");
			}			
		} while (!filePath.endsWith(".csv"));
		
		try{
			BufferedWriter bufWrtr = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filePath), "UTF-8"));
			
			Integer position = 0;
			int step = 1;
			int lastScore = 0;

			for (Sportsman sm : sportsmanList) {
				String outputString = new String();
				String resultString = new String();

				// find places for sportsmen
				if (sm.overallResult.equals(lastScore))
					step++;
				else {
					position += step;
					step = 1;
				}

				// Create result string for CSV
				for (Double res : sm.results)
					resultString = resultString + res.toString() + ",";
				// Put together string for output
				outputString = position.toString() + "," + sm.name + ","
						+ sm.dateOfBirth.toString() + "," + sm.country + ","
						+ resultString + sm.overallResult.toString() + "\r\n";

				// Remember last score
				lastScore = sm.overallResult;

				try {
					// Write result to output
					bufWrtr.write(outputString);
				} catch (IOException e) {
					//LOG.debug("Results could not be parsed: " + e);
					System.err.println("Results could not be parsed: " + e);
					// e.printStackTrace();
				}
			}
			try{
				bufWrtr.close();
			}
			catch (IOException e){
				System.out.println("Closing file failed");
			}
		}
		catch (FileNotFoundException fnfe){
			System.out.println("Cannot find file specified");
		}
		catch (UnsupportedEncodingException uee){
			System.out.println("Unsupported encoding!");
		}
	}

	/**
	 * Handles XML file output 
	 * 
	 * The document is builded using DocumentBuilder.
	 * If the file path was not predefined, the file path is asked.
	 * Finally, the file is written.
	 * 
	 * 
	 * @param pathDefined - boolean value to indicate wheather it is needed to ask the file path or not
	 * @param path - path of the XML file
	 * 
	 */
	public static void handleXMLOutput(List<Sportsman> sportsmanList, boolean pathDefined, String path) 
													   throws ParserConfigurationException, 
													          TransformerConfigurationException,
													          TransformerException{
		String filePath = "";
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = db.newDocument();
		
		//Document document = new DocumentImpl();
		// Create root element
		Element root = document.createElement("Sportsmen");
		document.appendChild(root);
		
		// Variables to handle positioning
		Integer place = 0;
		int step = 1;
		int lastScore = 0;

		for (Sportsman sm : sportsmanList) {
			
			// find places for sportsmen
			if (sm.overallResult.equals(lastScore))
				step++;
			else {
				place = place + step;
				step = 1;
			}

			Element sportsman = document.createElement("Sportsman");
			//root.appendChild(sportsman);
			
			Element position = document.createElement("Position");
			sportsman.appendChild(position).setTextContent(place.toString());
			
			Element name = document.createElement("Name");
			sportsman.appendChild(name).setTextContent(sm.name);
			
			Element dateOfBirth = document.createElement("Date-of-Birth");
			sportsman.appendChild(dateOfBirth).setTextContent(sm.dateOfBirth);
			
			Element country = document.createElement("Country");
			sportsman.appendChild(country).setTextContent(sm.country);
			
			Element result = document.createElement("Results");
			
			Element run100m = document.createElement("Run-100-m");
			result.appendChild(run100m).setTextContent(sm.results.get(0).toString());
			
			Element longjump = document.createElement("Long-jump");
			result.appendChild(longjump).setTextContent(sm.results.get(1).toString());
			
			Element shotput = document.createElement("Shot-put");
			result.appendChild(shotput).setTextContent(sm.results.get(2).toString());
			
			Element highjump = document.createElement("High-jump");
			result.appendChild(highjump).setTextContent(sm.results.get(3).toString());
			
			Element run400m = document.createElement("Run-400-m");
			result.appendChild(run400m).setTextContent(sm.results.get(4).toString());
			
			Element hurdles = document.createElement("Hurdles");
			result.appendChild(hurdles).setTextContent(sm.results.get(5).toString());
			
			Element discus = document.createElement("Discus-throw");
			result.appendChild(discus).setTextContent(sm.results.get(6).toString());
			
			Element polevault = document.createElement("Pole-vault");
			result.appendChild(polevault).setTextContent(sm.results.get(7).toString());
			
			Element javelin = document.createElement("Javelin-throw");
			result.appendChild(javelin).setTextContent(sm.results.get(8).toString());
			
			Element run1500m = document.createElement("Run-1500-m");
			result.appendChild(run1500m).setTextContent(sm.results.get(9).toString());
			
			sportsman.appendChild(result);
			
			Element overallResult = document.createElement("Overall-result");
			sportsman.appendChild(overallResult).setTextContent(sm.overallResult.toString());

			root.appendChild(sportsman);
			
			// Remember last score
			lastScore = sm.overallResult;			
		}
		//document.appendChild(root);
		
		if(pathDefined == false){
			do {
				System.out.println("Insert output XML file data path");
				try{
					filePath = HandleDecathlonIO.insertFilePath();
				}
				catch (IOException e){
					System.out.println("File path insertion error");
				}			
			} while (!filePath.endsWith(".xml"));
		}
		else
			filePath = path;
		
		TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        Source src = new DOMSource(document);
        Result dest = new StreamResult(new File(filePath));
        t.transform(src, dest);
        System.out.println("writing data completed");
    }

	
	/**
	 * Handles HTML file output 
	 * 
	 */
	public static void handleHTMLOutput(List<Sportsman> sportsmanList){
		String filePathHTML ="";
		String filePathXML = "";
		String filePathXSL = "";
		
		filePathHTML = "";
		do {
			System.out.println("Insert output HTML file data path");
			try{
				filePathHTML = HandleDecathlonIO.insertFilePath();
			}
			catch (IOException e){
				System.out.println("File path insertion error");
			}			
		} while (!filePathHTML.endsWith(".html"));
		
		filePathXML = filePathHTML.replace(".html", ".xml");
		
		try{
			HandleDecathlonIO.createFile(filePathHTML);
			HandleDecathlonIO.createFile(filePathXML);
		}
		catch(Exception e){			
		}
		
		try{
			handleXMLOutput(sportsmanList, true, filePathXML);
		}
		catch (TransformerException te){
			System.out.println("TransformerException in handleHTMLOutput");
		}
		catch (ParserConfigurationException pce){
			System.out.println("ParserConfigurationException in handleHTMLOutput");
		}
		
		Source XMLSource = new StreamSource(filePathXML);
		
		do {
			System.out.println("To create HTML, insert the XSL file path!");
			try{
				filePathXSL = HandleDecathlonIO.insertFilePath();
			}
			catch (IOException e){
				System.out.println("File path insertion error");
			}			
		} while (!filePathXSL.endsWith(".xsl"));
		
		Source XSLSource = new StreamSource(filePathXSL);		
		
		Result outPut = null;
		try {
			outPut = new StreamResult(new OutputStreamWriter(new FileOutputStream(filePathHTML), "UTF-8"));
		} 
		catch (UnsupportedEncodingException e){
		} 
		catch (FileNotFoundException e){
		}
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = null;
		try {
			// Define transform
			t = tf.newTransformer(XSLSource);
		} 
		catch (TransformerConfigurationException tce) {
			System.out.println("TransformerConfigurationException in handleHTMLOutput");
		}
		try {			
			t.transform(XMLSource, outPut);
		} 
		catch (TransformerException te){
			System.out.println("TransformerException in handleHTMLOutput");
		}
	}
}
