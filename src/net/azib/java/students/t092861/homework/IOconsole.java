package net.azib.java.students.t092861.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Stanislav / 092861
 * 
 */
public class IOconsole extends AbstractIO {
	
	private Athlete athlete;
	private boolean invalidInput;
	
	/**
	 * File name or the path to the file.
	 */
	public String parameters = "";

	public IOconsole(Controller ctrl) {
		super(ctrl);
	}

	@Override
	ArrayList<Athlete> input() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		int index = 1;
		String line;
		int iterator = 0;

		out.println("Please enter competition data: ");
		try {
			while (true) {
				athlete = new Athlete();
				ControllerInput.setController(ctrl);
				for (iterator = 0; iterator < ControllerInput.Field.values().length; iterator++) {
					inputData = new ArrayList<String>();
					ControllerInput.Field field = ControllerInput.Field.values()[iterator];
					out.print((index) + ": " + field.name() + ": ");
					line = reader.readLine();
					invalidInput = field.parseAndStore(line, athlete);
					if (invalidInput) {
						iterator--;
					}
				}
				int points = ctrl.calculatePoints(athlete);
				athlete.setScore(points);
				athletes.add(athlete);
				out.print("\nWould you like to add another athlet (y/n)?");
				line = reader.readLine();
				if (line.equalsIgnoreCase("n")) {
					break;
				} else {
					out.println("");
					index++;
				}
			}
		} catch (IOException e) {
			out.println("\nError while reading the input line. Please check your data!");
			iterator--;
		}
		return athletes;
	}

	@Override
	void output(ArrayList<Athlete> athletes) {
		printTableHeader();
		Iterator<Athlete> itr = arrangeInOrder(athletes).iterator();
		String name = null;
		while (itr.hasNext()) {
			Athlete item = itr.next();
			// if the name is wider than 20 chars
			if (item.getName().length() > 20) {
				// cutting off the last letters
				name = item.getName().substring(0, 20);
			} else {
				name = item.getName();
			}
			out
					.printf(
							" %3s| %-21s|%10s |%5s |%6s |%6s |%6s |%6s |%8s |%6s |%6s |%6s |%8s |%8s |%6s\n",
							item.getPlace(), 
							name, 
							this.convertDateDMY(item.getBirthday()), 
							item.getCountry(), 
							item.getSprint100(), 
							item.getLongJump(), 
							item.getShortPut(), 
							item.getHighJump(), 
							this.convertTimeToString(item.getSprint400()), 
							item.getHurdles(), 
							item.getDiscusThrow(), 
							item.getPoleVault(),
							item.getJavelinThrow(), 
							this.convertTimeToString(item.getSprint1500()), 
							item.getScore());
		}
	}

	/**
	 * Prints the header of the output table
	 */
	private void printTableHeader() {
		out.println("Here are the results:");
		out
				.printf(
						" %3s| %-21s|%10s |%5s |%6s |%6s |%6s |%6s |%8s |%6s |%6s |%6s |%8s |%8s |%6s\n",
						"No", "Name", "Birthday", "Code", "100", "LJ", "SP",
						"HJ", "400", "110H", "DT", "PV", "JT", "1500m", "Score");
		out.println("----------------------------------------------------"
				+ "-----------------------------------------------------"
				+ "---------------------------------");
	}

	@Override
	public String getParameters() {
		return parameters;
	}

}
