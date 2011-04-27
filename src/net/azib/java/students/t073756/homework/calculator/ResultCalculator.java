package net.azib.java.students.t073756.homework.calculator;

import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.beans.Athlete;
import net.azib.java.students.t073756.homework.beans.Place;
import net.azib.java.students.t073756.homework.beans.Result;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {

    private List<Athlete> athletes;

    public ResultCalculator(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    /**
     *  Performs main actions to calculate athletes results and places, sorts by score descending
     */
    public void calculate() {
        calculateResult();
        dividePlaces();
    }

    void calculateResult() {
        for (Athlete a : athletes) {
            Result r = a.getResult();
            int total = 0;

            r.getResults();
            for (Map.Entry<DecathlonEvent, String> e : r.getResults().entrySet()) {
                total += e.getKey().calculateScore(e.getValue());
            }
            r.setOverallResult(total);
        }
    }

    private void dividePlaces() {
        reverseSortByScore();

        Map<Integer, Place> placesMap = new HashMap<Integer, Place>();

        int currentPosition = 0;

        for (Athlete a : athletes) {
            int result = a.getResult().getOverallResult();
            Place place = placesMap.get(result);
            if (place != null) {
                place.incrementEnd();
            } else {
                placesMap.put(result, new Place(++currentPosition));
            }
        }

        setPlaces(placesMap);
    }

    private void setPlaces(Map<Integer, Place> placesMap) {
        for (Athlete a : athletes) {
            Result result = a.getResult();
            result.setPlace(placesMap.get(result.getOverallResult()));
        }
    }

    private void reverseSortByScore() {
        Collections.sort(athletes, Collections.<Athlete>reverseOrder());
    }
}
