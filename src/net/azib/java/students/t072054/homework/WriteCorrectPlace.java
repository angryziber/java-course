package net.azib.java.students.t072054.homework;

/**
 * WriteCorrectPlace
 * 
 * @author r_vassiljev
 */
public class WriteCorrectPlace {
	static String[] places;
	static double[] ids;
	static double[] scores;

	static int numRows = 0;

	public WriteCorrectPlace(int length) {
		places = new String[length];
		ids = new double[length];
		scores = new double[length];
	}

	/**
	 * Adds athlete's data to massive
	 * 
	 * @param id
	 * @param score
	 */
	public void addScore(double id, double score) {
		boolean flagScoreWritten = false;

		for (int i = 0; (i < numRows) && !flagScoreWritten; i++) {
			if (score < scores[i]) {
				for (int j = numRows; j > i; j--) {
					scores[j] = scores[j - 1];
					ids[j] = ids[j - 1];
				}

				scores[i] = score;
				ids[i] = id;

				flagScoreWritten = true;
			}
		}

		if (!flagScoreWritten) {
			scores[numRows] = score;
			ids[numRows] = id;
		}

		numRows++;
	}

	/**
	 * Returns a place of athlete by the score
	 * 
	 * @param score
	 * @return
	 */
	public String returnPlace(double score) {
		// Number of equal scores
		int numOfEqual = 0;
		// Place string that will be returned
		String place = " ";

		// Find the amount of equal scores
		for (int i = 0; i < numRows; i++) {
			if (scores[i] == score) {
				numOfEqual++;
			}
		}

		// Find the place
		for (int i = 0; i < numRows; i++) {
			if (scores[i] == score) {
				place = String.valueOf(numRows - i);
				for (int j = 1; j < numOfEqual; j++) {
					place = place + "-" + String.valueOf(numRows - i + j);
				}
			}
		}

		return place;
	}
}
