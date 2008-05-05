package net.azib.java.students.t072054.homework;

import java.sql.SQLException;

/**
 * ShowResults
 * 
 * @author r_vassiljev
 */
public class ShowResults {
	public static void ShowResultsAll(int[] indexes, int num_of_results) {
		// public static void main(String[] args) {
		LoadNewResults lnr = new LoadNewResults();

		lnr.LoadResults();

		try {
			for (int i = 0; i < num_of_results; i++) {
				for (int j = 0; j < indexes[i]; j++) {
					lnr.rs1.next();
				}

				System.out.println(lnr.rs1.getString(1));
				System.out.println(lnr.rs1.getString(2));
				System.out.println();

			}
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
	}
}
