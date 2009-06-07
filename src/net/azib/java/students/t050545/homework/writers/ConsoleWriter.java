package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;
import net.azib.java.students.t050545.homework.utils.AthleteWriter;
import net.azib.java.students.t050545.homework.utils.LoadException;

import java.util.List;
import java.util.Stack;


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
	public void init(Stack<String> arguments) throws LoadException {
		
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
