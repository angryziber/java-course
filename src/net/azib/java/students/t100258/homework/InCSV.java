package net.azib.java.students.t100258.homework;

import net.azib.java.students.t100258.homework.Result;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * InCSV
 *
 * @author mihkel
 */
public class InCSV implements InputWithParameter {
	/**
	 * Input from csv file
	 * @param address Address of csv file including file name
	 * @throws FileNotFoundExeption
	 * @return Arraylist of Results
	 * 
	 */
	public ArrayList<Object> getResults(String address) throws FileNotFoundException  {
		ArrayList <Object> results;
		results= new ArrayList <Object>();
		
		BufferedReader in = null;
		
			in = new BufferedReader(new FileReader(address));
		
		
			try{
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
		}
		catch (IOException e) {
	         System.err.println("Caught IOException: " 
	                             +  e.getMessage());
	         System.out.println("Input from console");
	         System.exit(0);
					 
	    } 
		finally{
			try {
				in.close();
			}
			catch (IOException e) {
				System.err.println("Caught IOException on closing input csv file: " 
                        +  e.getMessage());
				
			}
			 
			}		
		
		return results;
	}

	

}
