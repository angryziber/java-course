package net.azib.java.students.t020632.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

/**
 * XMLOutput
 *
 * @author Marek Soobik t020632
 */
public class XMLOutput implements Output{
	
	private String path;
	
	public XMLOutput(String path){
		this.path = path;
	}
	
	public void write(List<AthleteResults> results) {
		AthleteResults result;
		int i = 0;
		int j = 0;
		String s;
		
		try {
	        Writer out = new BufferedWriter(new OutputStreamWriter(
	            new FileOutputStream(path), "UTF8"));
	        
	        s = System.getProperty("line.separator");
	        
	        out.write("<?xml version='1.0' encoding='utf-8'?>" + s);
	        out.write("<decathlon event>" + s);
	       
	        while(i < results.size()){
				result = results.get(i);
				try {
			        out.write("<place>" + s);
					out.write("\t" + result.getPosition() + s);
					out.write("</place>" + s);
					out.write("<score>" + s);
					out.write("\t" + result.getScore() + s);
					out.write("</score>" + s);
					out.write("<name>" + s);
					out.write("\t" + result.getName() + s);
					out.write("</name>" + s);
					out.write("<date of birth>" + s);
					out.write("\t" + result.getDateOfBirth() + s);
					out.write("</data of birth>" + s);
					out.write("<country>" + s);
					out.write("\t" + result.getCountry() + s);
					out.write("</country>" + s);
					
					j = 0;
					while(j < 10){
						out.write("<event>" + s);
						out.write("\t" + result.getEvent(j).getResult() + s);
						out.write("</event>" + s);
						j++;
					}
			    } 
			    catch (IOException e) {
			    }
				i++;
			}
	        out.write("</decathlon event>");
	        
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
	
	public String getPath(){
		return path;
	}

}
