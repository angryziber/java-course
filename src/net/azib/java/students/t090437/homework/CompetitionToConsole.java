package net.azib.java.students.t090437.homework;

import java.util.SortedSet;

/**
 * CompetitionToConsole
 *
 * @author Ronald
 */
public class CompetitionToConsole implements CompetitionResultsProducer {
	SortedSet<Competitor> competitors;
	
	@Override
	public void produceResults() {
		for(Competitor competitor : competitors) {
			System.out.println("Position " + competitor.getPosition());
			System.out.printf("%-20s \t %-20s\n", "Points", Integer.toString(competitor.getScore()));			
			System.out.println("");
			
			System.out.printf("%-20s \t %-20s\n", "Competitor name", competitor.getName());
			System.out.printf("%-20s \t %-20s\n", "Competitor country", competitor.getCountry());
			System.out.printf("%-20s \t %-20s\n", "Competitor birthday", competitor.getBirthday().toString());
			System.out.println("");
			
			System.out.printf("%-20s \t %-20s\n", "Sprint 100m", competitor.getSprint_100m_s().toString());
			System.out.printf("%-20s \t %-20s\n", "Long jump", competitor.getLong_jump_m().toString());
			System.out.printf("%-20s \t %-20s\n", "Shot put", competitor.getShot_put_m().toString());
			System.out.printf("%-20s \t %-20s\n", "High jump", competitor.getHigh_jump_m().toString());
			System.out.printf("%-20s \t %-20s\n", "Sprint 400m", competitor.getSprint_400m_m_s().toString());
			System.out.printf("%-20s \t %-20s\n", "Hurdles 110m", competitor.getHurdles_s().toString());
			System.out.printf("%-20s \t %-20s\n", "Discus throw", competitor.getDiscus().toString());
			System.out.printf("%-20s \t %-20s\n", "Pole vault", competitor.getPole_vault().toString());
			System.out.printf("%-20s \t %-20s\n", "Javelin throw", competitor.getJavelin_throw().toString());
			System.out.printf("%-20s \t %-20s\n", "Race 1500m", competitor.getRace_1500m_m_s().toString());
			
			System.out.println("");
			System.out.println("");
			System.out.println("");
		}
	}

	@Override
	public void setCompetitionResults(SortedSet<Competitor> competitors) {
		this.competitors = competitors;
	}

}
