package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;


import java.io.PrintWriter;
import java.util.Arrays;



/**
 * Decathlon
 * 
 * @author libricon
 */
public class Decathlon {
	/**
	 * @param args command line arguments
	 * @throws Exception anykind of exeption
	 */
	public static void main(String[] args) throws Exception {

		SportmanLoader loader = new CSVLoader("c:\\sport_utf8.txt");
		PrintWriter printwriter = null;
		System.out.println(Arrays.deepToString(args));
		
        try{
		int i = 0;
		if (args[i].equalsIgnoreCase("-csv")) {
			loader = new CSVLoader(args[i+1]);
			i = i + 2;
		}
		else if (args[i].equalsIgnoreCase("-db")) {
			// TODO
			i = i + 2;
		}
		else if (args[i].equalsIgnoreCase("-console")){
			loader = new ConsoleLoader();
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
        
        Competition comp = new Competition("Mega cup", 100011);
        Sportman sportman;
        while((sportman = loader.nextSportman()) != null){
        	comp.addCompetitor(sportman);
        	System.out.println(comp);
        }
        comp.sortCompetitors();
        printwriter.println(comp);
        
		
		
		printwriter.close();
		System.out.println("END");
		System.exit(0);
		
	}
}
