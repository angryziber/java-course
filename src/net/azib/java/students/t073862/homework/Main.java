package net.azib.java.students.t073862.homework;

import net.azib.java.students.t073862.homework.model.InputManager;
import net.azib.java.students.t073862.homework.model.OutputManager;
import net.azib.java.students.t073862.homework.model.Score;
import net.azib.java.students.t073862.homework.util.Util;

import java.io.File;
import java.util.Arrays;


/**
 * Main
 *
 * @author Pets
 */

public class Main {
	/**
	 * Backbone of the program. Manages input and output.
	 * @param args
	 */
	public void parseInput(String[] args) {
		
		if(args.length < 2) {
			System.out.println("Invalid arguments");
			System.exit(1);
		}
		int pointer = 0;
		Score[] scores = null;
		InputManager inputManager = new InputManager();
		String input = args[pointer++];
		if(input.equalsIgnoreCase("-console")) {
			scores = inputManager.loadInputFromConsole();
		}
		else if(input.equalsIgnoreCase("-db")) {
			scores = inputManager.loadInputFromDatabase(args[pointer++]);
		}
		else if(input.equalsIgnoreCase("-csv")) {
			scores = inputManager.loadInputFromCSV(new File(args[pointer++]));
		}
		else {
			System.out.println("Invalid arguments");
			System.exit(1);
		}
		Arrays.sort(scores);
		OutputManager outputManager = new OutputManager();
		String output = args[pointer++];
		if(output.equalsIgnoreCase("-console")) {
			outputManager.toConsole(scores);
		}
		else if(output.equalsIgnoreCase("-xml")) {
			File f = Util.getOutputFile(args[pointer++]);
			outputManager.toXML(scores, f);
		}
		else if(output.equalsIgnoreCase("-csv")) {
			File f = Util.getOutputFile(args[pointer++]);
			outputManager.toCSV(scores, f);
		}
		else if(output.equalsIgnoreCase("-html")) {
			File f = Util.getOutputFile(args[pointer++]);
			outputManager.toHTML(scores, f);
		}
		else {
			System.out.println("Invalid arguments");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		new Main().parseInput(args);
	}
}
