package net.azib.java.students.t020281.homework;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


/**
 * DecathlonCalculator
 *
 * @author Trial
 */
/**
 * DecathlonCalculator
 *
 * @author Trial
 */
public class DecathlonCalculator {
	
	LinkedList<Sportsman> sportsmenList = new LinkedList<Sportsman>();
	
	/**
	 * Method to sort sportsmen list in descending order by their decathlon points.
	 */
	public void sortSportsmenList() {
		Comparator<Sportsman> r = Collections.reverseOrder();
		Collections.sort(sportsmenList, r);
	}
	
	private boolean isAnswer(String name){
		return Sportsman.doMatching("^[y,n,Y,N]$",name);
	}
	
	/**
	 * Method reads Sportsmen data in CSV format from InputStream provided.
	 * @param input
	 * @return
	 */
	public String[] readFromCSV(InputStream input){
		Reader reader= null;
		try {
			StringBuilder resultString = new StringBuilder();
			reader= new BufferedReader(new InputStreamReader(input,"UTF8"));
			char[] buf = new char[1024];
			int numRead = 0;
			while ((numRead = reader.read(buf))!=-1){
				resultString.append(buf, 0, numRead);
			}
			String[] results = null;
			results = resultString.toString().split("\n");
			return results;
		}
		catch (FileNotFoundException e) {
			System.out.println("Error reading from file.File Not Found!");
			return null;
		}
		catch (IOException e) {
			System.out.println("Error reading from file .I/O Error!");
			return null;
		}
		finally {
			try {
				reader.close();
			}
			catch (IOException e) {
				System.out.println("Error closing file .");
			}
		}
	}
	
	/**
	 * Method writes calculated results and Sportsmen data in XML format to OutputStream provided.
	 * @param out
	 */
	public void writeToXML(OutputStream out){
		
		StringBuilder builder = new StringBuilder();
		sortSportsmenList();
		builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		builder.append("<results xsi:noNamespaceSchemaLocation=\"");
		builder.append(DecathlonCalculator.class.getResource("decathlon.xsd")); 
		builder.append("\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n");
		for (int i = 0; i < sportsmenList.size(); i++) {
			Sportsman person = new Sportsman();
			person = sportsmenList.get(i);
			DecimalFormat df = new DecimalFormat("0.00");
			builder.append("<sportsman>\n");
			builder.append("<name>").append(person.getName()).append("</name>\n");
			builder.append("<birthDate>").append(person.getBirthDate()).append("</birthDate>\n");
			builder.append("<country>").append(person.getCountry()).append("</country>\n");
			builder.append("<sprint100mEvent>").append(df.format(person.getSprint100mEvent())).append("</sprint100mEvent>\n");
			builder.append("<longJumpEvent>").append(df.format(person.getLongJumpEvent())).append("</longJumpEvent>\n");
			builder.append("<shotPutEvent>").append(df.format(person.getShotPutEvent())).append("</shotPutEvent>\n");
			builder.append("<highJumpEvent>").append(df.format(person.getHighJumpEvent())).append("</highJumpEvent>\n");
			builder.append("<sprint400mEvent>").append(df.format(person.getSprint400mEvent())).append("</sprint400mEvent>\n");
			builder.append("<hurdles110mEvent>").append(df.format(person.getHurdles110mEvent())).append("</hurdles110mEvent>\n");
			builder.append("<discusThrowEvent>").append(df.format(person.getDiscusThrowEvent())).append("</discusThrowEvent>\n");
			builder.append("<poleVaultEvent>").append(df.format(person.getPoleVaultEvent())).append("</poleVaultEvent>\n");
			builder.append("<javelinThrowEvent>").append(df.format(person.getJavelinThrowEvent())).append("</javelinThrowEvent>\n");
			builder.append("<race1500mEvent>").append(df.format(person.getRace1500mEvent())).append("</race1500mEvent>\n");
			builder.append("<points>").append(person.getPoints().intValue()).append("</points>\n");
			builder.append("<place>").append(i+1).append("</place>\n");
			builder.append("</sportsman>\n");
		}
		builder.append("</results>");
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(out,"UTF8"));
			writer.write(builder.toString());
		}
		catch (IOException e) {
			System.out.println("Error writing to XML file. I/O Error!");
		}
		finally {
			try {
				writer.close();
			}
			catch (IOException e) {
				System.out.println("Error closing XML file.");
			}
		}
	}

	
	/**
	 * Method writes calculated results and Sportsmen data in html format to OutputStream provided.
	 * @param out
	 */
	public void writeToHtml (OutputStream out){
		try {
		File tmp = File.createTempFile("test", "tmp");
		OutputStream xmlStream = new FileOutputStream(tmp);
		writeToXML(xmlStream);
		xmlStream.close();
		InputStream stylesheet = DecathlonCalculator.class.getResourceAsStream("decathlon.xsl");
		Transformer transformer;
			transformer = TransformerFactory.newInstance().newTransformer(new StreamSource(stylesheet));
			stylesheet.close();
			InputStream source = new FileInputStream(tmp);
			transformer.transform(new StreamSource(source), new StreamResult(out));
			source.close();
		}
		catch (TransformerConfigurationException e) {
			e.printStackTrace();
			System.out.println("Error writing HTML file. Transformer Configuration Eror!");
		}
		catch (TransformerFactoryConfigurationError e) {
			System.out.println("Error writing HTML file. Transformer Factory Configuration Eror!");
		}
		catch (IOException e) {
			System.out.println("Error writing HTML file. I/O Eror!");
		}
		catch (TransformerException e) {
			System.out.println("Error writing HTML file. Transformer Eror!");
		}

	}
	
	
	/**
	 * Method writes calculated results and Sportsmen data in console format to OutputStream provided.
	 * @param out
	 */
	public void writeToConsole(OutputStream out){
		StringBuilder builder = new StringBuilder();
		sortSportsmenList();
		for (int i = 0; i < sportsmenList.size(); i++) {
			Sportsman person = new Sportsman();
			person = sportsmenList.get(i);
			DecimalFormat df = new DecimalFormat("0.00");
			builder.append(person.getName().toUpperCase()).append(" (").append(person.getBirthDate()).append(") ").append(person.getCountry()).append(" results:\n");
			builder.append("100 m sprint (sec): ").append(df.format(person.getSprint100mEvent())).append("\n");
			builder.append("Long jump (m): ").append(df.format(person.getLongJumpEvent()/100)).append("\n");
			builder.append("Shot put (m): ").append(df.format(person.getShotPutEvent())).append("\n");
			builder.append("High jump (m): ").append(df.format(person.getHighJumpEvent()/100)).append("\n");
			builder.append("400 m sprint (sec): ").append(df.format(person.getSprint400mEvent())).append("\n");
			builder.append("110 m hurdles (sec): ").append(df.format(person.getHurdles110mEvent())).append("\n");
			builder.append("Discus throw (m) : ").append(df.format(person.getDiscusThrowEvent())).append("\n");
			builder.append("Pole vault (m): ").append(df.format(person.getPoleVaultEvent()/100)).append("\n");
			builder.append("Javelin throw (m): ").append(df.format(person.getJavelinThrowEvent())).append("\n");
			builder.append("1500 m race (sec): ").append(df.format(person.getRace1500mEvent())).append("\n");
			builder.append("Decathlon Points: ").append(person.getPoints().intValue()).append("\n");
			builder.append("Place: ").append(i+1).append("\n\n");
		}
		try {
			out.write(builder.toString().getBytes());
		}
		catch (IOException e) {
			System.out.println("Error writing to console!");
		}
	}
	
	/**
	 * Method writes calculated results and Sportsmen data in csv format to OutputStream provided
	 * @param output
	 */
	public void writeToCSV(OutputStream output){
		
		sortSportsmenList();
		Writer writer = null;
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < sportsmenList.size(); i++) {
			builder.append(sportsmenList.get(i).toString()).append(",").append(i+1).append("\n");
		}
		String[] results = builder.toString().split("\n");
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(output,"UTF8"));
			for (int i = 0; i < results.length; i++) {
				writer.write(results[i]+"\n");
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Error writing to file. File Not Found!");
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Error writing to file. Unsupported Encoding!");
		}
		catch (IOException e) {
			System.out.println("Error writing to file. I/O Error!");
		}
		finally {
			try {
				writer.close();
			}
			catch (IOException e) {
				System.out.println("Error closing file.");
			}
		}
	}
	
	/**
	 * Method for reading sportsman data from console
	 * @return string array of CSV formatted strings 
	 */
	public String[] readFromConsole(){
		
		Scanner input = new Scanner(System.in);
		return readFromStream(input, System.out);
		
	}
	
	/**
	 * Method for reading sportsman data from Scanner and output dialogs to given PrintStream
	 * @return string array of CSV formatted strings 
	 */
	public String[] readFromStream(Scanner scanner, PrintStream out ){
		StringBuilder builder = new StringBuilder();
		int i = 1;
		String results;
		String rawResult;
		out.println("Welcome to Decathlon points calculator! Please insert sportsmen achievements:");
		boolean returnFlag = true; 
		while (returnFlag) {
			results = "";
			out.println("Sportsman "+i+" data is: ");
			
			out.print("Name: ");
			while (!Sportsman.isName(rawResult = scanner.nextLine())) {
				out.println("Name has incorrect format.Example: Vasya Pupkin");
			}
			results += "\""+rawResult+"\"";
			
			out.print("Date of birth: ");
			while (!Sportsman.isDate(rawResult = scanner.next())) {
				out.println("Date has incorrect format.Example: 12.03.1990");
			}
			results += ","+rawResult;
			
			out.print("Country Code: ");
			while (!Sportsman.isCode(rawResult = scanner.next())) {
				out.println("Code has incorrect format.Example: EE");
			}
			results += ","+rawResult;
			
			String[] arr= new String[6];
			arr[0]= "100 m sprint (sec)";
			arr[1]= "400 m sprint (min:sec)";
			arr[2]= "110 m hurdles (sec)";
			arr[3]= "1500 m race (min:sec)";
			for (int j = 0; j < 4; j++) {
				out.print(arr[j]+":");
				while (!Sportsman.isTime(rawResult = scanner.next())) {
					out.println("Time has incorrect format.Example: 1:04.72 or 04.72");
				}
				results += ","+rawResult;
			}
			
			arr[0]= "Long jump (m)";
			arr[1]= "Shot put (m)";
			arr[2]= "High jump (m)";
			arr[3]= "Discus throw (m)";
			arr[4]= "Pole vault (m)";
			arr[5]= "Javelin throw (m)";
			for (int j = 0; j < arr.length; j++) {
				out.print(arr[j]+":");
				while (!Sportsman.isDouble(rawResult = scanner.next())) {
					out.println("Distance has incorrect format.Example: 04.72");
				}
				results += ","+rawResult;
			}
			
			String[] res = results.split("\\,");
			results = res[0]+","+res[1]+","+res[2]+","+res[3]+","+res[7]+","+res[8]+",";
			results +=res[9]+","+res[4]+","+res[5]+","+res[10]+","+res[11]+","+res[12]+","+res[6];
			
			out.print("Do you want to add another sportsman?(y/n): ");
			while (!isAnswer(rawResult = scanner.next())){
				out.print("Please enter y or n: ");
			}
			i = i+1;
			
			if (rawResult.endsWith("n") | rawResult.endsWith("N")){
				returnFlag = false;
				builder.append(results).append("\n");
			} else {
				builder.append(results);
			}
		}
		return builder.toString().split("\n");
		
	}
	
	/**
	 * Main program to calculate Decathlon Points
	 * @param args
	 */
	public static void main(String[] args) {
		
		DecathlonCalculator dc = new DecathlonCalculator();
		String[] res = null;
		InputStream input = null;
		OutputStream output = null;
		SportsmanDAO dao = new SportsmanDAO();
		int i = 0;

		if(args[i].equalsIgnoreCase("-console")) {
			i++;
			i++;
			res = dc.readFromConsole();
		} else if(args[i].equalsIgnoreCase("-csv")) {
			i++;
			File csvInFile = new File(args[i]);
			try {
				input = new FileInputStream(csvInFile);
			}
			catch (FileNotFoundException e) {
				System.out.println("Error reading from file. File Not Found!");
			}
			res = dc.readFromCSV(input);
			i++;
		} else if(args[i].equalsIgnoreCase("-db")){
			i++;
			res = dao.getResultsByCompetition(Integer.parseInt(args[i]));
			i++;
		} else {
			System.out.println("Some parameters of input are wrong. Please check program parameters!");
		}
		
		if (res!=null) {
		for (int j = 0; j < res.length; j++) {
			Sportsman person = new Sportsman(res[j]);
			dc.sportsmenList.add(person);
		}
		}
		
		if (args[i].equalsIgnoreCase("-console")) {
			dc.writeToConsole(System.out);
		} else if (args[i].equalsIgnoreCase("-csv")) {
			i++;
			File csvOutFile = new File(args[i]);
			try {
				output = new FileOutputStream(csvOutFile);
			}
			catch (FileNotFoundException e) {
				System.out.println("Error writing to CSV file. File Not Found!");
			}
			dc.writeToCSV(output);
		} else if (args[i].equalsIgnoreCase("-xml")) {
			i++;
			File xmlOutFile = new File(args[i]);
			try {
				output = new FileOutputStream(xmlOutFile);
			}
			catch (FileNotFoundException e) {
				System.out.println("Error writing to XML file. File Not Found!");
			}
			dc.writeToXML(output);
		} else if (args[i].equalsIgnoreCase("-html")) {
			i++;
			File htmlOutFile = new File(args[i]);
			try {
				output = new FileOutputStream(htmlOutFile);
			}
			catch (FileNotFoundException e) {
				System.out.println("Error writing to HTML file. File Not Found!");
			}
			dc.writeToHtml(output);
		} else {
			System.out.println("Some parameters of output are wrong. Please check program parameters!");
		}

		try {
			if (input!=null){
			input.close();}
			if (output!=null) {
			output.close();}
		}
		catch (IOException e) {
			System.out.println("Error closing file.");
		}
		

	}
	
	
}
