package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.sport.Places;

import java.io.PrintWriter;

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
	public void printResultTable(Places[] places) {
		for (Places pl : places) {
			System.out.println(pl.toString());
		}
		
	
		
	}
}
