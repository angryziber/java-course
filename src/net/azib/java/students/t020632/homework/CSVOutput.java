package net.azib.java.students.t020632.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

/**
 * CSVOutput
 *
 * @author Marek Soobik t020632
 */
public class CSVOutput implements Output{

	
	
	public void write(List<AthleteResults> results) {
		String s = "";
		int i = 0;
		int j = 0;
		AthleteResults result;
		
		try {
	        Writer out = new BufferedWriter(new OutputStreamWriter(
	            new FileOutputStream("C:/Documents and Settings/Marek/Desktop/out.txt"), "UTF8"));
	        
	        while(i < results.size()){
				result = results.get(i);
				try {
			        s = result.getPosition() + ",";
					s = s + result.getScore() + ",";
					s = s + result.getName() + ",";
					s = s + result.getDateOfBirth() + ",";
					s = s + result.getCountry() + ",";
					
					j = 0;
					while(j < 10){
						if(j != 9)
							s = s + result.getEvent(j).getResult() + ",";
						else
							s = s + result.getEvent(j).getResult();
						j++;
					}
					out.write(s);
					out.write(System.getProperty("line.separator"));
			    } 
			    catch (IOException e) {
			    }
				i++;
			}
	        
	        try {
		        out.close();
		    } 
	        catch (UnsupportedEncodingException e) {
		    }
	        catch (IOException e) {
		    }
	        
	    }
		catch (UnsupportedEncodingException e) {
	    }
		catch (IOException e) {
	    }
	}

}
