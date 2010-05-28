package net.azib.java.students.t100258.homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * OutputXML
 *
 * @author mihkel
 */
public class OutXML implements OutputWith2Parameters {
	/**
	 * outputs results to xml file
	 *
	 * @param results Arraylist of Results
	 * @param location location of output xml file(filename and extension included)
	 * @throws IOExeption
	 */
	public void outputResults(ArrayList<Object> results, String location) throws IOException  {
		System.setProperty("file.encoding", "UTF-8");
		System.out.println("Output to xml");
		int i=0;
		Result row;
	
		FileWriter fileStream = new FileWriter(location);
        BufferedWriter out = new BufferedWriter(fileStream);
        try {
			out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.newLine();
        out.write("<Results>");
        out.newLine();
		while (results.size()  > i)   {
			row=((Result)results.get(i));
			out.write("<Athlete>");
			out.newLine();
			
	    out.write("<Name>" +row.name + "</Name><Country>" + row.country + "</Country><Born>" + row.date + "</Born><Sprint_100m>" + row.sprint_100 + "</Sprint_100m><Long_Jump>" + row.long_jump + "</Long_Jump><Short_Put>" + row.short_put + "</Short_Put><Hurdles>" + row.hurdles + "</Hurdles><Discus_Throw>" + row.discus_throw + "</Discus_Throw><Pole_Vault>" + row.pole_vault + "</Pole_Vault><Jevelin_Throw>" + row.jevelin_throw + "</Jevelin_Throw><High_Jump>" + row.high_jump + "</High_Jump><Sprint_400m>" + row.sprint_400 + "</Sprint_400m><Race>" + row.race + "</Race><Total>" + row.sum + "</Total><Place>" + row.place + "</Place> ");
	    out.newLine();
	    out.write("</Athlete>");
		out.newLine();
	    i++;
		
		    }
		out.write("</Results>");
	    out.newLine();
        }
		catch (IOException e) {
			System.err.println("Caught IOException on writing to xml file: " 
                    +  e.getMessage());
		}
		
		try {
			out.close();
		}
		catch (IOException e) {
			System.err.println("Caught IOException on closing xml file: " 
                    +  e.getMessage());
		}
		
	}
	

}
