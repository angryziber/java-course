package net.azib.java.students.t100258.Homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * class for xml output
 *
 * @author mihkel
 */
public class OutXml {
	/**
	 * outputs results to xml file
	 *
	 * @param results Arraylist of Results
	 * @throws IOExeption
	 */
	
	public OutXml(ArrayList <Object> results) throws IOException  {
		System.setProperty("file.encoding", "UTF-8");

		int i=0;
		Result row;
		String xmlpath;
		if(Decathlon.out_method.equals("-html"))
		{
		xmlpath = Decathlon.out_arg.substring(0, Decathlon.out_arg.length()-4)+"xml";
		}
		else{
			xmlpath = Decathlon.out_arg;
		}
		FileWriter fstream = new FileWriter(xmlpath);
        BufferedWriter out = new BufferedWriter(fstream);
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.newLine();
        out.write("<Results>");
        out.newLine();
		while (results.size()  > i)   {
			row=((Result)results.get(i));
			out.write("<Athlete>");
			out.newLine();
			
	    out.write("<Name>" +row.name + "</Name><Country>" + row.country + "</Country><Born>" + row.date + "</Born><Sprint_100m>" + row.sprint_100 + "</Sprint_100m><Long_Jump>" + row.long_jump + "</Long_Jump><Short_Put>" + row.short_put + "</Short_Put><Hurdles>" + row.hurdles + "</Hurdles><Discus_Throw>" + row.discus_throw + "</Discus_Throw><Pole_Vault>" + row.pole_vault + "</Pole_Vault><Jevelin_Throw>" + row.jevelin_throw + "</Jevelin_Throw><High_Jump>" + row.high_jump + "</High_Jump><Sprint_400m>" + row.sprint_400 + "</Sprint_400m><Race>" + row.race + "</Race><Total>" + row.sum + "</Total>");
	    out.newLine();
	    out.write("</Athlete>");
		out.newLine();
	    i++;
		
		    }
		out.write("</Results>");
	    out.newLine();
		out.close();
		if(Decathlon.out_method.equals("-html")){
		new OutHTML(xmlpath);
		}
		else{System.out.println("Output to xml");}
	}
	
}
