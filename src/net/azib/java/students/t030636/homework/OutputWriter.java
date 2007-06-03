package net.azib.java.students.t030636.homework;

import java.io.*;
import java.util.ArrayList;
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
import org.w3c.dom.Document;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import com.sun.org.apache.xml.internal.serialize.*;

/**
 * OutputWriter
 * Writer class for decathlon results
 *
 * @author Martin
 */
public class OutputWriter {
	
	/**
	 * writeToFile method outputs the decathlon results to a text file.
	 * 
	 * @version 1.1
	 * @param filename - filename for the output file
	 * @param listToOutput - sorted ArrayList of competitors to output. 
	 */
	public void writeToFile (String filename, ArrayList<Competitor> listToOutput) {
//		int place = 1;
//		int previousPoints = 0;
		int index = 0;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error while writing to file");
			System.exit(0);
		}           	
		PrintStream p = null;
		try {
			p = new PrintStream(out,true,"UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Encoding not supported");
			System.exit(0);
		}
		for(Competitor c : listToOutput) {
			index = listToOutput.indexOf(c);
			PlacesForDecathletes pfd = new PlacesForDecathletes();
			String [] s = pfd.returnArrayOfPlaces(listToOutput);
			p.println(s[index] + ". " +c.toString());
//			if (c.score == previousPoints){ //previous score was the same
//				count ++;
//				place = place - count;
//				p.println(place + ". " +c.toString());
//				place = place + count + 1;
//			}
//			else { //previous score was different
//				count = 0;
//				p.println(place + ". " +c.toString());
//				place ++;
//			}
//			previousPoints = c.score;
		}
	}
	
	/**
	 * writeToConsole method outputs the decathlon results to the console.
	 * 
	 * @version 1.1
	 * @param listToOutput - sorted ArrayList of competitors to output. 
	 */
	public void writeToConsole (ArrayList<Competitor> listToOutput) {
//		int place = 1;
		int index = 0;
//		int previousPoints = 0;
		PrintStream p = null;
		try {
			p = new PrintStream(System.out,true,"UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Encoding not supported");
			System.exit(0);
		}
		p.println("DECATHLON RESULTS:");
		for(Competitor c : listToOutput) {
			index = listToOutput.indexOf(c);
			PlacesForDecathletes pfd = new PlacesForDecathletes();
			String [] s = pfd.returnArrayOfPlaces(listToOutput);
			p.println(s[index] + ". " +c.toString());
//			if (c.score == previousPoints){
//				count++;
//				place = place - count;
//				p.println(place + ". " +c.toString());
//				place = place + count+1;
//			}
//			else {
//				count = 0;
//				p.println(place + ". " +c.toString());
//				place ++;
//			}
//			previousPoints = c.score;
		}
	}
	/**
	 * writeToXML method outputs the decathlon results to a XML file.
	 * 
	 * @version 1.1
	 * @param filename - filename for the output XML file
	 * @param listToOutput - sorted ArrayList of competitors to output. 
	 */
	public void writeToXML (String filename, ArrayList<Competitor> listToOutput) {
//		Integer place = 1;
//		Integer count = 0;
//		Integer previousPoints = 0;
		int index = 0;
		PlacesForDecathletes pfd = new PlacesForDecathletes();
		String [] s = pfd.returnArrayOfPlaces(listToOutput);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(filename);
		}
		catch (FileNotFoundException e) {
			System.out.println("Error while writing to file");
			System.exit(0);
		}            	
		PrintStream p = null;
		try {
			p = new PrintStream(out,true,"UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Encoding not supported");
			System.exit(0);
		}
		
		// XERCES 1 or 2 additionnal classes.
		OutputFormat of = new OutputFormat("XML","UTF-8",true);
		of.setIndent(1);
		of.setIndenting(true);
		of.setDoctype(null,OutputWriter.class.getResource("decathlon.dtd").toString());
		XMLSerializer serializer = new XMLSerializer(p,of);
		// SAX2.0 ContentHandler.
		ContentHandler hd = null;
		try {
			hd = serializer.asContentHandler();
		}
		catch (IOException e) {
			System.out.println("Serialization not supperted");
			System.exit(0);
		}
		try {
			hd.startDocument();
			
			AttributesImpl atts = new AttributesImpl();

			hd.startElement("","","DECATHLON",atts);
			for(Competitor c : listToOutput) {
				index = listToOutput.indexOf(c);
				atts.clear();
				atts.addAttribute("", "", "NAME", "CDATA", c.name.replace("\"", ""));
				hd.startElement("", "", "DECATHLETE", atts);
				atts.clear();
				
				hd.startElement("", "", "PLACE", atts);
				hd.characters(s[index].toCharArray(), 0, s[index].length());
				hd.endElement("", "", "PLACE");
//				if (c.score.equals(previousPoints)){
//					count++;
//					place = place - count;
//						hd.startElement("", "", "PLACE", atts);
//						hd.characters(place.toString().toCharArray(), 0, place.toString().length());
//						hd.endElement("", "", "PLACE");
//					place = place + count +1;
//				}
//				else {
//					count = 0; 
//						hd.startElement("", "", "PLACE", atts);
//						hd.characters(place.toString().toCharArray(), 0, place.toString().length());
//						hd.endElement("", "", "PLACE");
//					place ++;
//				}
				hd.startElement("", "", "SCORE", atts);
				hd.characters(c.score.toString().toCharArray(), 0, c.score.toString().length());
				hd.endElement("", "", "SCORE");
				
				hd.startElement("", "", "COUNTRY", atts);
				hd.characters(c.nationality.toCharArray(), 0, c.nationality.length());
				hd.endElement("", "", "COUNTRY");
				
				hd.startElement("", "", "DATEOFBIRTH", atts);
				hd.characters(c.born.toCharArray(), 0, c.born.length());
				hd.endElement("", "", "DATEOFBIRTH");
				
				hd.startElement("", "", "RESULTS", atts);
				hd.startElement("", "", "HUNDREDMETERS", atts);
				hd.characters(c.results[0].toCharArray(), 0, c.results[0].length());
				hd.endElement("", "", "HUNDREDMETERS");
				
				hd.startElement("", "", "LONGJUMP", atts);
				hd.characters(c.results[1].toCharArray(), 0, c.results[1].length());
				hd.endElement("", "", "LONGJUMP");
				
				hd.startElement("", "", "SHOTPUT", atts);
				hd.characters(c.results[2].toCharArray(), 0, c.results[2].length());
				hd.endElement("", "", "SHOTPUT");
				
				hd.startElement("", "", "HIGHJUMP", atts);
				hd.characters(c.results[3].toCharArray(), 0, c.results[3].length());
				hd.endElement("", "", "HIGHJUMP");
				
				hd.startElement("", "", "FOURHUNDREDMETERS", atts);
				hd.characters(c.results[4].toCharArray(), 0, c.results[4].length());
				hd.endElement("", "", "FOURHUNDREDMETERS");
				
				hd.startElement("", "", "HUNDREDANDTENHURDLES", atts);
				hd.characters(c.results[5].toCharArray(), 0, c.results[5].length());
				hd.endElement("", "", "HUNDREDANDTENHURDLES");
				
				hd.startElement("", "", "DISCUSTHROW", atts);
				hd.characters(c.results[6].toCharArray(), 0, c.results[6].length());
				hd.endElement("", "", "DISCUSTHROW");
				
				hd.startElement("", "", "POLEVAULT", atts);
				hd.characters(c.results[7].toCharArray(), 0, c.results[7].length());
				hd.endElement("", "", "POLEVAULT");
				
				hd.startElement("", "", "JAVELINTHROW", atts);
				hd.characters(c.results[8].toCharArray(), 0, c.results[8].length());
				hd.endElement("", "", "JAVELINTHROW");
				
				hd.startElement("", "", "FINALRUN", atts);
				hd.characters(c.results[9].toCharArray(), 0, c.results[9].length());
				hd.endElement("", "", "FINALRUN");
									
			hd.endElement("", "", "RESULTS");
			hd.endElement("", "", "DECATHLETE");
			
//			previousPoints = c.score;
			}
			hd.endElement("","","DECATHLON");
			hd.endDocument();
		}
		catch (SAXException e) {
			System.out.println("Error while generating XML");
			System.exit(0);
		}
		p.close();
	}
	
	/**
	 * writeToHTML method outputs the decathlon results to a HTML file.
	 * Generates a temporaty file [currentTimeMillis]_mid.xml
	 * 
	 * @version 1.0
	 * @param filename - filename for the output HTML file
	 * @param listToOutput - sorted ArrayList of competitors to output. 
	 */
	public void writeToHTML (String filename, ArrayList<Competitor> listToOutput) {
		OutputWriter wxml = new OutputWriter();
		String mid_xml = Long.toString(System.currentTimeMillis())+ "_mid.xml";
		File midfile = new File(mid_xml);
		wxml.writeToXML(mid_xml, listToOutput);
		DocumentBuilder db = null;

		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.exit(0);
		}
		Document xml = null;
		try {
			xml = db.parse(mid_xml);
		}
		catch (SAXException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		finally {
			midfile.delete();
		}
		
		Transformer t = null;
		try {
			t = TransformerFactory.newInstance().newTransformer(new StreamSource(this.getClass().getResourceAsStream("decathlon.xsl")));
		}
		catch (TransformerConfigurationException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			t.transform(new DOMSource(xml),new StreamResult(new FileOutputStream(filename)));
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		catch (TransformerException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
}