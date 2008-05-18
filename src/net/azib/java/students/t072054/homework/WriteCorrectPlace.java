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

	static int num_rows = 0;

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
		boolean flag_score_written = false;

		for (int i = 0; (i < num_rows) && !flag_score_written; i++) {
			if (score < scores[i]) {
				for (int j = num_rows; j > i; j--) {
					scores[j] = scores[j - 1];
					ids[j] = ids[j - 1];
				}

				scores[i] = score;
				ids[i] = id;

				flag_score_written = true;
			}
		}

		if (!flag_score_written) {
			scores[num_rows] = score;
			ids[num_rows] = id;
		}

		num_rows++;
	}

	/**
	 * Returns a place of athlete by the score
	 * 
	 * @param score
	 * @return
	 */
	public String returnPlace(double score) {
		// Number of equal scores
		int num_of_equal = 0;
		// Place string that will be returned
		String place = " ";

		// Find the amount of equal scores
		for (int i = 0; i < num_rows; i++) {
			if (scores[i] == score) {
				num_of_equal++;
			}
		}

		// Find the place
		for (int i = 0; i < num_rows; i++) {
			if (scores[i] == score) {
				place = String.valueOf(num_rows - i);
				for (int j = 1; j < num_of_equal; j++) {
					place = place + "-" + String.valueOf(num_rows - i + j);
				}
			}
		}

		return place;
	}
}
