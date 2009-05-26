package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * CSVWriter write result table into file
 * 
 * @author libricon
 */
public class CSVWriter implements SportmanWriter {

	/**
	 * Constructor open file to write
	 * 
	 * @param fileName destination file
	 * @throws FileNotFoundException
	 */
	public CSVWriter(String fileName) throws FileNotFoundException {
		writer = new PrintWriter(fileName);
	}

	/**
	 * @param file
	 * @throws FileNotFoundException
	 */
	public CSVWriter(File file) throws FileNotFoundException {
		writer = new PrintWriter(file);
	}

	/**
	 * This method print into file competition data and result table all places and names
	 * @param comp competition object
	 */
	@Override
	public void printResultTable(Competition comp) {
		writer.println(comp.getName() + " " + comp.getId());
		for (Places place : comp.getPlaces()) {
			writer.print(place);
		}
		writer.flush();
	}
     
    /** 
     *  Method close printWriter stream
     */
	@Override
	public void close() {
		writer.close();
	}

	PrintWriter writer = null;
}
