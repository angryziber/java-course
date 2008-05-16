package net.azib.java.students.t030604.homework;

import net.azib.java.students.t030604.homework.domain.FormulaComponent;
import net.azib.java.students.t030604.homework.domain.AthleteScore;
import static net.azib.java.students.t030604.homework.domain.FormulaComponent.*;

import java.util.Collections;
import java.util.List;

/**
 * Does all calculations.
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public final class DataProcessor {
	
	private DataProcessor()  {
		//intended
	}

	/**
	 * Does all the calculation and ordering of Players
	 * @param rawData
	 * @return
	 */
	public static List<AthleteScore> process(List<AthleteScore> rawData) {
		//sanity check
		if (rawData == null || rawData.size() == 0) {
			return rawData;
		}
		System.out.println("processing data");
		//calculate points
		for (AthleteScore score : rawData) {
			score.setPoints(calculatePoints(score));
		}
		//rank players
		Collections.sort(rawData);
		//set the ranks and shared ranks.
		setRanks(rawData);
		return rawData;
	}
	
	//sets the ranks and  shared ranks
	private static void setRanks(List<AthleteScore> rawData) {
		int i = 0;
		
		int currentPoints = 0;
		while (i < rawData.size()) {
			int sharedRank = 0;
			//set the rank
			rawData.get(i).setRank(i+1);
			currentPoints = rawData.get(i).getPoints();
			//look for shared ranks
			int j = i+1;
			while (j < rawData.size() &&  currentPoints == rawData.get(j).getPoints()) {
				rawData.get(j).setRank(i+1);
				sharedRank++;
				j++;
			}
			if (sharedRank > 0) {
				for(int k = i; k <= i+ sharedRank; k++) {
					rawData.get(k).setSharedRank(i+sharedRank+1);
				}
			}
			i+= sharedRank+1;
		}
	}
	
	//calculates total points for the player
	private static int calculatePoints(AthleteScore score) {
		return Math.round(
				calculateEventPoints(score.getSprint100(), SPRINT100)
				+ calculateEventPoints(score.getLongJump(), LONG_JUMP)
				+ calculateEventPoints(score.getShotPut(), SHOT_PUT)
				+ calculateEventPoints(score.getHighJump(), HIGH_JUMP)
				+ calculateEventPoints(score.getSprint400(), SPRINT400)
				+ calculateEventPoints(score.getHurdles110(), HURDLES110)
				+ calculateEventPoints(score.getDiscusThrow(), DISCUS_THROW)
				+ calculateEventPoints(score.getPoleVault(), POLE_VAULT)
				+ calculateEventPoints(score.getJavelinThrow(), JAVELIN_THROW)
				+ calculateEventPoints(score.getRace1500(), RACE1500));
	}
	
	//calculates single event points
	private static float calculateEventPoints(float result, FormulaComponent object) {
		float temp =  (float) (object.isRunning() 
			? object.getA()* Math.pow((object.getB() - (result * object.getSiCoeficient())), object.getC())
			: object.getA()* Math.pow(( (result * object.getSiCoeficient()) - object.getB()), object.getC()));
		return temp;
	}
}
