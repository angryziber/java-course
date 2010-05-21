package net.azib.java.students.t050720.homework;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * ConsoleOutput
 *
 * @author Marek
 */
public class ConsoleOutput implements Output {

	@Override
	public void flush(ArrayList<Record> records) {
		
		PrintWriter writer=new PrintWriter(System.out, true);
		
		writer.println("Position, Score, Athlete, Birthdate, Country, 100 m, Long Jump, Shot Put, High Jump, 400m, 110m Hurdles, Discus, Pole Vault, Javelin, 1500m");
		
		Iterator<Record> iterator=records.iterator();
		
		int position=1;
		while (iterator.hasNext())
		{
			Record current = iterator.next();
			writer.println(position + "," 
					+ current.getScore() + ",\"" 
					+ current.getAthlete() + "\"," 
					+ current.getBirthDate() + ","
					+ current.getCountry() + ","
					+ current.getRace_100m() + ","
					+ current.getLong_jump() + ","
					+ current.getShot_put() + ","
					+ current.getHigh_jump() + ","
					+ current.getRace_400m() + ","
					+ current.getHurdles_110m() + ","
					+ current.getDiscus_throw() + ","
					+ current.getPole_vault() + ","
					+ current.getJavelin_throw() + ","
					+ current.getRace_1500m());
			position++;
		}
	}

}
