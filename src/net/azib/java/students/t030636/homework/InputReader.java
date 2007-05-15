package net.azib.java.students.t030636.homework;

import java.io.*;
import java.util.Vector;

/**
 * InputReader
 *
 * @author Martin
 * 
 */
public class InputReader {
	
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

	
	public String [] readFromConsole() throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
	    System.out.println("Enter the number of competitors");
	    int k = Integer.parseInt(br.readLine());
	    System.out.println("Now enter " + k + " result sets in the predefined format:");
	    String [] output = new String[k];
	    for(int i = 0; i<k ;i++) {
	    	int a = i+1;
	    	System.out.println ( a +". Competitor:");
	    	output[i] = br.readLine();	    	
	    }
		return output;
	}
}
