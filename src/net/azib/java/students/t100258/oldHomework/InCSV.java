package net.azib.java.students.t100258.oldHomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * CSV input class
 *
 * @author mihkel
 */
public class InCSV {
	
	/**
	 * Input from csv file
	 * @param address Address of csv file including file name
	 * @throws IOExeption
	 * 
	 */
	public InCSV(String address) throws IOException{
		ArrayList <Object> results;
		results= new ArrayList <Object>();
		
		BufferedReader in;
		in = new BufferedReader(new FileReader(address));
		String line;
		while((line = in.readLine()) != null){
			String tempname = line.substring(0, line.indexOf(","));
			line= line.substring(line.indexOf(",")+1);
			String tempbirth =  line.substring(0, line.indexOf(","));
			line= line.substring(line.indexOf(",")+1);
			String tempcountry = line.substring(0, line.indexOf(","));
			line= line.substring(line.indexOf(",")+1);
			Float tempsprint_100 = Float.parseFloat( line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			Float templong_jump = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			Float tempshort_put = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			Float temphigh_jump = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			String tempsprint_400 = line.substring(0, line.indexOf(","));
			line= line.substring(line.indexOf(",")+1);
			Float temphurdles = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			Float tempdiscus_throw = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			Float temppole_vault = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			Float tempjevelin_throw = Float.parseFloat(line.substring(0, line.indexOf(",")));
			line= line.substring(line.indexOf(",")+1);
			String temprace = line;
			Integer tempsum = null;	
			
			Result result1= new Result(tempname ,tempbirth ,tempcountry ,tempsprint_100 ,templong_jump ,tempshort_put ,temphigh_jump ,tempsprint_400 ,temphurdles ,tempdiscus_throw ,temppole_vault ,tempjevelin_throw ,temprace, tempsum, tempsum);
			results.add(result1);
		}
		in.close();
		
/*
 
 CsvReader reader = new CsvReader(address);

		reader.readHeaders();
		while (reader.readRecord())
		{
			String tempname = reader.get("Name");
			String tempbirth =  reader.get("Birth");
			String tempcountry = reader.get("Country");
			Float tempsprint_100 = Float.parseFloat( reader.get("100 m sprint"));
			Float templong_jump = Float.parseFloat(reader.get("Long jump"));
			Float tempshort_put = Float.parseFloat(reader.get("Shot put"));
			Float temphigh_jump = Float.parseFloat(reader.get("High jump"));
			String tempsprint_400 = reader.get("400 m sprint");
			Float temphurdles = Float.parseFloat(reader.get("110 m hurdles"));
			Float tempdiscus_throw = Float.parseFloat(reader.get("Discus throw"));
			Float temppole_vault = Float.parseFloat(reader.get("Pole vault"));
			Float tempjevelin_throw = Float.parseFloat(reader.get("Javelin throw"));
			String temprace = reader.get("1500 m race");
			Integer tempsum = null;
			Result result1= new Result(tempname ,tempbirth ,tempcountry ,tempsprint_100 ,templong_jump ,tempshort_put ,temphigh_jump ,tempsprint_400 ,temphurdles ,tempdiscus_throw ,temppole_vault ,tempjevelin_throw ,temprace, tempsum);
			results.add(result1);
			

		}

		reader.close();
		*/
		//System.out.println (((Result)results.get(0)).race); //test
		new CalculateResults(results);
		
		

	}
}
