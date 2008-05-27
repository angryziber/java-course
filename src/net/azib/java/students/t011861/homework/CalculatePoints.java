package net.azib.java.students.t011861.homework;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * CalculatePoints
 *
 * @author t011861
 */

public class CalculatePoints {
	List<Double[]> CalculatedPoints = new ArrayList<Double[]>();
	/**
	 * Gets results and calculates all the points of sports events, including total points
	 * and puts them into array and return this.
	 * @param List<String[]> It consists of data which comes from input 
	 * modules (DataFromConsole, DataFromCsv and DataFromMySQL)! Input data has the same
	 * format and structure in every circumstances! It doesn't depend on input module.
	 * @return Double ArrayList (List<Double[]>). It only consists of all points separately 
	 * and total points.
	 */
	public List<Double[]> processResults(List<String[]> allAthletes) throws Exception
	{
		List<? super Double> resultsPerAthlete = null;
		resultsPerAthlete = new ArrayList<Double>();
		for (String[] singleAthlete : allAthletes) 
		{
			int columnCount = singleAthlete.length;
			double totalPoints = 0;
			String tempRes = "";
			for (int i = 3; i<columnCount; i++) 
			{	
				if (i==7 || i==12 || i==3)
				{
					String[] timeParts = singleAthlete[i].trim().split(":");
					if (timeParts.length != 1)
					{
						tempRes = String.valueOf(Double.valueOf(timeParts[0])*60 + Double.valueOf(timeParts[1]));
					}
					else
					{
						tempRes = singleAthlete[i].trim();
					}
				}
				else
				{
					tempRes = singleAthlete[i].trim();
				}
				double athleteResult = Double.valueOf(tempRes).doubleValue();
				double points = calculatePoints(athleteResult, i);
				Long roundedPoints = Math.round(points);
				resultsPerAthlete.add(roundedPoints.doubleValue());
				totalPoints = totalPoints + roundedPoints; 
			}
			resultsPerAthlete.add(totalPoints);
			CalculatedPoints.add((Double[]) resultsPerAthlete.toArray(new Double[resultsPerAthlete.size()]));
			resultsPerAthlete.clear();
		}
		return CalculatedPoints;
	}
	//Function which calculates the points of every sports events!  
	private double calculatePoints(Double result, int j) 
	{
		switch (j) 
		{
		// 100 m points (second)
		case 3: return (25.437*Math.pow(18 - result, 1.81));
		// long jump points (centimeter)
		case 4: return (0.14354*Math.pow(result*100 - 220, 1.4));
		// shot put (m)
		case 5: return (51.39*Math.pow(result - 1.5, 1.05));
		// high jump (centimeter)
		case 6: return (0.8465*Math.pow(result*100 - 75, 1.42));
		// 400 m (second)
		case 7: return (1.53775*Math.pow(82 - result, 1.81));
		// 110 m (second)
		case 8: return (5.74352*Math.pow(28.5 - result, 1.92));
		// Discus throw (meter)
		case 9: return (12.91 * Math.pow(result - 4, 1.1));
		// pole vault (centimeter)
		case 10: return (0.2797 * Math.pow(result*100 - 100, 1.35));
		// javelin throw (meter)
		case 11: return (10.14 * Math.pow(result - 7, 1.08));
		// 1500 m (second)
		case 12: return (0.03768 * Math.pow(480 - result, 1.85));
		default: return 3;
		}
	}
}