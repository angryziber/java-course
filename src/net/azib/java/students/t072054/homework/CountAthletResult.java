package net.azib.java.students.t072054.homework;

import java.lang.Math;
import java.util.Map;

/**
 * CountAthletResult
 * 
 * @author r_vassiljev
 */
public class CountAthletResult {
	/**
	 * Counts score by results of different events
	 * 
	 * @param m100
	 * @param long_jump
	 * @param shot_put
	 * @param high_jump
	 * @param m400
	 * @param m110
	 * @param discus
	 * @param pole_vault
	 * @param javelin
	 * @param m1500
	 * @return Athlete's score
	 */
	public static double CountResult(double m100, double long_jump, double shot_put, double high_jump, double m400, double m110,
			double discus, double pole_vault, double javelin, double m1500) {
		double result;

		m100 = Math.round(25.437 * Math.pow((18 - m100), 1.81));
		long_jump = Math.round(0.14354 * Math.pow((long_jump * 100 - 220), 1.40));
		shot_put = Math.round(51.39 * Math.pow((shot_put - 1.5), 1.05));
		high_jump = Math.round(0.8465 * Math.pow((high_jump * 100 - 75), 1.42));
		m400 = Math.round(1.53775 * Math.pow((82 - m400), 1.81));
		m110 = Math.round(5.74352 * Math.pow((28.5 - m110), 1.92));
		discus = Math.round(12.91 * Math.pow((discus - 4.0), 1.1));
		pole_vault = Math.round(0.2797 * Math.pow((pole_vault * 100 - 100), 1.35));
		javelin = Math.round(10.14 * Math.pow((javelin - 7.0), 1.08));
		m1500 = Math.round(0.03768 * Math.pow((480 - m1500), 1.85));

		result = m100 + long_jump + shot_put + high_jump + m400 + m110 + discus + pole_vault + javelin + m1500;
		return result;

	}

	/**
	 * Counts result of athlete by athlete's ID
	 * 
	 * @param result_map3
	 * @param athlete_id
	 * @param competition_id
	 * @return
	 */
	public static double CountResultByID(Map<Integer, String[]> result_map3, double athlete_id, double competition_id) {
		double[] buf = new double[20];
		String str_buf[] = new String[100]; // buffer for reading from
											// result_map
		double result = 0;

		for (int j = 0; j < result_map3.size(); j++) {
			// Reading data from database
			str_buf = result_map3.get(j);

			for (int i = 1; i < 13; i++) {
				buf[i] = Double.parseDouble(str_buf[i]);
			}

			if (buf[1] == athlete_id && buf[2] == competition_id) {
				result = CountAthletResult.CountResult(buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10], buf[11],
						buf[12]);

				return result;
			}
		}
		
		return -1;
	}
}
