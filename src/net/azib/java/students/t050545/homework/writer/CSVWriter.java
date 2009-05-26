package net.azib.java.students.t050545.homework.writer;

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
	
	/** Constructor open file to write
	 * @param fileName destination file
	 * @throws FileNotFoundException 
	 */
	public CSVWriter(String fileName) throws FileNotFoundException{
		writer = new PrintWriter(fileName);
	}
	
	/**
	 * @param file
	 * @throws FileNotFoundException
	 */
	public CSVWriter(File file) throws FileNotFoundException {
		writer = new PrintWriter(file);
	}

	PrintWriter writer = null;

	/** 
	 * 
	 */
	@Override
	public void printResultTable(Places[] places) {
		for (Places place : places) {
			System.out.println(place);
			writer.print(place);
		}
		writer.flush();
		
	}
}
