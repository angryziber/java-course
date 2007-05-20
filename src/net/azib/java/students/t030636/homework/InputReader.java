package net.azib.java.students.t030636.homework;

import java.io.*;
import java.util.Vector;

/**
 * InputReader
 *
 * @author Martin
 * @version 1.0
 * 
 */
public class InputReader {
	
	/**
	 * readFile method reads the input data from a file and outputs a String array.
	 * The String array can be later processed by the PointsForObjects class.
	 * @see net.azib.java.students.t030636.homework.PointsForObjects#calculatePoints(String[])
	 * @version 1.0
	 * @param filename - filename of the file to read from
	 * 
	 */
	
	public  String [] readFile(String filename) {
		InputStream is = this.getClass().getResourceAsStream(filename);
		BufferedReader r = null;
		try {
			r = new BufferedReader( new InputStreamReader( is, "UTF8"));
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Wrong encoding");
			System.exit(0);
		}
		catch (NullPointerException e) {
			System.out.println("Filename incorrect");
			System.exit(0);
		}
		Vector<String> resultsToReturn = new Vector<String>();
		String line;
		try {
			while ((line = r.readLine()) != null) {
				resultsToReturn.add(line);
			}
		}
		catch (IOException e) {
			System.out.println("Error while reading file");
			e.printStackTrace();
			System.exit(0);
		}
		catch (NullPointerException e) {
			System.out.println("Error while reading file");
			System.exit(0);
		}
		String [] outputStringArray = new String[resultsToReturn.size()];
		resultsToReturn.toArray(outputStringArray);
		return  outputStringArray;
	}
	
	/**
	 * readFile method reads the input data from the console and outputs a String array.
	 * The String array can be later processed by the PointsForObjects class.
	 * @see net.azib.java.students.t030636.homework.PointsForObjects#calculatePoints(String[])
	 * @version 1.0
	 * 
	 */
	
	public String [] readFromConsole() {
	    BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unsupported encoding");
			System.exit(0);
		}
	    System.out.println("Enter the number of competitors");
	    int k = 0;
		try {
			k = Integer.parseInt(br.readLine());
		}
		catch (NumberFormatException e) {
			System.out.println("Wrong number format");
			System.exit(0);
		}
		catch (IOException e) {
			System.out.println("Error while reading from console");
			System.exit(0);
		}
	    System.out.println("Now enter " + k + " result sets in the predefined format:");
	    String [] output = new String[k];
	    for(int i = 0; i<k ;i++) {
	    	int a = i+1;
	    	System.out.println ( a +". Competitor:");
	    	try {
				output[i] = br.readLine();
			}
			catch (IOException e) {
				System.out.println("Error while reading from console");
				System.exit(0);
			}	    	
	    }
		return output;
	}
}
