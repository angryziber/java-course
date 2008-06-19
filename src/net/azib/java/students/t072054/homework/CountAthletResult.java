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
	 * @param m100
	 * @param longJump
	 * @param shotPut
	 * @param highJump
	 * @param m400
	 * @param m110
	 * @param discus
	 * @param poleVault
	 * @param javelin
	 * @param m1500
	 * @return
	 */
	public static double countResult(double m100, double longJump, double shotPut, double highJump, double m400, double m110,
			double discus, double poleVault, double javelin, double m1500) {
		double result;

		m100 = Math.round(25.437 * Math.pow((18 - m100), 1.81));
		longJump = Math.round(0.14354 * Math.pow((longJump * 100 - 220), 1.40));
		shotPut = Math.round(51.39 * Math.pow((shotPut - 1.5), 1.05));
		highJump = Math.round(0.8465 * Math.pow((highJump * 100 - 75), 1.42));
		m400 = Math.round(1.53775 * Math.pow((82 - m400), 1.81));
		m110 = Math.round(5.74352 * Math.pow((28.5 - m110), 1.92));
		discus = Math.round(12.91 * Math.pow((discus - 4.0), 1.1));
		poleVault = Math.round(0.2797 * Math.pow((poleVault * 100 - 100), 1.35));
		javelin = Math.round(10.14 * Math.pow((javelin - 7.0), 1.08));
		m1500 = Math.round(0.03768 * Math.pow((480 - m1500), 1.85));

		result = m100 + longJump + shotPut + highJump + m400 + m110 + discus + poleVault + javelin + m1500;
		return result;

	}

	/**
	 * @param resultMap3
	 * @param ahleteId
	 * @param competitionId
	 * @return
	 */
	public static double countResultByID(Map<Integer, String[]> resultMap3, double ahleteId, double competitionId) {
		double[] buf = new double[20];
		String strBuf[] = new String[100]; // buffer for reading from
		// resultMap
		double result = 0;

		for (int j = 0; j < resultMap3.size(); j++) {
			// Reading data from database
			strBuf = resultMap3.get(j);

			for (int i = 1; i < 13; i++) {
				buf[i] = Double.parseDouble(strBuf[i]);
			}

			if (buf[1] == ahleteId && buf[2] == competitionId) {
				result = CountAthletResult.countResult(buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10], buf[11],
						buf[12]);

				return result;
			}
		}

		return -1;
	}
}
