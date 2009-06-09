package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.PluginLoader;
import net.azib.java.students.t050545.homework.utils.ReadException;
import net.azib.java.students.t050545.homework.utils.WriteException;
import net.azib.java.students.t050545.homework.writers.AthleteWriter;
import net.azib.java.students.t050545.homework.loaders.AthleteLoader;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.AthleteScore;

import java.text.ParseException;

/**
 * Decathlon organise data processing from/to user
 * 
 * @author libricon
 */
public class Decathlon {

	public static void main(String[] args) {

		AthleteLoader loader = null;
		AthleteWriter writer = null;
		try {
			try {
				PluginLoader plug = new PluginLoader(args);

				if ((loader = plug.getLoader()) == null) {
					throw new NullPointerException();
				}
				if ((writer = plug.getWriter()) == null) {
					throw new NullPointerException();
				}
			}
			catch (LoadException e) {
				e.printStackTrace();
				System.exit(-1);
			}
			catch (NullPointerException e) {
				System.exit(-2);
			}

			Competition comp = new Competition();
			AthleteScore sportman = null;
			try {
				while ((sportman = loader.nextAthleteScore()) != null) {
					comp.addCompetitor(sportman);
				}
				writer.printResultTable(comp);
			}
			catch (WriteException e) {
				System.err.println("Program can't continue normal work, it will be closed");
				System.exit(-3);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
			catch (ReadException e) {
				e.printStackTrace();
			}
			
		}
		finally {
			loader.close();
			writer.close();
		}
		System.out.println("END");
		System.exit(0);

	}
}
