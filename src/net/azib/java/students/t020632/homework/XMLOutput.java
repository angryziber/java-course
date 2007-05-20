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
	private String xslReference;
	
	public XMLOutput(String path){
		this.path = path;
		xslReference = null;
	}
	
	public XMLOutput(String path, String xsl){
		this.path = path;
		xslReference = xsl;
	}
	
	public void write(List<AthleteResults> results) {
		AthleteResults result;
		int i = 0;
		int j = 0;
		String s;
		String [] events = new String [] {"r_100m", "long_jump", "shot_put", "high_jump", "r_400m", "r_110m", "discus_throw", "pole_vault", "javelin_throw", "r_1500m"};
		
		try {
	        Writer out = new BufferedWriter(new OutputStreamWriter(
	            new FileOutputStream(path), "UTF8"));
	        
	        s = System.getProperty("line.separator");
	        
	        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + s);
	    
	        
	        if(xslReference != null){
	        	out.write("<?xml-stylesheet type=\"text/xsl\" href=\"" + xslReference + "\"?>");
	        }
	        
	        out.write("<decathlon_event>" + s);
	       
	        while(i < results.size()){
				result = results.get(i);
				try {
					out.write("<athlete>" + s);
					out.write("<place>"+ result.getPosition() + "</place>" +  s);
					out.write("<score>" + result.getScore() + "</score>" +  s);
					out.write("<name>" + result.getName() + "</name>" + s);
					out.write("<date_of_birth>" + result.getDateOfBirth() + "</date_of_birth>" + s);
					out.write("<country>" + result.getCountry() + "</country>" + s);
					
					j = 0;
					while(j < 10){
						out.write("<" + events[j] + ">" + result.getEvent(j).getResult() + "</" + events[j] + ">" + s);
						j++;
					}
			    } 
			    catch (IOException e) {
			    }
			    out.write("</athlete>" + s);
				i++;
			}
	        out.write("</decathlon_event>");

	        
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
