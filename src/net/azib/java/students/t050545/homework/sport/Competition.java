package net.azib.java.students.t050545.homework.sport;

import net.azib.java.students.t050545.homework.loaders.CSVLoader;
import net.azib.java.students.t050545.homework.utils.AthleteLoader;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Competition class organise competition, it takes all sportmen and sort them,
 * give places For work it's needed to call method <code>getPlaces()</code> to end
 * competition and put places
 * 
 * @author libricon
 */
public class Competition {
	/** Initialise competition with name and uniq ID
	 * @param name competition name
	 * @param id competition ID
	 */
	public Competition(String name, int id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * Standard constructor without parameters competition name is "competition"
	 * competition ID is "1"
	 */
	public Competition() {
		this("Competition", 1);
	}

	/**
	 * This method add new sportman to competition
	 * 
	 * @param sportman
	 * @return true, if successfully
	 */
	public boolean addCompetitor(AthleteScore sportman) {
		return competitors.add(sportman);
	}

	/**
	 * Method aim to sort sportmen and then put places for each of them
	 * After return all place
	 * @return all sportmans with places as <code>Places</code> type
	 */
	public Places[] getPlaces() {
		Collections.sort(competitors);
		tableScore = new Places[competitors.size()];                           // new table initialise

		for (int i = 0; i < competitors.size(); i++) {                       // from the first to the last sportman
			int j;

			int score = competitors.get(i).getPoints().getScore();        // current score 

			for (j = i + 1; j < competitors.size(); j++) {              // from next(i+1) sportman to last 
				if (competitors.get(j).getPoints().getScore() != score) {
					break;                        // if current score not equal to j's sportman's score, break
				}
			}

			String place;
			if (i != (j - 1)) {                  // If there is more than 1 sportman with the same score
				place = (i+1) + "-" + j;
			}
			else {
				place = String.valueOf(i+1);
			}

			for (int e = i; e <= j - 1; e++) {             // write to each table row place and sportman
				tableScore[e] = new Places(place, competitors.get(e));
			}
			i = j - 1;        // as we finished on j sportman, i = j

		}
		return tableScore;
	}

	/**
	 * Return string will all places and sportman's
	 * @return <code>places.toString()</code>
	 */
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();  // String|Builder give a small advantage compare to string concat.
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

	
	/** array of sportman's with places */
	private Places[] tableScore;
	/** ArrayList for storing sportman's */
	private ArrayList<AthleteScore> competitors = new ArrayList<AthleteScore>();
	/** Competition name */
	private String name;
	/** Competition ID, like date */
	private int id;

	

}
