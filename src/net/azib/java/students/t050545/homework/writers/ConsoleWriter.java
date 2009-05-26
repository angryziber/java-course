package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;


/**
 * ConsoleWriter writes result table on the screen
 * 
 * @author libricon
 */
public class ConsoleWriter implements SportmanWriter {

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
