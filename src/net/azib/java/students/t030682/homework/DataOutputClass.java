package net.azib.java.students.t030682.homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * DataOutputClass
 * 
 * @author aplotn
 */
public class DataOutputClass {

	public int[] countPlaces(List<DecathlonResultsRecord> results) {
		int places[] = new int[results.size()];
		int tmpPlace;
		int numberOfSamePlaces = 0;
		int tmpScore = 0;
		for (DecathlonResultsRecord hehe : results) {
			tmpPlace = (results.indexOf(hehe));
			if (hehe.totalScore == tmpScore) {
				++numberOfSamePlaces;
				tmpPlace = tmpPlace-numberOfSamePlaces;
			} else numberOfSamePlaces = 0;
			places[results.indexOf(hehe)] = tmpPlace + 1;
			tmpScore = hehe.totalScore;
		}
		return places;
	}

	public void consoleWriter(List<DecathlonResultsRecord> results) {
		System.out.println("+++++++++++++++++\nAthletes results:\n+++++++++++++++++\n");
		for (DecathlonResultsRecord consoleResult : results) 
			System.out.println(countPlaces(results)[results.indexOf(consoleResult)] + ":   " + consoleResult);
	}

	public void csvWriter(List<DecathlonResultsRecord> results, String filename) {
		try {
			FileWriter fstream = new FileWriter(filename);
			BufferedWriter out = new BufferedWriter(fstream);
			for (DecathlonResultsRecord csvResult : results) {
				out.write(countPlaces(results)[results.indexOf(csvResult)] + "," + csvResult.totalScore + ",\"" + csvResult.name + "\","
						+ csvResult.dateOfBirth + "," + csvResult.country + "," + csvResult.resultOf100mSprint + "," + csvResult.resultOfLongJump
						+ "," + csvResult.resultOfShotPut + "," + csvResult.resultOfHighJump + "," + csvResult.resultOf400mSprint + ","
						+ csvResult.resultOf110mHurdles + "," + csvResult.resultOfDiscusThrow + "," + csvResult.resultOfPoleVault + ","
						+ csvResult.resultOfJavelinThrow + "," + csvResult.resultOf1500Race);
				out.newLine();
			}
			out.close();
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
