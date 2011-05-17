package net.azib.java.students.t103784.homework;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 14.05.11
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {

	//List<Athlete> contestants = new ArrayList<Athlete>();


	public static void main(String[] args) throws IOException {




		InputStream inputType = System.in;
		boolean inputtingAthletes = true;
		Athlete athlete;
		Input input;
		Scanner scanner = new Scanner(inputType);
		String filename = "J:\\Projects\\src\\net\\azib\\java\\students\\t103784\\homework\\sample.csv";
		int junn = 0;
		BufferedReader reader = null;

		input = new Input();
		while (inputtingAthletes) {


			if (junn == 0) {
				reader = new BufferedReader(new InputStreamReader(System.in));
			} else {
				reader = new BufferedReader(new FileReader(filename));
			}
			//scanner.useDelimiter(scanner.nextLine());
			athlete = new Athlete();
			input.scanAthlete(athlete, reader);
			input.addAthlete(athlete);
			System.out.print("Add athletes? ");
			new ScoreCalculator(athlete);
			System.out.println("\n Teh score be: " + athlete.score + "\n");
			inputtingAthletes = scanner.nextLine().toLowerCase().startsWith("y");


		}

		for (int i = 0; i < input.contestants.size(); i++) {
			athlete = input.contestants.get(i);
			System.out.println("\nFinal: " + Arrays.toString(athlete.performance));
        }

	}



}
