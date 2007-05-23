package net.azib.java.students.t030657.homework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Karina
 * public class StdinReader
 * The class inmplements getting Reader (or new athlete) data, if inserted
 * In case not permitted situation the relevant exception is thrown
 *
 */

public class StdinReader implements Reader {
	
	private BufferedReader in;
	
	public StdinReader() {
	}
	
	public List<Results> readAll() {
		ArrayList<Results> results = new ArrayList<Results>();
		in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String name = getLine("name (or ENTER to finish)");
			name = name.trim();
			if ("".equals(name))
				break;
			Results r = new Results( new Athlete(
				name,
				getLine("birthday"),
				getLine("country_code")
			));
			results.add(r);
			for (Event ev: Event.values()) {
				r.setResult(ev, getDouble(ev.name()));
			}
		}
		return results;
	}

	private String getLine(String prompt){
		try{
			System.out.print(prompt);
			System.out.print(": ");
			System.out.flush();
			String inline = in.readLine();
			return inline.trim();
		}
		catch (Exception e){
			throw new IllegalArgumentException(e);
		}
	}

	private double getDouble(String prompt){
		try{
			String inline = getLine(prompt);
			return Double.parseDouble(inline);
		}
		catch (Exception e){
			throw new IllegalArgumentException(e);
		}
	}
}
