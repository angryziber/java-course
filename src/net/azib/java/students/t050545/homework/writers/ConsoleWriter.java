package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.LoadException;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;

import java.util.List;


/**
 * ConsoleWriter writes result table on the screen
 * 
 * @author libricon
 */
public class ConsoleWriter implements AthleteWriter {

	private String argument = "-console";
	private String description = "Results print in console";
	
	@Override
	public String getArgum() {
		return argument;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void init(List<String> arguments) throws LoadException {
		
	}
	
	/** Method print on the screen competition results
	 *  sportman and his/her result 
	 *  also place in competition
	 */
	@Override
	public void printResultTable(Competition comp) {
		System.out.println(comp.getName()+" "+comp.getId());
		for (Places pl : comp.getPlaces()) {
			System.out.println(pl.toString());
		}
	}
	
	/** 
	 *  It's no needed :)
	 */
	@Override
	public void close(){
		System.out.close();
	}
}
