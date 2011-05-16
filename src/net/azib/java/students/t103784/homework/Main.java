package net.azib.java.students.t103784.homework;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Ott Madis Ozolit
 * Date: 14.05.11
 * Time: 15:45
 * To change this template use File | Settings | File Templates.
 */
public class Main {


	public static void main(String[] args) {
		InputStream inputType = System.in;
		Scanner scanner = new Scanner(inputType);
		Athlete athlete = new Athlete();
		Input input = new Input(athlete, scanner);
		input.scanAthlete(athlete, scanner);
		ScoreCalculator calc = new ScoreCalculator(athlete);
		System.out.println("\n Teh score be: " + athlete.score + "\n");


	}

}
