package net.azib.java.students.t050657.homework.src.controller;

import net.azib.java.students.t050657.homework.src.model.Athlet;
import net.azib.java.students.t050657.homework.src.model.Competition;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * CSVFileWriter
 *
 * @author Boriss
 */
public class CSVFileWriter {
	
	private Competition competition;
	
	public void writeToFile(String filename) throws IOException{
		String lineEnd =  System.getProperty("line.separator");
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filename), "UTF8"));
		
		for(Athlet athlet : competition.getAthlets()) {
			writer.write(athlet.toString() + lineEnd);
		}

		writer.close();
	}
	
	public void addCompetition(Competition competition) {
		this.competition = competition;
	}
	
}
