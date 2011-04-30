package net.azib.java.students.t073756.homework;

import java.util.LinkedHashMap;
import java.util.Map;

public class Result {
    private Map<DecathlonEvent, String> results = new LinkedHashMap<DecathlonEvent, String>();
    private int overallResult;
    private Place place;

    public Map<DecathlonEvent, String> getResults() {
        return results;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public int getOverallResult() {
        return overallResult;
    }

    public void setOverallResult(int overallResult) {
        this.overallResult = overallResult;
    }
}
