package net.azib.java.students.t103640.homework;

import java.util.ArrayList;

public class InputHandler extends IOController {

	/**
	 * This method decides where to read data in from. This method does not have any parameters as it belongs to
	 * a class that extends IOController and all its public methods.
	 *
	 * @return ArrayList this class returns an ArrayList of athletes of witch it has read in. Basically it returns
	 *          data from given input
	 */
    public ArrayList<Athlete> readIn() {
     ArrayList<Athlete> athletes = null;

     if(getInputMethod().equals("-console")){
         ConsoleReader cr = new ConsoleReader();
         athletes = cr.getConsoleData();
     }

     if(getInputMethod().equals("-csv")){
         CSVReader csvReader = new CSVReader();
         athletes = csvReader.getCSVData(getInputParam());
     }

     if(getInputMethod().equals("-db")){
         DBReader dbR = new DBReader();
         athletes = dbR.getDBData(getInputParam());
     }

        return athletes;
    }
}
