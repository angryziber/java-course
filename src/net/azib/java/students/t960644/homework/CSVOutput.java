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
			append(DecathlonEvent.RACE_100M.eventResultFormat(result.getRace100())).append(",").
			append(DecathlonEvent.LONG_JUMP.eventResultFormat(result.getLongJump())).append(",").
			append(DecathlonEvent.SHOT_PUT.eventResultFormat(result.getShotPut())).append(",").
			append(DecathlonEvent.HIGH_JUMP.eventResultFormat(result.getHighJump())).append(",").
			append(DecathlonEvent.RACE_400M.eventResultFormat(result.getRace400())).append(",").
			append(DecathlonEvent.HURDLES_110M.eventResultFormat(result.getHurdles110())).append(",").
			append(DecathlonEvent.DISCUS_THROW.eventResultFormat(result.getDiscusThrow())).append(",").
			append(DecathlonEvent.POLE_VAULT.eventResultFormat(result.getPoleVault())).append(",").
			append(DecathlonEvent.JAVELIN_THROW.eventResultFormat(result.getJavelinThrow())).append(",").
			append(DecathlonEvent.RACE_1500M.eventResultFormat(result.getRace1500()));
	}
	
	protected StringBuffer quotation(String src) {
		return new StringBuffer(src).insert(0,'"').append('"');
	}
	
}
