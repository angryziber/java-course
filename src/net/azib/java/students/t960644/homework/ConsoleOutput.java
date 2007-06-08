package net.azib.java.students.t960644.homework;

import java.io.PrintStream;

/**
 * ConsoleOutput
 * 
 * Class for outputting competition results to the console. The maximum width for name and position fields is determined and all lines have exactly the same width if viewed with fixed width characters. Unfortunately the Japanese characters are twice as wide. :( 
 *   
 */
public class ConsoleOutput {
	private final int RESULT_WIDTH = 6;
	private final int DATE_WIDTH = 10;
	private final int TIME_WIDTH = 8;
	private final int COUNTRY_WIDTH = 2;
	private final int SCORE_WIDTH = 5;
	
	/**
	 * Writes the results list to the printstream.
	 * @param out PrintStream to write the list of results to
	 * @param competition Competition that has been filled with data and sorted
	 */
	public void writeData(PrintStream out,Competition competition) {
		int posWidth = 3;
		int nameWidth = 4;
		for (Result r : competition.getResults()) {
			nameWidth = nameWidth < r.getAthlete().getName().length() ? r.getAthlete().getName().length() : nameWidth;
			posWidth = posWidth < r.getPosition().length() ? r.getPosition().length() : posWidth;
		}
		out.println(writeHeader(posWidth,nameWidth));
		out.println(hyphens(8*RESULT_WIDTH+2*TIME_WIDTH+SCORE_WIDTH+DATE_WIDTH+COUNTRY_WIDTH+posWidth+nameWidth+15));
		for (Result r : competition.getResults()) {
			out.println(writeLine(posWidth,nameWidth,r));
		}
	}
	/**
	 * Writes a line of column headers.
	 * @param posWidth width of the Position column 
	 * @param nameWidth width of the Name column
	 * @return Stringbuffer containing the headers for each column matching the column widths
	 */
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
	/**
	 * Writes a line of performance results
	 * @param posWidth width of the Position column 
	 * @param nameWidth width of the Name column
	 * @param result a filled Result
	 * @return StringBuffer containing the Result fields formatted to column widths
	 */
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
	/**
	 * Retunrns a StringBuffer of specified length containing spaces  
	 * @param length number of characters
	 * @return A StringBuffer consisting of spaces
	 */
	protected StringBuffer spaces(int length) {
		return repeatCharacter(length,' ');
	}
	/**
	 * Retunrns a Stringbuffer of specified length containing hyphens
	 * @param length number of characters
	 * @return A StringBuffer consisting of hyphens
	 */
	protected StringBuffer hyphens(int length) {
		return repeatCharacter(length,'-');		
	}
	/**
	 * Retunrns a StringBuffer of specified length containing specified character
	 * @param length number of characters
	 * @param character character to repeat
	 * @return A StringBuffer consisting of specified character with specified length
	 */
	private StringBuffer repeatCharacter(int length,char character) {
		StringBuffer dst = new StringBuffer();
		for (int i = 0; i < length; i++) {
			dst = dst.append(character);
		}
		return dst;
	}
	/**
	 * Pads a String from the left with spaces to match required length and adds a '|' to note column separator
	 * @param src String to pad
	 * @param length the desired length of padded String
	 * @return StringBuffer with spaces added to the left to reach the specified length and a '|' symbol added to the right
	 */
	protected StringBuffer padLeft(String src, int length) {
		return spaces(length - src.length()).append(src).append("|");
	}
	/**
	 * Pads a String from the right with spaces to match required length and adds a '|' to note column separator
	 * @param src String to pad
	 * @param length the desired length of padded String
	 * @return StringBuffer with spaces added to the right to reach the specified length and a '|' symbol added to the right
	 */
	protected StringBuffer padRight(String src, int length) {
		return spaces(length - src.length()).insert(0, src).append("|");
	}

}
