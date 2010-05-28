package net.azib.java.students.t100258.homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * OutCSV
 *
 * @author mihkel
 */
public class OutCSV implements OutputWith2Parameters {

	/**
	 * outputs results to csv file
	 *
	 * @param results Arraylist of Results
	 * @param location Location of output file including filename and extension
	 * @throws IOExeption
	 */
	public void outputResults(ArrayList<Object> results, String location) throws IOException {
		int i;
		i=0;
		System.out.println("Output to csv");
		Result row;
		FileWriter fstream = new FileWriter(location);
        BufferedWriter out = new BufferedWriter(fstream);
		while (results.size()  > i)   {
			row=((Result)results.get(i));
		
			
	    try {
			out.write(row.place  + ", " + row.sum + ", " + row.name + ", " + row.country + ", " + row.date + ", " + row.sprint_100 + ", " + row.long_jump + ", " + row.short_put + ", " + row.hurdles + ", " + row.discus_throw + ", " + row.pole_vault + ", " + row.jevelin_throw + ", " + row.high_jump + ", " + row.sprint_400 + ", " + row.race);
			 out.newLine();
	    }
		catch (IOException e) {
			System.err.println("Caught IOException on writing to results file: " 
                    +  e.getMessage());
		}
	   
	    i++;
		
		    }
		
		try {
			out.close();
		}
		catch (IOException e) {
			System.err.println("Caught IOException on closing output file: " 
                    +  e.getMessage());
		}
		
	}

}
