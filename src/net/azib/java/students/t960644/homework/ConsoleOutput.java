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
		out.println(writeHeader(posWidth,nameWidth));
		//out.println(underscores(8*RESULT_WIDTH+2*TIME_WIDTH+SCORE_WIDTH+DATE_WIDTH+COUNTRY_WIDTH+posWidth+nameWidth+15));
		for (Result r : competition.getResults()) {
			out.println(writeLine(posWidth,nameWidth,r));
		}
	}
	protected StringBuffer writeHeader(int posWidth, int nameWidth) {
		return padRight("Pos", posWidth).
			append(padRight("Score",SCORE_WIDTH)).
			append(padRight("Name",nameWidth)).
			append(padRight("BirthDate",DATE_WIDTH)).
			append(padRight("CC",COUNTRY_WIDTH)).
			append(padRight("Rac100",RESULT_WIDTH)).
			append(padRight("LnJump",RESULT_WIDTH)).
			append(padRight("ShotPt",RESULT_WIDTH)).
			append(padRight("HiJump",RESULT_WIDTH)).
			append(padRight("Race400",TIME_WIDTH)).
			append(padRight("Hrd110",RESULT_WIDTH)).
			append(padRight("DiscTh",RESULT_WIDTH)).
			append(padRight("PoleVt",RESULT_WIDTH)).
			append(padRight("JavThr",RESULT_WIDTH)).
			append(padRight("Race1500",TIME_WIDTH));
	}
	
	protected StringBuffer writeLine(int posWidth, int nameWidth, Result result) {
		return padLeft(result.getPosition(), posWidth).
		append(padLeft(Integer.toString(result.calcResult()),SCORE_WIDTH)).
			append(padRight(result.getAthlete().getName(), nameWidth)).
			append(padLeft(result.getAthlete().getBirthDate(),DATE_WIDTH)).
			append(padLeft(result.getAthlete().getCountryCode(),COUNTRY_WIDTH)).
			append(padLeft(result.getStringRace100(),RESULT_WIDTH)).
			append(padLeft(result.getStringLongJump(),RESULT_WIDTH)).
			append(padLeft(result.getStringShotPut(),RESULT_WIDTH)).
			append(padLeft(result.getStringHighJump(),RESULT_WIDTH)).
			append(padLeft(result.getStringRace400(),TIME_WIDTH)).
			append(padLeft(result.getStringHurdles110(),RESULT_WIDTH)).
			append(padLeft(result.getStringDiscusThrow(),RESULT_WIDTH)).
			append(padLeft(result.getStringPoleVault(),RESULT_WIDTH)).
			append(padLeft(result.getStringJavelinThrow(),RESULT_WIDTH)).
			append(padLeft(result.getStringRace1500(),TIME_WIDTH));
	}

	protected StringBuffer spaces(int length) {
		return repeatCharacter(length,' ');
	}
	protected StringBuffer underscores(int length) {
		return repeatCharacter(length,'_');		
	}
	
	private StringBuffer repeatCharacter(int length,char character) {
		StringBuffer dst = new StringBuffer();
		for (int i = 0; i < length; i++) {
			dst = dst.append(character);
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
