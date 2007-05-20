package net.azib.java.students.t020632.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;

/**
 * HTMLOutput
 *
 * @author Marek Soobik t020632
 */
public class HTMLOutput implements Output{
	
	private String path;
	private Output xmlFile;
	
	public HTMLOutput(String path){
		this.path = path;
		this.xmlFile = new XMLOutput(path.substring(0, path.length() - 3) + "xml", path);
		System.out.println(path.substring(0, path.length() - 3) + "xml");
	}
	
	public void write(List<AthleteResults> results) {
		String s;
		
		xmlFile.write(results);
		
		try {
	        Writer out = new BufferedWriter(new OutputStreamWriter(
	            new FileOutputStream(path), "UTF8"));
	        
	        s = System.getProperty("line.separator");
	        
	        out.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>" + s);
	        out.write("<xsl:stylesheet version=\"1.0\"" + s);
	        out.write("\t" + "xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">" + s);
	        out.write("<xsl:template match=\"/\">" + s);
	        out.write("<html>" + s + "<body>" + s);
	        out.write("<h3>Decathlon event</h3>" + s);
	        out.write("<table border=\"1\"><tr>" + s);
	        out.write("<th>Place</th>" + s);
	        out.write("<th>Score</th>" + s);
	        out.write("<th>Name</th>" + s);
	        out.write("<th>Date of Birth</th>" + s);
	        out.write("<th>Country</th>" + s);
	        out.write("<th>100m</th>" + s);
	        out.write("<th>Long Jump</th>" + s);
	        out.write("<th>Shot Put</th>" + s);
	        out.write("<th>High Jump</th>" + s);
	        out.write("<th>400m</th>" + s);
	        out.write("<th>110m Hurdles</th>" + s);
	        out.write("<th>Discus Throw</th>" + s);
	        out.write("<th>Pole Vault</th>" + s);
	        out.write("<th>Javelin Throw</th>" + s);
	        out.write("<th>1500m</th></tr>" + s);
	        out.write("<xsl:for-each select=\"decathlon_event/athlete\">");
	        
	        out.write("<tr>" + s);
	        out.write("<td><xsl:value-of select=\"place\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"score\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"name\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"date_of_birth\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"country\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"r_100m\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"long_jump\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"shot_put\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"high_jump\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"r_400m\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"r_110m\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"discus_throw\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"pole_vault\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"javelin_throw\"/></td>" + s);
	        out.write("<td><xsl:value-of select=\"r_1500m\"/></td>" + s);
	        out.write("</tr>" + s);
	        out.write("</xsl:for-each>" + s);
	        out.write("</table></body></html>" + s);
	        out.write("</xsl:template>" + s);
	        out.write("</xsl:stylesheet>" + s);
	        
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
