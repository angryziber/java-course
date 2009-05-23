package net.azib.java.students.t050545.homework.sport;


import net.azib.java.students.t050545.homework.loaders.CSVLoader;
import net.azib.java.students.t050545.homework.loaders.SportmanLoader;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Competition class organise competition, it takes all sportmen and sort them,
 * give places For work it's needed to call method sortPlaces() to end
 * competition and put places
 * 
 * @author libricon
 */
public class Competition {
	/**
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
	public boolean addCompetitor(Sportman sportman) {
		return competitors.add(sportman);
	}

	/**
	 * Method aim to sort sportmen and then put places for each of them.
	 */
	public void sortPlaces() {
		Collections.sort(competitors);
		tableScore = new Places[competitors.size()];

		for (int i = 0; i < competitors.size(); i++) {
			int j;

			int score = competitors.get(i).getPoints().getScore();

			for (j = i + 1; j < competitors.size(); j++) {
				if (competitors.get(j).getPoints().getScore() != score) {
					break;
				}
			}

			String place;
			if (i != (j - 1)) {
				place = "[" + (i+1) + "-" + j + "]";
			}
			else {
				place = "[" + (i+1) + "]";
			}

			for (int e = i; e <= j - 1; e++) {
				tableScore[e] = new Places(place, competitors.get(i));
			}
			i = j - 1;

		}

	}

	/**
	 * Return string will all places and sportman's
	 * 
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

	
	/** array of sportman's with places */
	private Places[] tableScore;
	/** ArrayList for storing sportman's */
	private ArrayList<Sportman> competitors = new ArrayList<Sportman>();
	/** Competition name */
	private String name;
	/** Competition ID, like date */
	private int id;

	/**
	 * Main function
	 * 
	 * @param args
	 *            command line arguments
	 * @throws Exception
	 *             all kind of exeption's
	 */
	public static void main(String[] args){
		try {
			Competition comp = new Competition("MEGA CUP ", 010101);
			SportmanLoader loader = new CSVLoader("c:\\sport_utf8.txt");
			Sportman sportman;

			while ((sportman = loader.nextSportman()) != null) {
				comp.addCompetitor(sportman);
			}

			comp.sortPlaces();
			System.out.println(comp);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

}
