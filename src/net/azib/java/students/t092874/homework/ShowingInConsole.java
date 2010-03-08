package net.azib.java.students.t092874.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ShowingInConsole
 * 
 * @author Aleksandr GLadki
 */
class ShowingInConsole {
	/**
	 *@param read
	 *            input data from console
	 *@return List<Result>
	 */
	public List<Result> read() {
		List<Result> resultsList = new ArrayList<Result>();
		System.out.println("Enter a line.");
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			String strLine;
			while (!("").equals(strLine = reader.readLine())) {
				try {
					if (strLine.split(",").length != 13)
						System.out.println("Line donn't consist of 13 elements");
					else
						resultsList.add(new Result(strLine.split(",")));
				}
				catch (NumberFormatException num) {
					System.out.println();
					System.out.println("Exeption " + num.getMessage() + ". Cannot convert to Number .");
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return resultsList;
	}

	/**
	 * 
	 * @param source
	 *            List<Results> and write it in console.
	 */
	public void write(List<Result> results) {
		int placeNum = 0, pointsNum = 0;
		for (Result result : results) {

			if (placeNum == 0) {
				placeNum = 1;
				pointsNum = result.getPoints();
			}
			else if (result.getPoints() != pointsNum) {
				placeNum++;
			}
			pointsNum = result.getPoints();

			System.out.println(placeNum + "," + result.putToString(false));
		}
	}
}
