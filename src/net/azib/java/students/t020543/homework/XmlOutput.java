package net.azib.java.students.t020543.homework;

import java.io.*;
import java.util.Iterator;
import java.util.Set;

/**
 * A class, which outputs data to the XML file
 * @author Collega
 */
public class XmlOutput implements IOutput{
	
	@Override
	public void saveFile(Set<Competitor> set, String destination){
		
	try{	
		
		//stream creating
		OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(destination), "UTF-8"); 
    	
		try {	
				out.write("<?xml version=\"1.0\"?>\r\n");  
				out.write("<Decathlon>\r\n");
				
				/*Writes XML tags and values for every Competitor object, using loop*/
				
				Iterator<Competitor> i = set.iterator();  
				while (i.hasNext()) {       
					Competitor cur = (Competitor)i.next();
					out.write("\r<Athlete>\r\n");
					out.write("\r\t<place> " + cur.getPlace() + " </place>\r\n");
					Athlete competitor = (Athlete)cur.getMan();
					out.write("\r\t<score> " + competitor.getScore() + " </score>\r\n");
					out.write("\r\t<name> " + competitor.getName() + " </name>\r\n");
					out.write("\r\t<birthday> " + competitor.getBirthday()+ " </birthday>\r\n");
					out.write("\r\t<country> " + competitor.getCountry() + " </country>\r\n");
					out.write("\r\t<sprint100> " + competitor.getSprint100()+ " </sprint100>\r\n");
					out.write("\r\t<longJump> " + competitor.getLongJump() + " </longJump>\r\n");
					out.write("\r\t<shotPut> " + competitor.getShotPut()+ " </shotPut>\r\n");
					out.write("\r\t<highJump> " + competitor.getHighJump() + " </highJump>\r\n");
					out.write("\r\t<sprint400> " + competitor.getSprint400()+ " </sprint400>\r\n");
					out.write("\r\t<hurdles110> " + competitor.getHurdles110()+ " </hurdles110>\r\n");
					out.write("\r\t<discusThrow> " + competitor.getDiscusThrow() + " </discusThrow>\r\n");
					out.write("\r\t<poleVault> " + competitor.getPoleVault() + " </poleVault>\r\n");
					out.write("\r\t<javelinThrow> " + competitor.getJavelinThrow() + " </javelinThrow>\r\n");
					out.write("\r\t<race1500> " + competitor.getRace1500() + " </race1500>\r\n");
					out.write("</Athlete>\r\n\n");
					}
				out.write("</Decathlon>\r\n");
	     	}
	    catch (IOException e) {
	    	System.out.println("Output error while writing!");
	      }
	    finally  {
	    	try {
				out.close(); //stream closing
				}
			catch (IOException e) {
				System.out.println("Output error while closing!");
				}
	    	}
		}
	// Exception handling
	catch (UnsupportedEncodingException e) {
		System.out.println("Unsupported Encoding! (UTF-8 Needed!)");
	}
	catch (FileNotFoundException e) {
		System.out.println("File Not Found!");
	}
	}
	
}
