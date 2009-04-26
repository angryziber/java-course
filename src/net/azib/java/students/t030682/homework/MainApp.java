package net.azib.java.students.t030682.homework;

import java.io.IOException;


/**
 * MainApp
 *
 * @author aplotn
 */
public class MainApp {

	public static void main(String[] args) throws IOException {
		DataInputClass tmpInput = new DataInputClass();
		String[] tmpArray = tmpInput.consoleReader();
		System.out.println("+++++++\nAthletes results:\n+++++++");
		for (String s : tmpArray) {
			System.out.println(DecathlonResultsRecord.stringToRecord(s));
		}
		
		//System.out.println(DecathlonResultsRecord.stringToRecord(tmpInput.inputRecordFromConsole()));
		String[] tmpStr = tmpInput.csvReader("d:\\stu\\java\\csv.csv");
		for (String hehe : tmpStr) {
		//	System.out.println(DecathlonResultsRecord.stringToRecord(tmpInput.inputRecordFromCSVFile(hehe)));
		}

	}

}
