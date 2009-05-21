package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Competition
 * 
 * @author libricon
 */
public class Competition {
	public Competition(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public boolean addCompetitor(Sportman sportman) {
		return competitors.add(sportman);
	}

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
				place = "[" + i + "-" + (j - 1) + "]";
			}
			else {
				place = "[" + i + "]";
			}

			for (int e = i; e <= j - 1; e++) {
				tableScore[e] = new Places(place, competitors.get(i));
			}
			i = j - 1;

		}

	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Places pl : tableScore) {
			str.append(pl);
		}
		return str.toString();
		//return Arrays.deepToString(tableScore);
		// return competitors.toString();
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

	private class Places {
		public Places(String place, Sportman sportman) {
			placeNum = place;
			this.sportman = sportman;
		}

		@Override
		public String toString() {
			return placeNum + "\n" + sportman;
		}

		String placeNum;
		Sportman sportman;

	}

	private Places[] tableScore;
	private ArrayList<Sportman> competitors = new ArrayList<Sportman>();
	private String name;
	private int id;

	public static void main(String[] args) throws Exception {
		Competition comp = new Competition("MEGA CUP ", 010101);
		SportmanLoader loader = new CSVLoader("c:\\sport_utf8.txt");
		Sportman sportman;

		while ((sportman = loader.nextSportman()) != null) {
			comp.addCompetitor(sportman);
			// System.out.println(sportman);
		}

		comp.sortPlaces();
		System.out.println(comp);
		System.exit(0);
	}

}
