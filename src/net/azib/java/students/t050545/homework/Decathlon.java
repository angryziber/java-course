package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;


/**
 * Decathlon
 * 
 * @author libricon
 */
public class Decathlon {
	public static void main(String[] args) throws ParseException, IOException {

		BufferedReader reader = null;
		PrintWriter printwriter = null;
		
        try{
		int i = 0;
		if (args[i].equalsIgnoreCase("-csv")) {
			reader = new BufferedReader(new FileReader(args[i + 1]));
			i = i + 2;
		}
		else if (args[i].equalsIgnoreCase("-db")) {
			// TODO
			i = i + 2;
		}
		else if (args[i].equalsIgnoreCase("-console")){
			reader = new BufferedReader(new InputStreamReader(System.in));
			i++;
		}
		else {
			System.err.println("Check input arguments");
			System.exit(1);
		}

		if (args[i].equalsIgnoreCase("-csv")) {
			printwriter = new PrintWriter(args[i + 1]);
		}
		else if (args[i] == "-xml") {
			// TODO
		}
		else if (args[i] == "-html") {
			// TODO
		}
		else if (args[i].equalsIgnoreCase("-console")) {
			printwriter = new PrintWriter(System.out);
			i++;
		}
		else {
			System.err.println("Check output arguments");
			System.exit(1);
		}
        }catch (ArrayIndexOutOfBoundsException e){
        	System.err.println("The arguments order is wrong!");
        	System.exit(1);
        }catch (Exception e){
        	System.err.println("The arguments order is wrong or missing!");
        	System.exit(1);
        }
        String line;
        Competition comp = new Competition("Mega cup", 100011);
        
		while ((line = reader.readLine()) != null && line.length() !=0) {
			Sportman sportman = Parser.splitLine(line);
			comp.addCompetitor(sportman);
			//printwriter.println(comp);
		}
        comp.sortCompetitors();
		printwriter.println(comp);
		
		printwriter.close();
		reader.close();
		System.out.println("END");
	}
}
