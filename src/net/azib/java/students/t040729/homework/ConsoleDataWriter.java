package net.azib.java.students.t040729.homework;

import java.util.List;
import java.util.Properties;

/**
 * Console output implementation. Outputs competition data to console.
 *
 * @author ValleTon
 */
public class ConsoleDataWriter implements CompetitionDataOut {
	Properties properties;
	@Override
	public void putCompetitionData(List<Athlete> a) throws Exception {
		
		System.out.println("Competition results");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println(String.format("%4s %5s %-15s %-8s %2s %7s %5s %5s %5s %7s %7s %5s %5s %5s %7s", "#", "Pts", "Name", "Brthdate", "", "Evt1", "Evt2", "Evt3", "Evt4", "Evt5", "Evt6", "Evt7", "Evt8", "Evt9", "Evt10"));
		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		String fmtString;
		
		for (Athlete tmp : a){
			System.out.print(String.format("%4s %5d %-15s %8s %2s", tmp.getPlace(), tmp.getTotalPoints(), tmp.getName(), tmp.getCustomBirthDate(properties.getProperty("dateformat_console_short")), tmp.getCountryCode()));
			for (Event e : Event.values()){
				if (e.isTrackEvent()){
					fmtString = " %7s";
				}else{
					fmtString = " %5s";
				}
				System.out.print(String.format(fmtString, tmp.getFormattedResult((byte) e.ordinal())));
			}
			System.out.println();
		}
	}

	@Override
	public void setAppProperties(Properties properties) {
		this.properties = properties;
	}
}
