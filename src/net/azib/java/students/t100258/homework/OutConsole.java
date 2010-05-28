package net.azib.java.students.t100258.homework;

import java.util.ArrayList;

/**
 * OutConsole
 *
 * @author mihkel
 */
public class OutConsole implements Output {
	/**
	 * outputs results to console
	 *
	 * @param results Arraylist of Results
	 */
	public void outputResults(ArrayList<Object> results) {
		int i=0;
		Result row;
		System.out.println("Output to console");
		while (results.size()  > i)   {
			row=((Result)results.get(i)); 
			// Print the content on the console
		    System.out.println (row.place  + ", " + row.sum + ", " + row.name + ", " + row.country + ", " + row.date + ", " + row.sprint_100 + ", " + row.long_jump + ", " + row.short_put + ", " + row.hurdles + ", " + row.discus_throw + ", " + row.pole_vault + ", " + row.jevelin_throw + ", " + row.high_jump + ", " + row.sprint_400 + ", " + row.race);
			i++;
		    }
	}

	

}
