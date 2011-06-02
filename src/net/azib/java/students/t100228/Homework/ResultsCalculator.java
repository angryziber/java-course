package net.azib.java.students.t100228.Homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Calculates scores of athletes, calculates places in a competition
 * @author Martin
 */
public class ResultsCalculator {

	ArrayList<Integer> totalScores = new ArrayList<Integer>();

	/**
	 * Calculates the score of an athlete from event results
	 * @param records Array of results of athletes
	 * @throws Exception
	 */
	public static void calculateResults(ArrayList<Record> records) throws Exception{
		for(Record record : records)
		{
			Integer score = 0;

			// 100m
			score += calculateTrackScore((float)25.434, 18,  (float)1.81, record.getHundredMResult());

			//long jump
			score += calculateJumpScore((float)0.1435, 220, (float)1.4, record.getLongJumpResult());

			// shot put
			score += calculateThrowScore((float)51.39, (float)1.5, (float)1.05, record.getShotPutResult());

			// high jump
			score += calculateJumpScore((float)0.8465, 75, (float)1.42, record.getHighJumpResult());

			// 400 m
			score += calculateTrackScore((float)1.53775, 82, (float)1.81,
					Utils.minutesToSeconds(record.getFourHundredMResult()));

			// 110 m hurdles
			score += calculateTrackScore((float)5.74352, (float)28.5, (float)1.92, record.getOneHundredTenResult());

			// Discus throw
			score += calculateThrowScore((float)12.91, 4, (float)1.10, record.getDiscusResult());

			// pole vault
			score += calculateJumpScore((float)0.2797, 100, (float)1.35, record.getPoleVaultResult());

			// javelin throw
			score += calculateThrowScore((float)10.14, 7, (float)1.08, record.getJavelinResult());

			// 1500 m
			score += calculateTrackScore((float)0.03768, 480, (float)1.85,
					Utils.minutesToSeconds(record.getThousandFiveHundredResult()));

			record.setScore(score);
		}
	}

	/**
	 * Given the array with results of each athlete, orders athletes within the array by score with descending order;
	 * finds the place of each athlete
	 * @param records Array of athletes' results
	 * @throws Exception
	 */
	public static void calculatePlaces(ArrayList<Record> records) throws Exception{
		Collections.sort(records);

		Integer biggestPlace = 0;
		Integer smallestPlace = 0;

		boolean samePlaces = false;

		if(records.size() == 1)
		{
			records.get(0).setPlace("1");
		}
		else
		{
			for(Integer i = 0; i < records.size(); i++)
			{
				if(i < records.size() - 1)
				{
					biggestPlace++;
					if(records.get(i).getScore().intValue() == records.get(i + 1).getScore().intValue())
					{
						samePlaces = true;
					}
					else
					{
						samePlaces = false;
						smallestPlace++;
					}
				}
				else
				{
					samePlaces = false;
					biggestPlace++;
					smallestPlace++;
					if(records.get(i - 1).getScore() != records.get(i).getScore())
					{
						smallestPlace = biggestPlace;
					}

				}
				if(biggestPlace > smallestPlace)
				{
					if(samePlaces == false)
					{
						for(Integer j = smallestPlace; j < biggestPlace + 1; j++)
						{
							records.get(j - 1).setPlace(smallestPlace.toString() + "-" + biggestPlace.toString());
						}
						smallestPlace = biggestPlace;
					}
				}
				else
				{
					records.get(i).setPlace(biggestPlace.toString());
				}
			}
		}
	}

	/**
	 * Calculates the score of a running event by using the formula by IAAF
	 * @param a Parameter for calculation
	 * @param b Parameter for calculation
	 * @param c Parameter for calculation
	 * @param res Result of the event
	 * @return Score of the event
	 */
	public static int calculateTrackScore(float a, float b, float c, Float res) {
		return (int)(a * Math.pow(b - res, c));
	}

	/**
	 * Calculates the score of a jumping event by using the formula by IAAF
	 * @param a Parameter for calculation
	 * @param b Parameter for calculation
	 * @param c Parameter for calculation
	 * @param res Result of the event
	 * @return Score of the event
	 */
	public static int calculateJumpScore(float a, float b, float c, Float res) {
		return (int)(a * Math.pow(res - b, c));
	}

	/**
	 * Calculates the score of a throwing event by using the formula by IAAF
	 * @param a Parameter for calculation
	 * @param b Parameter for calculation
	 * @param c Parameter for calculation
	 * @param res Result of the event
	 * @return Score of the event
	 */
	public static int calculateThrowScore(float a, float b, float c, Float res) {
		return (int)(a * Math.pow(res - b, c));
	}
}
