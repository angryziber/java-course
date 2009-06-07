package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;
import net.azib.java.students.t050545.homework.utils.LoadException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Stack;

/**
 * CSVWriter write result table into file
 * 
 * @author libricon
 */
public class CSVWriter implements AthleteWriter {

	/** printwriter stream */
	private PrintWriter writer = null;
	
	private String argument = "    -csv";
	private String description = "Competition results write to csv file";
	
	@Override
	public String getArgum() {
		return argument;
	}

	@Override
	public String getDescription() {
		return description;
	}

	/** Initialise writer, open file 
	 */
	@Override
	public void init(Stack<String> arguments) throws LoadException {
		String fileName = arguments.pop();
		try {
			writer = new PrintWriter(fileName);
		}
		catch (FileNotFoundException e) {
			throw new LoadException("Can't read or write to file");
		}
	}
	


	/**
	 * This method print into file competition data and result table all places and names
	 * @param comp competition object
	 */
	@Override
	public void printResultTable(Competition comp) {
		writer.println(comp.getName() + " " + comp.getId());
		for (Places place : comp.getPlaces()) {
			writer.print("["+place.getPlaceNum()+"],");
			writer.println(place.getSportman().getPerson().getName()+","
					+place.getSportman().getPerson().getCountry()+","
					+place.getSportman().getPoints().getScore());
		}
		writer.flush();
	}
     
    /** Method close printWriter stream */
	@Override
	public void close() {
		writer.close();
	}
}
