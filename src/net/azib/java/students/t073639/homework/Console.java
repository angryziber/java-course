package net.azib.java.students.t073639.homework;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * Console class extends AthleteList.<br>
 * Instance of Console class has methods to read or write data using console.
 * 
 * @author t073639
 * @see AthleteList
 */
public class Console extends AthleteList {

	/**
	 * <p>
	 * Create a new list of athletes, which is copy of parameter.
	 * 
	 * @param inputAthleteList
	 *            - List of athletes
	 */
	public Console(List<Athlete> inputAthleteList) {
		super(inputAthleteList);
	}

	/**
	 * <p>
	 * Method for adding to list of athletes new athlete. <br>
	 * Infinite loop, which waits for new data, data is controlled by pattern.
	 * Displays console messages if entered data is correct or not. <br>
	 * To finish type "finish" or "q".
	 */
	public void inputResults() {
		Scanner scanner;
		System.out.println("\t*Add new record\n"
				+ "(example:\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72)"
				+ "\nCommand \"finish\" or \"q\" displays result and quits");
		while (true) {
			boolean quit = false;
			scanner = new Scanner(System.in).useDelimiter("\n");
			if (scanner.hasNext("finish") || scanner.hasNext("q"))
				break;
			if (scanner.hasNext("\"[\\D\\ ]+\"," + "[0-9]{1,2}\\.[0-9]{2}\\.[0-9]{4},[A-Z]{2},[0-9]+\\.[0-9]{2}"
					+ ",(([0-9]+\\.[0-9]{2})|([0-9]+)),[0-9]+\\.[0-9]{2},(([0-9]+\\.[0-9]{2})|([0-9]+))"
					+ ",[0-9:]+\\.[0-9]{2},[0-9]+\\.[0-9]{2},[0-9]+\\.[0-9]{2},(([0-9]+\\.[0-9]{2})|([0-9]+)),[0-9]+\\.[0-9]{2}"
					+ ",[0-9:]+\\.[0-9]{2}[\\ ]*"))
				while (true) {
					this.addNewAthlete(scanner.nextLine());
					System.out.println("\t*-->Added.");
					if (scanner.hasNext("finish") || scanner.hasNext("q")) {
						quit = true;
						break;
					}
				}
			else {
				System.out.println("\t*Incorrect record");
			}
			if (quit) {
				break;
			}
		}
		this.sortAndSetPlaces();
	}

	/**
	 * <p>
	 * Create a new empty list of athletes.
	 */
	public Console() {
		super();
	}

	/**
	 * <p>
	 * Method displays all athletes to console.
	 */
	public void printFinalResults() {
		Iterator<Athlete> it = this.getInputAthleteList().iterator();
		if (it.hasNext()) {
			System.out.println("\t*Final results are:");
			while (it.hasNext()) {
				System.out.println(it.next().toStringWithFinal());
			}
		}
		else
			System.out.println("\t*No data");
	}

}
