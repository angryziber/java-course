package net.azib.java.students.t103784.homework;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 14.05.11
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class ScoreCalculator {

	double[][] parameters = {
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

	public ScoreCalculator(Athlete athlete) {

		int j = 0;
		for (int i = 0; i < 10; i++) {
			if(i == 0 || i == 4 || i == 5 || i == 9) {athlete.score += calculateTrackEvents(parameters[i][j], parameters[i][j + 1], parameters[i][j + 2], athlete.performance[i]);}
			else if (i == 2 || i == 6 || i == 8) {athlete.score += calculateThrowEvents(parameters[i][j], parameters[i][j +1], parameters[i][j +2], athlete.performance[i]);}
			else {athlete.score += calculateJumpEvents(parameters[i][j], parameters[i][j +1], parameters[i][j +2], athlete.performance[i]);}
			j = 0;
		}
}

	public int calculateTrackEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((B - P), C)));}
	public int calculateJumpEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((P*100 - B), C)));}
	public int calculateThrowEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((P - B), C)));}

}
