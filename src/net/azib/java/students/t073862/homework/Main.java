package net.azib.java.students.t073862.homework;

import net.azib.java.students.t073862.homework.model.InputManager;
import net.azib.java.students.t073862.homework.model.Score;
import net.azib.java.students.t073862.homework.util.Util;

import java.io.File;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;


/**
 * Main
 *
 * @author Pets
 */

public class Main {
	public Main() {
		
	}
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
		
		String output = args[pointer++];
		if(output.equalsIgnoreCase("-console")) {
			for(Score s : scores) {
				System.out.println(s);
			}
		}
		else if(output.equalsIgnoreCase("-xml")) {
			File f = Util.getOutputFile(args[pointer++]);
			
			StringTemplateGroup group = new StringTemplateGroup("Group Name",Main.class.getResource("").getFile().replace("%20", " "));
			StringTemplate tmp = group.getInstanceOf("XML");
			tmp.setAttribute("scores", scores);
			Util.writeToFile(f,tmp.toString());
		}
		else if(output.equalsIgnoreCase("-csv")) {
			File f = Util.getOutputFile(args[pointer++]);
				
			StringTemplateGroup group = new StringTemplateGroup("Group Name",Main.class.getResource("").getFile().replace("%20", " "));
			StringTemplate tmp = group.getInstanceOf("CSV");
			tmp.setAttribute("scores", scores);
			Util.writeToFile(f,tmp.toString());
		}
		
	}
	
	public static void main(String[] args) {
		new Main().parseInput(args);
	}
}
