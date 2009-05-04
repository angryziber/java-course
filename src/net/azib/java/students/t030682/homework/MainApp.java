package net.azib.java.students.t030682.homework;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.Collections;

/**
 * MainApp
 *
 * @author aplotn
 */
public class MainApp {

	public static void main(String[] args) throws IOException {
		
		DataInputClass tmpInput = new DataInputClass();	
		String [] tmpArray = new String[0];

		if (Pattern.compile("-console").matcher(args[0]).matches()) {
			tmpArray = tmpInput.consoleReader();
		}
		else if (args[0].equals("-csv")) {
			tmpArray = tmpInput.csvReader(args[1]);
		}
		else if (args[0].equals("-db")) {
			System.out.println("mysql");
		}
		else
			System.out.println("Wrong input arguments");
		
		
		List<DecathlonResultsRecord> competitionRecords = new LinkedList<DecathlonResultsRecord>();
		for (String s : tmpArray) {
			competitionRecords.add(DecathlonResultsRecord.stringToRecord(s));
		}
		Collections.sort(competitionRecords);
		System.out.println(competitionRecords.toArray(new String[competitionRecords.size()]));
		
		
		
	if (args[2].equals("-console")) {
			System.out.println("+++++++++++++++++\nAthletes results:\n+++++++++++++++++");
			for (String s : tmpArray) {
				System.out.println(DecathlonResultsRecord.stringToRecord(s));
			}
	  }
	  else if (args[2].equals("-csv")) {
		  System.out.println("csv output to file " + args[3]);
	  }
	  else if (args[2].equals("-html")) {
		  System.out.println("html output to file " + args[3]);
	  }
	  else if (args[2].equals("-xml")) {
		  System.out.println("xml output to file " + args[3]);
	  }
	  else System.out.println("Wrong output arguments");
	}

}
