package net.azib.java.students.t103784.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PlaceCalculator {
	static int lastAssigned = 0;
    static int currentFirst = 0;
    static int counter = 1;
	static List<Integer> scores = new ArrayList<Integer>();

	public static void calculatePlace(List<Athlete> contestants) {
		Collections.sort(contestants, new PlaceCalculator.sortByScore());
		int o = 0;
		for (Athlete athlete : contestants) {
			scores.add(o, contestants.get(o).getScore());
			o++;
		}
		scores.add(-1);
		for(int i=1;i< scores.size();i++) {
            if(scores.get(i).equals(scores.get(i - 1))) {
                counter++;
            }
            else {
                if(counter == 1) {
                    contestants.get(currentFirst).setPlace(String.valueOf(lastAssigned+1));
                    lastAssigned++;
                    currentFirst++;
                }
                else {
                    String temp = String.valueOf(lastAssigned+1) + " - " +
                                    String.valueOf(lastAssigned+counter);
                    for(int a=lastAssigned;a<counter+lastAssigned;a++) {
                        contestants.get(currentFirst).setPlace(temp);
                        currentFirst++;
                    }
                }
                lastAssigned =+ currentFirst;
                counter = 1;
            }
        }
	}

	private static class sortByScore implements Comparator<Athlete> {
   		@Override
		public int compare(Athlete o1, Athlete o2) {
			   if (o1.getScore() == o2.getScore()) {
			   }
			   return o2.getScore() - o1.getScore();
		}
	}
}
