package net.azib.java.students.t103784.homework;

/**
 * This class is used to calculate the scores of the athletes.
 *
 * @author      Ott Madis Ozolit <karuott321@hotmail.com>
 * @version     1.6
 * @since       2011.0520
 *
 */
public class ScoreCalculator {

	private static double[][] parameters = {
							{25.4347, 18, 1.81},
							{0.14354, 220, 1.4},
							{51.39, 1.5, 1.05},
							{0.8465, 75, 1.42},
							{1.53775, 82, 1.81},
							{5.74352, 28.5,	1.92},
							{12.91,	4, 1.1},
							{0.2797, 100, 1.35},
							{10.14,	7, 1.08},
							{0.03768, 480, 1.85}
	};

	/**
	 * Calculates the score of an athlete.
	 *
	 * Reads in all of the performance values of the athlete,
	 * then uses the corresponding formula to calculate the score
	 * of the performance (checks for if it is a track, jump or throwing event).
	 *
	 * @param athlete The athlete whose score is being calculated.
	 */
	public static void calculate(Athlete athlete) {

		int j = 0;
		int tempScore = athlete.getScore();
		for (int i = 0; i < 10; i++) {
			if(i == 0 || i == 4 || i == 5 || i == 9) {tempScore += calculateTrackEvents(parameters[i][j], parameters[i][j + 1], parameters[i][j + 2], athlete.getPerformance(i));}
			else if (i == 2 || i == 6 || i == 8) {tempScore += calculateThrowEvents(parameters[i][j], parameters[i][j + 1], parameters[i][j + 2], athlete.getPerformance(i));}
			else {tempScore += calculateJumpEvents(parameters[i][j], parameters[i][j + 1], parameters[i][j + 2], athlete.getPerformance(i));}
			j = 0;
		}
		athlete.setScore(tempScore);
}

	private static int calculateTrackEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((B - P), C)));}
	private static int calculateJumpEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((P*100 - B), C)));}
	private static int calculateThrowEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((P - B), C)));}

}
