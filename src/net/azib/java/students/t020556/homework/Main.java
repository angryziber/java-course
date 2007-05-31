package net.azib.java.students.t020556.homework;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.PriorityQueue;


/**
 * Main application class. This class contains the main method which uses the predefined classes
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public class Main {

	private static boolean inDb = false;
	private static File inFile = null;
	private static InputStream inUser = null;
	private static File outFile = null;
	private static File outXFile = null;
	private static File outHFile = null;
	private static boolean outStd = false;
	private static boolean outputPresent = false;
	private static boolean inputPresent = false;
	
	//functional members
	private static DecathlonResultStreamReader dsr = new DecathlonResultStreamReader();
	private static DecathlonResultDataBaseReader dbr = new DecathlonResultDataBaseReader();
	
	private static DecathlonResultStreamWriter dsw = new DecathlonResultStreamWriter();
	private static DecathlonResultXmlWriter dxw = new DecathlonResultXmlWriter();
	
	/**
	 * main method
	 * 
	 * @author Agu Aarna
	 * 
	 * @param args -
	 * 		<ul>
	 * 		<li>[-di] - reads results from database</li>
	 * 		<li>[-fi] &lt;absolute_file_name&gt; - reads results from a CSV file</li>
	 * 		<li>[-i] - reads CSV formatted results from stdin.</li>
	 * 
	 * 		<li>[-fo] &lt;absolute_file_name&gt; - writes results to file</li>
	 * 		<li>[-xo] &lt;absolute_file_name&gt; - writes results to xml file</li>
	 * 		<li>[-ho] &lt;absolute_file_name&gt; - writes results to html file</li>
	 * 		<li>[-o] - writes results to stdout</li>
	 * 		</ul>
	 * 
	 * @version 1
	 */
	public static void main(String[] args) {
		if(args.length == 0){
			printHelp();
			return;
		}
		
		parseArgs(args);
		
		if(!(inputPresent && outputPresent)){
			System.err.println("Input present: " + inputPresent);
			System.err.println("Output present: " + outputPresent);
			System.err.println("Please define both input and output!");
			return;
		}
			
		//first perform reading
		PriorityQueue<Competitor> compQ = new PriorityQueue<Competitor>();
		if(inUser != null){
			dsr.setStream(inUser);
			compQ.addAll(dsr.readResults());
		}
		
		if(inFile != null){
			readFile(compQ);
		}
		
		if(inDb){
			readDataBaseInteractive(compQ);
		}
		
		//now write
		if(outFile != null)
			writeCsvFile(compQ);
		
		if(outXFile != null)
			writeTransformed(true, compQ);
		
		if(outHFile != null)
			writeTransformed(false, compQ);
		
		if(outStd){
			dsw.setStream(System.out);
			dsw.setFormat(false);
			dsw.writeResults(compQ);
		}
	}
	
	private static void readFile(PriorityQueue<Competitor> compQ){
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inFile.getAbsolutePath());
			dsr.setStream(fis);
			compQ.addAll(dsr.readResults());
		}
		catch (FileNotFoundException e) {
			System.err.println("Unable to find file " + inFile);
		}
		finally{
			try {
				fis.close();
			}
			catch (IOException e) {
				//shouldn't happen
			}
		}
		
	}
	
	private static void writeCsvFile(PriorityQueue<Competitor> compQ){
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outFile.getAbsolutePath());
			dsw.setStream(fos);
			dsw.writeResults(compQ);
		}
		catch (FileNotFoundException e) {
			System.err.println("Unable to find file " + outFile);
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
	
	private static void readDataBaseInteractive(PriorityQueue<Competitor> compQ){
		//init
		dbr.initConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
		
		try {
			//read and display competitions
			ResultSet rs = dbr.getCompetitions();
			while (rs.next()) {
				System.out.print(rs.getInt("id") + "\t");
				System.out.println(rs.getString("description"));
			}
			
			//read the user's choise
			System.out.print("Choose from given decathlon competitions: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			Number nr = NumberFormat.getInstance().parse(line);
	
			//read chosen competitions
			dbr.setCompetitionId(nr);
			compQ.addAll(dbr.readResults());
		}
		catch (SQLException e) {
			System.err.println("Unable to access competitions collection!");
		}
		catch (IOException e) {
			System.err.println("Failed reading the user's decathlon competition choise");
		}
		catch (ParseException e) {
			System.err.println("Failed to parse the user's decathlon competition choise");
		}
		//release connection
		dbr.releaseConnection();
	}
	
	private static void writeTransformed(
		boolean xmlFormat, PriorityQueue<Competitor> compQ){
		
		FileOutputStream fos = null;
		File file = null;
		try {
			file = xmlFormat ? outXFile : outHFile;
			fos = new FileOutputStream(file.getAbsolutePath());
			dxw.setFormat(xmlFormat);
			dxw.setStream(fos);
			dxw.writeResults(compQ);
		}
		catch (FileNotFoundException e) {
			System.err.println("Unable to find file " + file);
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
	
	private static void parseArgs(String[] args){
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("-di")){
				inDb = true;
				inputPresent = true;
			}
			else if(args[i].equals("-fi") && (1 + i) < args.length){
				inFile = new File(args[++i]);
				if(!inFile.exists() || inFile.isDirectory()){
					inFile = null;
					continue;
				}
				inputPresent = true;
			}
			else if(args[i].equals("-i")){
				readResultsInteractive();
				inputPresent = true;
			}
			else if(args[i].equals("-fo") && (1 + i) < args.length){
				outFile = new File(args[++i]);
				outputPresent = true;
			}
			else if(args[i].equals("-xo") && (1 + i) < args.length){
				outXFile = new File(args[++i]);
				outputPresent = true;
			}
			else if(args[i].equals("-ho") && (1 + i) < args.length){
				outHFile = new File(args[++i]);
				outputPresent = true;
			}
			else if(args[i].equals("-o")){
				outStd = true;
				outputPresent = true;
			}
		}
	}
	
	private static void readResultsInteractive(){
		try {
			System.out.println(
					"You have chosen to insert competitor results manually. Please " + 
					"insert the results separated by line breaks in the same CSV " + 
					"format as it is presented in CSV files. To finish insertion, " + 
					"press \"return\" additionally!");
				
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF8"));
			String line;
			while(!(line = reader.readLine()).equals("")){
				sb.append(line).append("\n");
			}
			
			if(sb.length() > 0)
				inUser = new ByteArrayInputStream(sb.toString().getBytes());
		}
		catch (IOException e) {
			System.err.println("Failed reading input!");
		}
	}
	
	private static void printHelp(){
		System.out.println("Unable to parse arguments. Available argument list:");
		System.out.println();
		System.out.println("[-di] - reads results from database");
		System.out.println("[-fi] <absolute_file_name> - reads results from a CSV file");
		System.out.println("[-i] - reads CSV formatted results from stdin");
		System.out.println("[-fo] <absolute_file_name> - writes results to file");
		System.out.println("[-xo] <absolute_file_name> - writes results to xml file");
		System.out.println("[-ho] <absolute_file_name> - writes results to html file");
		System.out.println("[-o] - writes results to stdout");
	}

}
