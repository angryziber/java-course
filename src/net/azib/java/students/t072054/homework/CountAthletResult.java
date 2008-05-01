package net.azib.java.students.t072054.homework;

import java.lang.Math;
/**
 * CountAthletResult
 * 
 * @author r_vassiljev
 */
public class CountAthletResult {
	public static double CountResult(double m100, double long_jump, double shot_put,
			double high_jump, double m400, double m110, double discus, double pole_vault,
			double javelin, double m1500) {
		double result;
		
		m100 = 25.437 * Math.pow((18 - m100), 1.81);
		long_jump = 0.14354 * Math.pow((long_jump*100 - 220), 1.40);
		shot_put = 51.39 * Math.pow((shot_put - 1.5), 1.05);
		high_jump = 0.8465 * Math.pow((high_jump*100 - 75), 1.42);
		m400 = 1.53775 * Math.pow((82 - m400), 1.81);
		m110 = 5.74352 * Math.pow((28.5 - m110), 1.92);
		discus = 12.91 * Math.pow((discus - 4.0), 1.1);
		pole_vault = 0.2797 * Math.pow((pole_vault*100 - 100), 1.35);
		javelin = 10.14 * Math.pow((javelin - 7.0), 1.08);
		m1500 = 0.03768 * Math.pow((480 - m1500), 1.85);
		
		// Debug output
		/*System.out.println(m100);
		System.out.println(long_jump);
		System.out.println(shot_put);
		System.out.println(high_jump);
		System.out.println(m400);
		System.out.println(m110);
		System.out.println(discus);
		System.out.println(pole_vault);
		System.out.println(javelin);
		System.out.println(m1500);*/
		
		result = m100 + long_jump + shot_put + high_jump + m400 +
		m110 + discus + pole_vault + javelin + m1500;
		return result;
		
	}
}
