package net.azib.java.students.t050545.homework.sport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class organise athletes in competition, to end competition call
 * <code>getPlaces()</code>
 * 
 * @author libricon
 */
public class Competition {

	/** array of sportman's with places */
	private Places[] tableScore;
	private List<AthleteScore> competitors = new ArrayList<AthleteScore>();
	private String name;
	private int id;

	/**
	 * @param name
	 *            competitions
	 * @param id
	 *            competition ID
	 */
	public Competition(String name, int id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * name is "competition" ID is "1"
	 */
	public Competition() {
		this("Competition", 1);
	}

	/**
	 * add athlete
	 * @param athlete
	 * @return true, if successfully
	 */
	public boolean addCompetitor(AthleteScore sportsman) {
		return competitors.add(sportsman);
	}

	/**
	 * sort athletes, gives places and return collection of places
	 * @return place+athlete
	 */
	public Places[] getPlaces() {
		Collections.sort(competitors);
		tableScore = new Places[competitors.size()]; // new table initialise

		for (int i = 0; i < competitors.size(); i++) { // from the first to the
														// last sportman
			int j;

			int score = competitors.get(i).getPoints().getScore(); // current
																	// score

			for (j = i + 1; j < competitors.size(); j++) { // from next(i+1)
															// sportman to last
				if (competitors.get(j).getPoints().getScore() != score) {
					break; // if current score not equal to j's sportman's
							// score, break
				}
			}

			String place;
			if (i != (j - 1)) { // If there is more than 1 sportman with the
								// same score
				place = (i + 1) + "-" + j;
			}
			else {
				place = String.valueOf(i + 1);
			}

			for (int e = i; e <= j - 1; e++) { // write to each table row place
												// and sportman
				tableScore[e] = new Places(place, competitors.get(e));
			}
			i = j - 1; // as we finished on j sportman, i = j

		}
		return tableScore;
	}

	/**
	 * @return <code>places.toString()</code>
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder(); 
		for (Places pl : tableScore) {
			str.append(pl);
		}
		return str.toString();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
