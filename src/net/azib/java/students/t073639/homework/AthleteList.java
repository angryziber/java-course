package net.azib.java.students.t073639.homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <p>
 * Instance of AtheteList class represents list of {@link Athlete}.
 * @author t073639
 * @see {@link List}
 */
public class AthleteList {
	private List<Athlete> inputAthleteList;

	/**
	 * Get list of Athletes.
	 * 
	 * @return Sorted list of Athletes.
	 */
	public List<Athlete> getInputAthleteList() {
		this.sortAndSetPlaces();
		return inputAthleteList;
	}

	/**
	 * <p>
	 * Create a new empty list of athletes.
	 */
	public AthleteList() {
		this.inputAthleteList = new ArrayList<Athlete>();
	}

	/**
	 * <p>
	 * Create a new list of athletes, which is copy of parameter.
	 * 
	 * @param inputAthleteList
	 *            - List of athletes
	 */
	public AthleteList(List<Athlete> inputAthleteList) {
		this.inputAthleteList = inputAthleteList;
	}

	/**
	 * <p>
	 * Add new athlete to list using {@link Athlete} constructor with string
	 * parameter.
	 * 
	 * @param string
	 *            - string, which contains name, birthday, country and ten
	 *            results of decathlon separated by comma.
	 */
	public void addNewAthlete(String string) {
		this.inputAthleteList.add(new Athlete(string));
	}

	/**
	 * <p>
	 * Method sort list and set places to each athlete of this list.
	 */
	public void sortAndSetPlaces() {
		List<Integer> list = new ArrayList<Integer>();
		int index = 0;
		while (index < inputAthleteList.size()) {
			list.add(inputAthleteList.get(index).getTotalPoints());
			index++;
		}
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.addAll(list);
		List<Integer> listWithoutDuplicates = new ArrayList<Integer>(treeSet.descendingSet());

		int i = 0;
		int place = 1;
		while (i < listWithoutDuplicates.size()) {
			int duplicate = 0;
			int j = 0;
			while (j < list.size()) {
				if (listWithoutDuplicates.get(i).compareTo(list.get(j)) == 0)
					duplicate++;
				j++;
			}
			if (duplicate == 1) {
				map.put(listWithoutDuplicates.get(i), String.valueOf(place));
			}
			else {
				map.put(listWithoutDuplicates.get(i), place + "-" + (place + duplicate - 1));
				place = place + duplicate - 1;
			}
			i++;
			place++;
		}
		map = new TreeMap<Integer, String>(map.descendingMap());
		List<Athlete> newList = new ArrayList<Athlete>();
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			int k = 0;
			int next = it.next();
			while (k < inputAthleteList.size()) {
				if (next == inputAthleteList.get(k).getTotalPoints()) {
					inputAthleteList.get(k).setPlace(map.get(next));
					newList.add(inputAthleteList.get(k));
				}
				k++;
			}
		}
		inputAthleteList.clear();
		inputAthleteList.addAll(newList);
	}
}
