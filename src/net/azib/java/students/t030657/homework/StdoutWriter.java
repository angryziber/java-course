package net.azib.java.students.t030657.homework;

import java.io.PrintStream;

/**
 * @author Karina
 * public class StdoutWriter
 * The class implements output of the entered athlete
 *
 */

public class StdoutWriter implements Writer {

	private boolean headersDone;
	
	public StdoutWriter() {}
	
	public void write(Results r) {
		StringBuilder sb = new StringBuilder(132);
		if (!headersDone) {
			headersDone=true;
			sb.append(" nr   score name            country   birthday");
			for (Event ev: Event.values()) {
				sb.append(String.format(" %9.9s", ev.name()));
			}
			System.out.println(sb.toString());
		}
		sb.setLength(0);
		sb.append( String.format("%3s. %6d %-16s%7.7s %10.10s", 
			r.getPosition(),r.getScore(),r.getAthlete().getName(),
			r.getAthlete().getCountryCode(),r.getAthlete().getDob()));
		for (Event ev: Event.values()) {
			sb.append(String.format("%10.2f", r.getResult(ev)));
		}
		System.out.println(sb.toString());
	}
	
	public void close() {
	}
}
