package net.azib.java.students.t050657.homework.src.controller;

import net.azib.java.students.t050657.homework.src.model.Athlet;
import net.azib.java.students.t050657.homework.src.model.Competition;
import net.azib.java.students.t050657.homework.src.model.InsufficientResultsException;

import java.io.IOException;

/**
 * DataAccessor class represents facade for DBAccessor and FileAccessor,
 * CSVFileWriter and XMLFileWriter.
 * Class gives easy way to access needed opportunities from those those classes.
 *
 * @author Boriss
 */
public class DataAccessor {
	
	/**
	 * Using FileAccessor to get competition
	 * @param date of competition
	 * @param countryCode 
	 * @param description of competition
	 * @param path to file
	 * @return competition, taken from file
	 */
	public static Competition getCompetitionInfo(String date, 
											 String countryCode,
											 String description,
											 String path) {
		Competition competition;
		competition =  new FileAccessor().getCompetitionInfo(date, countryCode, description, path);
		return competition;
	}

	/**
	 * Using DBAccessor to get competition
	 * @param date of competition
	 * @param countryCode 
	 * @param description of competition
	 * @param url DB URL
	 * @param user DB user
	 * @param password DB user's password
	 * @return competition, taken from database
	 */
	public static Competition getCompetitionInfo(String date, 
												   String countryCode,
												   String description,
												   String url,
												   String user,
												   String password) {
		Competition competition;
		competition = new DBAccessor().getCompetitionInfo(date, countryCode, description, url, user, password);
		return competition;
	}

	/**
	 * Writes competition to file (csv or XML) depends on processType.
	 * If 1 - using CSVFileWriter, 2 - using XMLFileWriter
	 * @param competition to print
	 * @param processType shows were to print
	 */
	public void writeToFile(Competition competition, int processType) {
		if(processType == 1) {
			CSVFileWriter csvFile = new CSVFileWriter();
			csvFile.addCompetition(competition);
			try {
				csvFile.writeToFile(competition.getDescription() + ".txt");
			}
			catch (IOException e) {
				System.out.println("filewriting failed!");
				e.printStackTrace();
			}	
		}
		else if(processType == 2) {
			XMLFileWriter xml = new XMLFileWriter("competitions", "competition.xsd");
			xml.addCompetition(competition);
			
			for(Athlet athlet : competition.getAthlets()) {
				xml.addAthletToCompetition(athlet, competition);
				try {
					xml.addResultToAthlet(athlet.getResult(), athlet, competition);
				}
				catch (InsufficientResultsException e) {
					System.out.println("results for athlet are unsufficient!");
					e.printStackTrace();
				}				
			}
			
			try {
				xml.writeXMLtoFile(competition.getDescription() + ".xml");
			}
			catch (IOException e) {
				System.out.println("can't write to xml file");
				e.printStackTrace();
			}	
		}
	}
}
