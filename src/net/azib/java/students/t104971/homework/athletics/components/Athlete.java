package net.azib.java.students.t104971.homework.athletics.components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static net.azib.java.students.t104971.homework.athletics.util.InputParser.formatDate;

/**
 * @author Jaroslav Judin
 */
public class Athlete implements Comparable {
    private Integer id;
    private String name;
    private Date dateBirth;
    private String country;
    private List<Result> results = new ArrayList<Result>();
    private int totalScore;

    public Athlete() {
    }

    public int compareTo(Object o) {
        if (!(o instanceof Athlete)) {
            return 0;
        }
        return ((Athlete) o).getTotalScore() - getTotalScore();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public List<Result> getResults() {
        return results;
    }

    public void addResult(ResultType resultType, double result) {
        results.add(new Result(resultType, result));
    }

    @Override
    public String toString() {
        StringBuilder resultsString = new StringBuilder();
        for (Result result : getResults()) {
            resultsString.append("\n\t\t" + result);
        }
        return "Athlete{" +
                "totalScore=" + totalScore +
                ", name= " + name +
                ", country= " + country +
                ", dateBirth=" + formatDate(dateBirth) +
                '}' + resultsString.toString();
    }
}
