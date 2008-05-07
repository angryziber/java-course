package net.azib.java.students.t072054.homework;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SortingID
 * 
 * @author r_vassiljev
 */
public class SortingID {

	//public static int[] SortByID() {
		 public static void main(String[] args) {
		int[] return_value = new int[10000];
		double[] buf = new double[10000];

		String str_buf[] = new String[100]; // buffer for reading from result_maps

		int[] choosed_indexes = new int[10000]; // Choosed indexes array
		int number_of_indexes = 0; // Number of choosed indexes
		char choosed_flag = 0; // If 1 - current row have already been choosed

		int number_of_rows = 2; // Number of not choosed rows in the table
		// (If 1 - the last row was choosed)

		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResults(result_map1, result_map2, result_map3);

		int count = 0; // counter
		int end_counter = 2; // counter of end conditions
		double max_num; // maximal value of result

		str_buf = result_map3.get(0);

		// Start to count decathlon points
		for (int i = 3; i < 13; i++) {
			// buf[i] = lnr.rs3.getDouble(i);
			buf[i] = Double.parseDouble(str_buf[i]);
		}
		double result = CountAthletResult.CountResult(buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10], buf[11],
				buf[12]);
		// END of decathlon count //
		max_num = result;

		int max_index = 1; // index of maximal number

		// All indexes are choosed?
		while (end_counter > 1) {
			// Starting to count rows
			number_of_rows = 0;
			count = 0;

			// End counter = 0
			end_counter = 0;

			while (count < result_map3.size()-1) {

				// Incrementing number of rows
				number_of_rows++;

				// Check that this row is not chosen
				for (int j = 0; j < number_of_indexes; j++) {
					if (choosed_indexes[j] == number_of_rows - 1)
						choosed_flag = 1;
				}

				if (choosed_flag == 0) {
					// START to count decathlon points
					str_buf = result_map3.get(number_of_rows);
					for (int i = 3; i < 13; i++) {
						// buf[i] = lnr.rs3.getDouble(i);
						buf[i] = Double.parseDouble(str_buf[i]);
						System.out.println(buf[i]);
					}
					result = CountAthletResult.CountResult(buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10],
							buf[11], buf[12]);
					// END of decathlon count //

					System.out.println("result = " + result);

					// New max value if result > max_num
					if (result > max_num) {
						max_num = result;
						max_index = count;
					}

					end_counter++;
				}

				count++;
				choosed_flag = 0;
			}

			// DEBUG output
			System.out.println("max_num = " + max_num);
			System.out.println("max_index = " + max_index);
			choosed_indexes[number_of_indexes] = max_index;
			max_num = 0;
			max_index = 0;
			number_of_indexes++;
		}

		//return return_value;
	}
}
