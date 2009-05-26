package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.loaders.CSVLoader;
import net.azib.java.students.t050545.homework.loaders.ConsoleLoader;
import net.azib.java.students.t050545.homework.loaders.DBLoader;
import net.azib.java.students.t050545.homework.loaders.SportmanLoader;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Sportman;
import net.azib.java.students.t050545.homework.writer.CSVWriter;
import net.azib.java.students.t050545.homework.writer.ConsoleWriter;
import net.azib.java.students.t050545.homework.writer.SportmanWriter;


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

		SportmanLoader loader = null;
		SportmanWriter writer = null;
		System.out.println(Arrays.deepToString(args));
		
        try{
		int i = 0;
		if (args[i].equalsIgnoreCase("-csv")) {
			loader = new CSVLoader(args[i+1]);
			i = i + 2;
		}
		else if (args[i].equalsIgnoreCase("-db")) {
			loader = new DBLoader();
			i = i + 1;
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
			writer = new CSVWriter(args[i + 1]);
		}
		else if (args[i] == "-xml") {
			// TODO
		}
		else if (args[i] == "-html") {
			// TODO
		}
		else if (args[i].equalsIgnoreCase("-console")) {
			writer = new ConsoleWriter();
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
        try{
        Competition comp = new Competition("Mega cup", 100011);
        Sportman sportman;
        while((sportman = loader.nextSportman()) != null){
        	
        	comp.addCompetitor(sportman);
        	
        }
        
        writer.printResultTable(comp.getPlaces());
        }catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println("END");
		System.exit(0);
		
	}
}
