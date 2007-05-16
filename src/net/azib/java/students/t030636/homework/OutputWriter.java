package net.azib.java.students.t030636.homework;

import java.io.*;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
import com.sun.org.apache.xml.internal.serialize.*;

/**
 * OutputWriter
 * Writer class for decathlon reults
 *
 * @author Martin
 */
public class OutputWriter {

	public void writeToFile (String filename, ArrayList<Competitor> listToOutput) throws IOException {
		int place = 1;
		int previousPoints = 0;
		int count = 0;
		FileOutputStream out = new FileOutputStream(filename);           	
		PrintStream p = new PrintStream(out,true,"UTF-8");
		for(Competitor c : listToOutput) {
			if (c.score == previousPoints){ //previous score was the same
				count ++;
				place = place - count;
				p.println(place + ". " +c.toString());
				place = place + count + 1;
			}
			else { //previous score was different
				count = 0;
				p.println(place + ". " +c.toString());
				place ++;
			}
			previousPoints = c.score;
		}
	}
	
	public void writeToConsole (ArrayList<Competitor> listToOutput) throws IOException {
		int place = 1;
		int count = 0;
		int previousPoints = 0;
		PrintStream p = new PrintStream(System.out,true,"UTF-8");
		p.println("DECATHLON RESULTS:");
		for(Competitor c : listToOutput) {
			if (c.score == previousPoints){
				count++;
				place = place - count;
				p.println(place + ". " +c.toString());
				place = place + count+1;
			}
			else {
				count = 0;
				p.println(place + ". " +c.toString());
				place ++;
			}
			previousPoints = c.score;
		}
	}
	
	public void writeToXML (String filename, ArrayList<Competitor> listToOutput) throws IOException, SAXException {
		Integer place = 1;
		Integer count = 0;
		Integer previousPoints = 0;
		FileOutputStream out = new FileOutputStream(filename);            	
		PrintStream p = new PrintStream(out,true,"UTF-8");
		
		// XERCES 1 or 2 additionnal classes.
		OutputFormat of = new OutputFormat("XML","UTF-8",true);
		of.setIndent(1);
		of.setIndenting(true);
		of.setDoctype(null,"decathlon.dtd");
		XMLSerializer serializer = new XMLSerializer(p,of);
		// SAX2.0 ContentHandler.
		ContentHandler hd = serializer.asContentHandler();
		hd.startDocument();
		AttributesImpl atts = new AttributesImpl();
	
		hd.startElement("","","DECATHLON",atts);
		for(Competitor c : listToOutput) {
			
			atts.clear();
			atts.addAttribute("", "", "NAME", "CDATA", c.name.replace("\"", ""));
			hd.startElement("", "", "DECATHLETE", atts);
			atts.clear();
			
			if (c.score.equals(previousPoints)){
				count++;
				place = place - count;
					hd.startElement("", "", "PLACE", atts);
					hd.characters(place.toString().toCharArray(), 0, place.toString().length());
					hd.endElement("", "", "PLACE");
				place = place + count +1;
			}
			else {
				count = 0; 
					hd.startElement("", "", "PLACE", atts);
					hd.characters(place.toString().toCharArray(), 0, place.toString().length());
					hd.endElement("", "", "PLACE");
				place ++;
			}
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
		
		previousPoints = c.score;
		}
		hd.endElement("","","DECATHLON");
		hd.endDocument();
		p.close();
	}
	
	public void writeToHTML (String filename, ArrayList<Competitor> listToOutput) throws IOException, SAXException, TransformerException, ParserConfigurationException{
		OutputWriter wxml = new OutputWriter();
		wxml.writeToXML("mid.xml", listToOutput);

		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xml = db.parse("mid.xml");
		
		Transformer t = TransformerFactory.newInstance().newTransformer(new StreamSource(this.getClass().getResourceAsStream("decathlon.xsl")));
		t.transform(new DOMSource(xml),new StreamResult(new FileOutputStream(filename)));
	}
}