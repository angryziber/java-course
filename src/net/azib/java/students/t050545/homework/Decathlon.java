package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.writers.AthleteWriter;
import net.azib.java.students.t050545.homework.loaders.AthleteLoader;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Sportman;


/**
 * Decathlon organise data processing from/to user
 * 
 * @author libricon
 */
public class Decathlon {
	
	public static void main(String[] args) throws Exception {

		
		PluginLoader plug = new PluginLoader(args); 
		AthleteLoader loader = plug.getLoader();
		System.out.println(loader.getArgum()+"  "+loader.getDescription());
		AthleteWriter writer = plug.getWriter();
		System.out.println(writer.getArgum()+"  "+writer.getDescription());
		Competition comp = null;
		Sportman sportman = null;
		
		try {
			while ((sportman = loader.nextSportman()) != null) {
				comp.addCompetitor(sportman);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		writer.printResultTable(comp);
		writer.close();
		System.out.println("END");
		System.exit(0);

	}
}
