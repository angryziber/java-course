package net.azib.java.students.t072054.homework;

import java.util.Map;
import java.util.ArrayList;

/**
 * SortingID
 * 
 * @author r_vassiljev
 */

public class SortingID {

	/**
	 * Sorting athletes' IDs by results of the competition
	 * 
	 * @param resultMap1
	 * @param resultMap2
	 * @param resultMap3
	 * @param eventId
	 * @return List of athletes' id-s
	 */
	public static ArrayList<Integer> sortByID(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3, double eventId) {
		ArrayList<Integer> returnValue = new ArrayList<Integer>();
		double[] buf = new double[20];

		String strBuf[] = new String[100]; // buffer for reading from
											// resultMaps

		int[] choosedIndexes = new int[10000]; // Chosen indexes array
		int numberOfIndexes = 0; // Number of chosen indexes
		char choosedFlag = 0; // If 1 - current row have already been chosen

		int numberOfRows = 2; // Number of not chosen rows in the table

		int count = 0; // counter
		int endCounter = 2; // counter of end conditions
		double maxNum; // maximal value of result
		int maxIndex = 1; // index of maximal number
		double maxAthlet = 0; // index of athlete with maximum score

		strBuf = resultMap3.get(0);

		// Start to count decathlon points
		buf[1] = Double.parseDouble(strBuf[1]);
		for (int i = 3; i < 13; i++) {
			buf[i] = Double.parseDouble(strBuf[i]);
		}
		double result = CountAthletResult.countResult(buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10], buf[11],
				buf[12]);
		// END of decathlon count //
		maxNum = result;
		maxAthlet = buf[1];
		maxIndex = 0;

		// All indexes are choosed?
		while (endCounter > 1) {
			// Starting to count rows
			numberOfRows = 0;
			count = 0;

			// End counter = 0
			endCounter = 0;

			while (count < resultMap3.size()) {

				// Incrementing number of rows
				numberOfRows++;

				// Check that this row is not chosen
				for (int j = 0; j < numberOfIndexes; j++) {
					if (choosedIndexes[j] == numberOfRows - 1)
						choosedFlag = 1;
				}

				// Reading data from database
				strBuf = resultMap3.get(count);

				// Check the id of competition
				buf[2] = Double.parseDouble(strBuf[2]);

				if ((choosedFlag == 0) && (eventId == buf[2])) {
					// START to count decathlon points
					// strBuf = resultMap3.get(count);

					// DEBUG output
					// System.out.println("number of rows = " + numberOfRows);

					buf[1] = Double.parseDouble(strBuf[1]);
					for (int i = 3; i < 13; i++) {
						// buf[i] = lnr.rs3.getDouble(i);
						buf[i] = Double.parseDouble(strBuf[i]);

						// DEBUG output
						// System.out.println(buf[i]);
					}
					result = CountAthletResult.countResult(buf[3], buf[4], buf[5], buf[6], buf[7], buf[8], buf[9], buf[10],
							buf[11], buf[12]);
					// END of decathlon count //

					// DEBUG output
					// System.out.println("result = " + result);

					// New max value if result > maxNum
					if (result > maxNum) {
						maxNum = result;
						maxIndex = count;
						maxAthlet = buf[1];
					}

					endCounter++;
				}

				count++;
				choosedFlag = 0;
			}

			// DEBUG output
			// System.out.println("maxNum = " + maxNum);
			// System.out.println("maxIndex = " + maxIndex);
			// System.out.println("maxAthlet = " + maxAthlet);

			choosedIndexes[numberOfIndexes] = maxIndex;
			returnValue.add((int) maxAthlet);
			maxNum = 0;
			maxIndex = 0;
			numberOfIndexes++;
		}

		return returnValue;
	}
}
