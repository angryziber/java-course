package net.azib.java.students.t103784.homework;

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

	public static void calculate(Athlete athlete) {

		int j = 0;
		int tempScore = athlete.getScore();
		for (int i = 0; i < 10; i++) {
			if(i == 0 || i == 4 || i == 5 || i == 9) {tempScore += calculateTrackEvents(parameters[i][j], parameters[i][j + 1], parameters[i][j + 2], athlete.getPerformance(i));}
			else if (i == 2 || i == 6 || i == 8) {tempScore += calculateThrowEvents(parameters[i][j], parameters[i][j +1], parameters[i][j +2], athlete.getPerformance(i));}
			else {tempScore += calculateJumpEvents(parameters[i][j], parameters[i][j +1], parameters[i][j +2], athlete.getPerformance(i));}
			j = 0;
			System.out.println(tempScore);
		}
		athlete.setScore(tempScore);
}

	public static int calculateTrackEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((B - P), C)));}
	public static int calculateJumpEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((P*100 - B), C)));}
	public static int calculateThrowEvents (double A, double B, double C, double P) {return (int) (A*(Math.pow((P - B), C)));}

}
