package net.azib.java.students.t030682.homework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Collections;

import javax.xml.transform.TransformerException;
/**
 * MainApp
 *
 * @author aplotn
 */
public class DecathlonCalculator { 

	public static void main(String[] args) throws IOException, TransformerException {
		
		DataInputClass tmpInput = new DataInputClass();	
		String [] tmpArray = new String[0];

		if (Pattern.compile("-console").matcher(args[0]).matches()) {
			tmpArray = tmpInput.consoleReader();
		}
		else if (args[0].equals("-csv")) {
			tmpArray = tmpInput.csvReader(args[1]);
		}
		else if (args[0].equals("-db")) {
			System.out.println("mysql input from database" + args[1]);
		}
		else
			System.out.println("Wrong input arguments");
		
		List<DecathlonResultsRecord> competitionRecords = new ArrayList<DecathlonResultsRecord>();
		for (String s : tmpArray) {
			competitionRecords.add(DecathlonResultsRecord.stringToRecord(s));
		}
		Collections.sort(competitionRecords);
		
		DataOutputClass out = new DataOutputClass();
	if (args[2].equals("-console")) {
		out.consoleWriter(competitionRecords);
		}
	  else if (args[2].equals("-csv")) {
		  out.csvWriter(competitionRecords,args[3]);
	  }
	  else if (args[2].equals("-html")) {
		  out.htmlWriter(out.buildDocument(competitionRecords),args[3]);
	  }
	  else if (args[2].equals("-xml")) {
		  out.xmlWriter(out.buildDocument(competitionRecords),args[3]);
	  }
	  else System.out.println("Wrong output arguments");
	}

}
