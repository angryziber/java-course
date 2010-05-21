package net.azib.java.students.t092875.homework.writers;

import net.azib.java.students.t092875.homework.athletes.Athlete;
import net.azib.java.students.t092875.homework.competiotions.Competiotion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * ConsoleWriter
 *
 * @author Mihhail
 */
public class ConsoleWriter implements DecathlonWriter{
	private String[] testData = new String[14];
	/**
	 * writes the results of the decathlon to a console
	 * @param athletes - List of athletes who participated in the competition
	 */
	@Override
	public void write(List<Athlete> athletes) {
		for (Athlete athlete : athletes) {
			String output=null;
			output = "Athlete: "+athlete.getName()+"("+athlete.getOrigin()+")";
			testData[0] = output;
			System.out.println(output);
			SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
			output = "Date Of Birth: "+format.format(athlete.getDateOfBirth());
			testData[1] = output;
			System.out.println(output);
			output = "Place: "+athlete.getPlace();
			testData[2] = output;
			System.out.println(output);
			for (Competiotion comp : Competiotion.values()) {
				output = "Result in "+comp.event()+": "+athlete.getEventResult(comp.ordinal());
				testData[comp.ordinal()+3] = output;
				System.out.println(output);
			}
			output = "Total Result: "+athlete.getResult();
			testData[13] = output;
			System.out.println(output);
		}
	}
	
	String[] getTestData(){
		return this.testData;
	}
}
