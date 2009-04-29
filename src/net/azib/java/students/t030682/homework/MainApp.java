package net.azib.java.students.t030682.homework;

import java.io.IOException;
import java.sql.*;

/**
 * MainApp
 *
 * @author aplotn
 */
public class MainApp {

	public static void main(String[] args) throws IOException {
		DataInputClass tmpInput = new DataInputClass();
		/*String[] tmpArray = tmpInput.consoleReader();
		System.out.println("+++++++\nAthletes results:\n+++++++");
		for (String s : tmpArray) {
			System.out.println(DecathlonResultsRecord.stringToRecord(s));
		}*/

		
		
		
		String[] tmpStr = tmpInput.csvReader("c:\\csv.csv");
		for (String hehe : tmpStr) {
			System.out.println(DecathlonResultsRecord.stringToRecord(tmpInput.inputRecordFromCSVFile(hehe)));
		}

	}

}
