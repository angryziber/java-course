package net.azib.java.students.t020556.homework;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;

/**
 * Main application class. This class contains the main method which uses the predefined classes
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public class Main {

	private static boolean accessDb = false;
	private static File inFile = null;
	private static InputStream argsIn = null;
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
	 * 		<li>[-i] "&lt;CSV-formatted_data&gt;" - reads CSV results from arguments. Note that you
	 * 		can specify only one competitor data. To specify more than one competitor, add more 
	 * 		"-i"-prefixed data.</li>
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
		if(argsIn != null){
			dsr.setStream(argsIn);
			compQ.addAll(dsr.readResults());
		}
		
		if(inFile != null){
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
		
		if(accessDb){
			dbr.initConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
			compQ.addAll(dbr.readResults());
			dbr.releaseConnection();
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
	
	private static void writeTransformed(boolean xmlFormat, PriorityQueue<Competitor> compQ){
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
		StringBuilder sb = null;
		for(int i = 0; i < args.length; i++){
			if(args[i].equals("-di")){
				accessDb = true;
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
			else if(args[i].equals("-i") && (1 + i) < args.length){
				if(sb == null)
					sb = new StringBuilder();
				sb.append(args[++i]).append("\n");
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
		
		if(sb != null)
			try {
				argsIn = new ByteArrayInputStream(sb.toString().getBytes("UTF8"));
			}
			catch (UnsupportedEncodingException e) {
				//shouldn't happen
			}
	}
	
	private static void printHelp(){
		System.out.println("Unable to parse arguments. Available argument list:");
		System.out.println();
		System.out.println("[-di] - reads results from database");
		System.out.println("[-fi] <absolute_file_name> - reads results from a CSV file");
		System.out.println("[-i] \"<CSV-formatted_data>\" - reads CSV results from arguments");
		System.out.println("\tNOTE that you can specify only one competitor data.");
		System.out.println("\tTo specify more than one competitor, add more \"-i\"-prefixed data.");
		
		System.out.println("[-fo] <absolute_file_name> - writes results to file");
		System.out.println("[-xo] <absolute_file_name> - writes results to xml file");
		System.out.println("[-ho] <absolute_file_name> - writes results to html file");
		System.out.println("[-o] - writes results to stdout");
	}

}
