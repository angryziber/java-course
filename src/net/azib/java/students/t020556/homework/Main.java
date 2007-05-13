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
 * Main
 *
 * @author agu
 */
public class Main {

	private static boolean accessDb = false;
	private static File inFile = null;
	private static InputStream argsIn = null;
	private static File outFile = null;
	private static File outXFile = null;
	private static File outHFile = null;
	private static boolean outStd = false;
	
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
	 * 		<li>[d] - reads results from database</li>
	 * 		<li>[fi] &lt;absolute_file_name&gt; - reads results from a CSV file</li>
	 * 		<li>[i] &lt;CSV-formatted data&gt; - reads CSV results from arguments</li>
	 * 
	 * 		<li>[fo] &lt;absolute_file_name&gt; - writes results to file</li>
	 * 		<li>[xo] &lt;absolute_file_name&gt; - writes results to xml file</li>
	 * 		<li>[ho] &lt;absolute_file_name&gt; - writes results to html file</li>
	 * 		<li>[o] - writes results to stdout</li>
	 * 		</ul>
	 * 
	 * @version 1
	 */
	public static void main(String[] args) {
		if(args.length < 2){
			printHelp();
		}
		
		parseArgs(args);
			
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
		}
		
		//now write
		if(outFile != null)
			writeCsvFile(compQ);
		
		if(outXFile != null){
			writeTransformed(true, compQ);
		}
		
		if(outHFile != null){
			writeTransformed(false, compQ);
		}
		
		if(outStd){
			dsw.setStream(System.out);
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
			if(args[i] == "d"){
				accessDb = true;
			}
			else if(args[i] == "fi" && (++i) < args.length){
				inFile = new File(args[i]);
				if(!inFile.exists() || inFile.isDirectory())
					inFile = null;
			}
			else if(args[i] == "i" && (++i) < args.length){
				if(sb == null)
					sb = new StringBuilder();
				sb.append(args[i]).append("\n");
			}
			else if(args[i] == "fo" && (++i) < args.length){
				outFile = new File(args[i]);
			}
			else if(args[i] == "xo" && (++i) < args.length){
				outXFile = new File(args[i]);
			}
			else if(args[i] == "ho" && (++i) < args.length){
				outHFile = new File(args[i]);
			}
			else if(args[i] == "o"){
				outStd = true;
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
		System.out.println("[d] - reads results from database");
		System.out.println("[fi] <absolute_file_name> - reads results from a CSV file");
		System.out.println("[i] <CSV-formatted data> - reads CSV results from arguments");
		System.out.println("[fo] <absolute_file_name> - writes results to file");
		System.out.println("[xo] <absolute_file_name> - writes results to xml file");
		System.out.println("[ho] <absolute_file_name> - writes results to html file");
		System.out.println("[o] - writes results to stdout");
	}

}
