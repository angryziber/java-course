package net.azib.java.students.t100258.Homework;
import java.util.ArrayList;
/**
 * class for outputing results to console
 *
 * @author mihkel
 */
public class OutConsole {
	
	/**
	 * outputs results to console
	 *
	 * @param results Arraylist of Results
	 */
public OutConsole(ArrayList <Object> results) {
	int i=0;
	Result row;
	System.out.println("Output to console");
	while (results.size()  > i)   {
		row=((Result)results.get(i)); 
		// Print the content on the console
	    System.out.println (row.name + ", " + row.country + ", " + row.date + ", " + row.sprint_100 + ", " + row.long_jump + ", " + row.short_put + ", " + row.hurdles + ", " + row.discus_throw + ", " + row.pole_vault + ", " + row.jevelin_throw + ", " + row.high_jump + ", " + row.sprint_400 + ", " + row.race + ", " + row.sum);
		i++;
	    }
}
}

