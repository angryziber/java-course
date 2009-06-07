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
		Sportman sportman = null;
		AthleteLoader loader = null;
		AthleteWriter writer = null;
		
		try{
			if((loader = plug.getLoader()) == null){
				throw new NullPointerException();
			}
			if((writer = plug.getWriter()) == null){
				throw new NullPointerException();
			}
		} catch ( LoadException e){
			e.printStackTrace();
			System.exit(-1);
		} catch (NullPointerException e){
			System.exit(-2);
		}
		
		Competition comp = new Competition();
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
