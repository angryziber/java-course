package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class ConsoleWriter {

	/**
	 * This method takes ArrayList of athletes as a parameter, converts it to ArrayList of strings and outputs it to console.
	 * @param athletes, ArrayList to write
	 */

    public void writeDataToConsole(ArrayList<Athlete> athletes) {
     ArrayList<String> athletesOut;

     athletesOut = new CustomUtilities().fromAthleticToStringConsoleFormat(athletes);
        for (String s : athletesOut) {
            System.out.println(s);
        }
    }


}
