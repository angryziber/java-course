package net.azib.java.students.t020556;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Formatting
 *
 * @author Agu Aarna
 */
public class Formatting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Locale.setDefault(new Locale("et"));
		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL);
		System.out.println("Hi, today is:");
		System.out.println(df.format(new Date()) + " and...");

		
		ChoiceFormat cf = 
			new ChoiceFormat(new double[]{3, 45, 2}, new String[]{"zero", "one", "shit load of"});
		System.out.println("You have " + cf.format(77) + " small little piggies!");
		
	}

}
