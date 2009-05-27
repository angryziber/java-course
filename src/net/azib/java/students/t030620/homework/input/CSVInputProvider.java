package net.azib.java.students.t030620.homework.input;

import net.azib.java.students.t030620.homework.beans.DecathleteScore;
import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;
import net.azib.java.students.t030620.homework.util.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * CSVInputProvider
 *
 * @author Lord HellBunny
 */
public class CSVInputProvider implements InputProvider {

	@Override
	public Collection<DecathleteScoreKeeper> getInput(Object param) throws Exception {
		File inputFile = (File)param;
		
		Set<DecathleteScoreKeeper> scores = new TreeSet<DecathleteScoreKeeper>();	      
		BufferedReader input =  new BufferedReader(new FileReader(inputFile));
		
		try {
			String line = null; 	     
			int i = 0;
			while (( line = input.readLine()) != null){
				if(!line.trim().isEmpty()) {
					DecathleteScore score = getScoreFromLine(line, i);
					DecathleteScoreKeeper scoreWrapper = new DecathleteScoreKeeper(score);
					scoreWrapper.calclulateScore();
					scores.add(scoreWrapper);
				}
				i++;
			}
		} finally {
			input.close();
		}
		
		return scores;	
	}
	
	
	private DecathleteScore getScoreFromLine(String line, int lineNr) throws Exception {
		
		DecathleteScore score = new DecathleteScore();
		
		String[] params = line.split(",",13);
		
		if(params.length < 13) {
			throw new Exception("Insufficient values amount at line "+lineNr+"");
		}
		
		String name = params[0].trim(); 
		score.setName(name.replaceAll("\"","")); 		
		
		score.setDate(Utils.parseTimestamp(params[1].trim(), lineNr));
		
		String countryCode = params[2].trim();
		if(countryCode.length()!=2) {
			throw new Exception("Invalid country code parameter("+countryCode+") in line "+lineNr);
		}
		score.setCountryCode(countryCode);
		Map<Competition, Double> map = new HashMap<Competition, Double>();
		
		map.put(Competition.SPRINT_100, Utils.parseDouble(params[3], lineNr));
		map.put(Competition.LONG_JUMP, Utils.parseDouble(params[4], lineNr)*100);
		map.put(Competition.SHOT_PUT, Utils.parseDouble(params[5], lineNr));
		map.put(Competition.HIGH_JUMP,Utils.parseDouble(params[6], lineNr)*100);
		map.put(Competition.SPRINT_400, Utils.parseSeconds(params[7], lineNr));
		map.put(Competition.HURDLES, Utils.parseDouble(params[8], lineNr));
		map.put(Competition.DISCUS_THROW, Utils.parseDouble(params[9], lineNr));
		map.put(Competition.POLE_VAULT, Utils.parseDouble(params[10], lineNr)*100);
		map.put(Competition.JAVELIN_THROW, Utils.parseDouble(params[11], lineNr));
		map.put(Competition.RACE, Utils.parseSeconds(params[12], lineNr));

		score.setScores(map);
		
		
		return score;
	}
	
	

}


