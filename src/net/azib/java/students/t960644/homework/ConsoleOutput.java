package net.azib.java.students.t960644.homework;

import java.io.PrintStream;

/**
 * ConsoleOutput
 * 
 * @author Lembit
 */
public class ConsoleOutput {
	int RESULT_WIDTH = 6;
	int DATE_WIDTH = 10;
	int TIME_WIDTH = 8;
	int COUNTRY_WIDTH = 2;
	int SCORE_WIDTH = 5;
	
	public void init() {
		
	}

	public void writeData(PrintStream out,Competition competition) {
		int posWidth = 3;
		int nameWidth = 4;
		for (Result r : competition.getResults()) {
			nameWidth = nameWidth < r.getAthlete().getName().length() ? r.getAthlete().getName().length() : nameWidth;
			posWidth = posWidth < r.getPosition().length() ? r.getPosition().length() : posWidth;
		}
		for (Result r : competition.getResults()) {
			out.println(writeLine(posWidth,nameWidth,r));
		}
	}

	protected StringBuffer writeLine(int posWidth, int nameWidth, Result result) {
		return padLeft(result.getPosition(), posWidth).
		append(padLeft(Integer.toString(result.calcResult()),SCORE_WIDTH)).
			append(padRight(result.getAthlete().getName(), nameWidth)).
			append(padLeft(result.getAthlete().getBirthDate(),DATE_WIDTH)).
			append(padLeft(result.getAthlete().getCountryCode(),COUNTRY_WIDTH)).
			append(padLeft(DecathlonEvent.RACE_100M.eventResultFormat(result.getRace100()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.LONG_JUMP.eventResultFormat(result.getLongJump()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.SHOT_PUT.eventResultFormat(result.getShotPut()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.HIGH_JUMP.eventResultFormat(result.getHighJump()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.RACE_400M.eventResultFormat(result.getRace400()),TIME_WIDTH)).
			append(padLeft(DecathlonEvent.HURDLES_110M.eventResultFormat(result.getHurdles110()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.DISCUS_THROW.eventResultFormat(result.getDiscusThrow()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.POLE_VAULT.eventResultFormat(result.getPoleVault()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.JAVELIN_THROW.eventResultFormat(result.getJavelinThrow()),RESULT_WIDTH)).
			append(padLeft(DecathlonEvent.RACE_1500M.eventResultFormat(result.getRace1500()),TIME_WIDTH));
	}

	protected StringBuffer spaces(int length) {
		StringBuffer dst = new StringBuffer();
		for (int i = 0; i < length; i++) {
			dst = dst.append(" ");
		}
		return dst;
	}

	protected StringBuffer padLeft(String src, int length) {
		return spaces(length - src.length()).append(src).append("|");
	}

	protected StringBuffer padRight(String src, int length) {
		return spaces(length - src.length()).insert(0, src).append("|");
	}

}
