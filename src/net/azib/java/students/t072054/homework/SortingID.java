package net.azib.java.students.t072054.homework;

import java.sql.SQLException;

/**
 * SortingID
 * 
 * @author r_vassiljev
 */
public class SortingID {

	public static int[] SortByID(){
	//public static void main(String[] args) {
		int[] return_value = new int[10000];
		double[] buf = new double[10000];

		int[] choosed_indexes = new int[10000]; // Choosed indexes array
		int number_of_indexes = 0; // Number of choosed indexes
		char choosed_flag = 0; // If 1 - current row have already been choosed

		int number_of_rows = 2; // Number of not choosed rows in the table
		// (If 1 - the last row was choosed)

		LoadNewResults lnr = new LoadNewResults();

		lnr.loadResults();

		try {

			int count = 0; // counter
			int end_counter = 2; //counter of end conditions
			double max_num; // maximal value of result

			// Start to count decathlon points
			for (int i = 4; i < 14; i++) {
				// System.out.println(lnr.rs3.getDouble(i));
				buf[i] = lnr.rs3.getDouble(i);
			}
			double result = CountAthletResult.CountResult(buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10], buf[11],
					buf[12], buf[13]);
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

				while (lnr.rs3.next()) {
					// Incrementing number of rows
					number_of_rows++;

					// Check that this row is not choosed
					for (int j = 0; j < number_of_indexes; j++) {
						if (choosed_indexes[j] == number_of_rows-1)
							choosed_flag = 1;
					}

					if (choosed_flag == 0) {
						// START to count decathlon points
						for (int i = 4; i < 14; i++) {
							// System.out.println(lnr.rs3.getDouble(i));
							buf[i] = lnr.rs3.getDouble(i);
						}
						result = CountAthletResult.CountResult(buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10], buf[11],
								buf[12], buf[13]);
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
				lnr.rs3.first();
			}
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}

		lnr.connClose();
		
		return return_value;
	}
}
