package net.azib.java.students.t030620.homework.input;

import net.azib.java.students.t030620.homework.beans.DecathleteScore;
import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;
import net.azib.java.students.t030620.homework.util.Utils;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * ConsoleInputProvider
 *
 * @author Maksim Konstantinov 030620
 */
public class ConsoleInputProvider implements InputProvider {

	/**
	 * @param param pass null instead of it
	 * @return sorted collection of DecathleteScoreKeeper with the calculated scores
	 */
	@Override
	public Collection<DecathleteScoreKeeper> getInput(Object param) throws Exception {
		Set<DecathleteScoreKeeper> scores = new TreeSet<DecathleteScoreKeeper>();	 
		
		Scanner in = new Scanner(System.in);
		Utils.prompt("Console input started (type \"exit\" to exit the application)");
		
		boolean finish = false;
		while(!finish) {
			DecathleteScore score = getScoreFromConsole(in);
			DecathleteScoreKeeper scoreWrapper = new DecathleteScoreKeeper(score);
			scoreWrapper.calclulateScore();
			scores.add(scoreWrapper);
			
			String line = "";
			while(line.trim().isEmpty()) {
				Utils.prompt("Coninue input? (y/n/exit)");
				line = in.nextLine();
				if(!line.matches("(y)|(n)|(exit)")) {
					line = "";
				}
				if(line.equals("n")) {finish = true;}
				else if(line.equals("exit")) {
					finish = true;
					scores = null;
				}
			}	
		}
		
		in.close();  
		return scores;
	}
	
	private DecathleteScore getScoreFromConsole(Scanner in) {
		DecathleteScore score = new DecathleteScore();

		score.setName(getName(in));
		score.setDate(getDate(in));
		score.setCountryCode(getCountryCode(in));
		
		Map<Competition, Double> map = new HashMap<Competition, Double>();

		map.put(Competition.SPRINT_100, getDouble(Competition.SPRINT_100.getName(), in));
		map.put(Competition.LONG_JUMP, getDouble(Competition.LONG_JUMP.getName(), in)*100);
		map.put(Competition.SHOT_PUT, getDouble(Competition.SHOT_PUT.getName(), in));
		map.put(Competition.HIGH_JUMP,getDouble(Competition.HIGH_JUMP.getName(), in)*100);
		map.put(Competition.SPRINT_400, getSeconds(Competition.SPRINT_400.getName(), in));
		map.put(Competition.HURDLES, getDouble(Competition.HURDLES.getName(), in));
		map.put(Competition.DISCUS_THROW, getDouble(Competition.DISCUS_THROW.getName(), in));
		map.put(Competition.POLE_VAULT, getDouble(Competition.POLE_VAULT.getName(), in)*100);
		map.put(Competition.JAVELIN_THROW, getDouble(Competition.JAVELIN_THROW.getName(), in));
		map.put(Competition.RACE, getSeconds(Competition.RACE.getName(), in));
	 
		score.setScores(map);
		
		return score;
	}
	
	private String getName(Scanner in) {
		Utils.prompt("Please enter decathlete name");
		String name = in.nextLine().trim();
		while(name.isEmpty() || !name.matches("[a-zA-Z][a-zA-Z\\s]*")) {
			Utils.prompt("Empty name or wrong name format, only word characreters are allowed, please try again");
			name = in.nextLine().trim();
		}
		return name;
	}
	

	private String getCountryCode(Scanner in) {
		Utils.prompt("Please enter country code (2 letters)");
		String code = in.nextLine().trim();
		while(code.isEmpty() || !code.matches("[a-zA-Z]{2}")) {
			Utils.prompt("Empty code or wrong code format, only 2 word characters are allowed, please try again");
			code = in.nextLine().trim();
		}
		
		return code.toUpperCase();
	}
	
	private Timestamp getDate(Scanner in) {
		Utils.prompt("Please enter decathlete date of birth (dd.MM.YYYY)");
		Timestamp date = null;
		boolean first = true;
		while(date == null) {
			if(!first) {Utils.prompt("Empty date or code format(dd.MM.YYYY expected), please try again");}
			first = false;
			try {
				date = Utils.parseTimestamp(in.nextLine(),-1 );
			} catch (Exception e) {}
		}
		
		return date;
	}
	
	private double getDouble(String fieldName, Scanner in) {
		Utils.prompt("Please enter the result of "+fieldName);
		double result = -1;
		boolean first = true;
		while(result == -1) {
			if(!first) {Utils.prompt("Empty value or invalid value format (dot separated float value expected), please try again");}
			first = false;
			try {
				result = Utils.parseDouble(in.nextLine(), -1);
			} catch (Exception e) {}
		}
		
		return result;
	}
	
	private double getSeconds(String fieldName, Scanner in) {
		Utils.prompt("Please enter the result of "+fieldName);
		double result = -1;
		boolean first = true;
		while(result == -1) {
			if(!first) {Utils.prompt("Empty value or invalid value format (min:sec is expected), please try again");}
			first = false;
			try {
				result = Utils.parseSeconds(in.nextLine(), -1);
			} catch (Exception e) {}
		}		
		return result;
	}
	
	
	
	

}
