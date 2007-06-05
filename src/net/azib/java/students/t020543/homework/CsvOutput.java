package net.azib.java.students.t020543.homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

/**
 * A class, which outputs data to the CSV file
 * @author Collega
 */
public class CsvOutput implements IOutput {
	
	@Override
	public void saveFile(Set<Competitor> set, String destination){
	
	try{
		//stream creating
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(destination), "UTF-8"); 
		
    		try { 
    			
    		/* Simply pastes CSV strings into the file, using asString() conversion*/
    		
    			Iterator<Competitor> i = set.iterator();  
    			while (i.hasNext()) {       
    				out.write(i.next().asString()+ "\r\n");
    				}
    			}
    		// Exception handling
    		catch (IOException e) {
    			System.out.println("Output error while writing!");
    		}
    		finally {   
	 			try {
	 				out.close(); // cloing the stream
	 			}
	 			// Exception handling
	 			catch (IOException e) {
	 				System.out.println("Output error while closing!");
	 			}
	    	}
	} // Exception handling
	catch (UnsupportedEncodingException e) {
		System.out.println("Unsupported Encoding! (UTF-8 Needed!)");
	}
	catch (FileNotFoundException e) {
		System.out.println("File Not Found!");
	}
}

}
