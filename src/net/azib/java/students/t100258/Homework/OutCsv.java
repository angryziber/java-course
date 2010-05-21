package net.azib.java.students.t100258.Homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



/**
 * class for csv output
 *
 * @author mihkel
 */
public class OutCsv {
	
	/**
	 * outputs results to csv file
	 *
	 * @param results Arraylist of Results
	 * @throws IOExeption
	 */
	public OutCsv(ArrayList <Object> results) throws IOException {
		int i;
		i=0;
		System.out.println("Output to csv");
		Result row;
		FileWriter fstream = new FileWriter(Decathlon.out_arg);
        BufferedWriter out = new BufferedWriter(fstream);
		while (results.size()  > i)   {
			row=((Result)results.get(i));
			
	    out.write(row.place  + ", " + row.sum + ", " + row.name + ", " + row.country + ", " + row.date + ", " + row.sprint_100 + ", " + row.long_jump + ", " + row.short_put + ", " + row.hurdles + ", " + row.discus_throw + ", " + row.pole_vault + ", " + row.jevelin_throw + ", " + row.high_jump + ", " + row.sprint_400 + ", " + row.race);
	    out.newLine();
	    i++;
		
		    }
		out.close();
	}
}
