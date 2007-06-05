package net.azib.java.students.t960644.homework;

import java.io.PrintStream;

/**
 * CSVOutput
 *
 * @author Lembit
 */
public class CSVOutput {
	
	public void writeData(PrintStream out,Competition competition) {
		for (Result r:competition.getResults()){
			out.println(writeLine(r));
		}
	}
	
	protected StringBuffer writeLine(Result result) {
		return new StringBuffer(result.getPosition()).append(",").
			append(Integer.toString(result.calcResult())).append(",").
			append(quotation(result.getAthlete().getName())).append(",").
			append(result.getAthlete().getBirthDate()).append(",").
			append(result.getAthlete().getCountryCode()).append(",").
			append(result.getStringRace100()).append(",").
			append(result.getStringLongJump()).append(",").
			append(result.getStringShotPut()).append(",").
			append(result.getStringHighJump()).append(",").
			append(result.getStringRace400()).append(",").
			append(result.getStringHurdles110()).append(",").
			append(result.getStringDiscusThrow()).append(",").
			append(result.getStringPoleVault()).append(",").
			append(result.getStringJavelinThrow()).append(",").
			append(result.getStringRace1500());
	}
	
	protected StringBuffer quotation(String src) {
		return new StringBuffer(src).insert(0,'"').append('"');
	}
	
}
