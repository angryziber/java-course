package net.azib.java.students.t030656.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

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
import org.xml.sax.SAXException;


/**
 * Writer
 *
 * @author Sprot
 */
public class Writer {

	/**
	 * construcotr
	 */
	public Writer() {
	}
	
	public static void writeToScreen(Competition comp){
		try { 
			BufferedWriter writer = 
		      new BufferedWriter(
		          new OutputStreamWriter(System.out, "UTF-8"));
		
			writer.write("Competition: " + comp.getName());
			writer.newLine();
			writer.write("Participants: ");
			writer.newLine();
			int place = 1;
			for(Participant p : comp.getParticipants()){
				writer.write( place++ +" "+ p.getPoints() + ", \""+p.getName() + "\", " +
					p.getDateOfBirth()+ ", "+
					p.getCountry() + ", ");
				int i = 0;
				for(String str : p.getStrResults()){
					writer.write(str);
					i++;
					if(i<10){
						writer.write(", ");
					}
					else{
						writer.newLine();
					}
				}
			}
			writer.newLine();
			writer.flush();
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Not supported encoding");
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void writeToFile(Competition comp){

		String path = Reader.getPathToFile() + "\\" + Reader.getNameToFile() + ".csv";
		try {
			BufferedWriter writer = 
			      new BufferedWriter(
			          new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			int place = 1;
			for(Participant p : comp.getParticipants()){
				writer.write( place +","+p.getPoints() + ",\""+p.getName() + "\"," +
					p.getDateOfBirth()+ ","+
					p.getCountry() + ",");
				int i = 0;
				for(String str : p.getStrResults()){
					writer.write(str);
					i++;
					if(i<10){
						writer.write(",");
					}
					else{
						writer.newLine();;
					}
				}
			}
			writer.flush();
			writer.close();
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Not supported encoding");
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Unable to close file writer");
			e.printStackTrace();
		}
	}
	
	public static void writeToXML(Competition comp, boolean bConvertToHtml) {

		String path = Reader.getPathToFile() + "\\" + Reader.getNameToFile();
		BufferedWriter xmlWriter = null; 
		BufferedWriter htmlWriter = null;
		try {
			String xmlPath = "c:\\" + String.valueOf(System.currentTimeMillis()) + "decathlon_temp.xml";
			if(bConvertToHtml){
				path = path + ".html"; 
				htmlWriter = new BufferedWriter(
				          new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
				xmlWriter = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(xmlPath), "UTF-8"));
			}else{
				path = path + ".xml";
				xmlWriter = new BufferedWriter(
				          new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
			}
			
			//create xml
			xmlWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			xmlWriter.newLine();
			xmlWriter.write("<?xml-stylesheet type=\"text/xsl\" href=\"participant.xsl\"?>");
			xmlWriter.newLine();
			xmlWriter.write("<competition>");
			xmlWriter.newLine();
			int place = 1;
			for(Participant p : comp.getParticipants()){
				xmlWriter.write("<participant>");
				xmlWriter.newLine();
				xmlWriter.write("<place>" + place++ +"</place>");
				xmlWriter.newLine();
				xmlWriter.write("<points>" + p.getPoints() +"</points>");
				xmlWriter.newLine();
				xmlWriter.write("<name>" + p.getName() + "</name>");
				xmlWriter.newLine();
				xmlWriter.write("<dateOfBirth>" + p.getDateOfBirth()+ "</dateOfBirth>");
				xmlWriter.newLine();
				xmlWriter.write("<country>" + p.getCountry() + "</country>");
				xmlWriter.newLine();
				int i = 0;
				for(String str : p.getStrResults()){
					xmlWriter.write("<result" + i +">" + str + "</result"+ i +">");
					i++;
					xmlWriter.newLine();
				}
				xmlWriter.write("</participant>");
				xmlWriter.newLine();
			}
			xmlWriter.write("</competition>");
			xmlWriter.flush();
			xmlWriter.close();
			
			if(bConvertToHtml){
				File xmlFile = new File(xmlPath);
				DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document xml = db.parse(xmlFile);
				
				Transformer t = TransformerFactory.newInstance().newTransformer(new StreamSource(Writer.class.getResourceAsStream("participants.xsl")));
				t.transform(new DOMSource(xml), new StreamResult(htmlWriter));
								
				//delete temporary file
				xmlFile.delete();
			}
			
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Not supported encoding");
			e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("Unable to close file writer");
			e.printStackTrace();
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}
		catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		}
		catch (TransformerException e) {
			e.printStackTrace();
		}
		finally{
			try {
				htmlWriter.close();
				xmlWriter.close();
			}
			catch (IOException e) {
				System.out.println("Unable to close stream");
				e.printStackTrace();
			}
			
		}
	}
}
