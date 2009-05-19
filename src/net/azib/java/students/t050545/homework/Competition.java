package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;

import java.util.ArrayList;
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

	public void sortCompetitors() {
		Collections.sort(competitors);
	}

	@Override
	public String toString() {
		return competitors.toString();
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

		String placeNum;
		Sportman sportman;

	}

	private Places[] tableScore;
	private ArrayList<Sportman> competitors = new ArrayList<Sportman>();
	private String name;
	private int id;

}