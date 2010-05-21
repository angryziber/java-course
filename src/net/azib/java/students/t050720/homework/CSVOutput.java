package net.azib.java.students.t050720.homework;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * CSVOutput
 *
 * @author Marek
 */
public class CSVOutput implements Output {

	File f;
	/**
	 * @param parameters
	 */
	public CSVOutput(String filename) {
		f = new File(filename);
	}

	@Override
	public void flush(ArrayList<Record> records) throws Exception {
		
		PrintWriter writer=new PrintWriter(f);
		
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
