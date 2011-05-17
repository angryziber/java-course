package net.azib.java.students.t110013.homework.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Vadim
 */
public class Athlete implements Comparable<Athlete> {
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = (SimpleDateFormat) DateFormat.getDateInstance();

    private String name;
    private Date dateOfBirth;
    private String country;
    private int totalScore;
    private String place;
    private List<Double> performanceResults = new ArrayList<Double>();

    public int compareTo(Athlete o) {
        return ((Integer) totalScore).compareTo(o.totalScore);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Athlete))
            return false;
        return totalScore == ((Athlete) o).totalScore;
    }

    @Override
    public int hashCode() {
        return totalScore;
    }

    public void setName(String name)             {this.name = name;}
    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}
    public void setCountry(String country)       {this.country = country;}
    public void setTotalScore(int totalScore)    {this.totalScore = totalScore;}
    public void setPlace(String place)           {this.place = place;}

    public void setPerformanceResult(double result)            {this.performanceResults.add(result);}
    public void setPerformanceResult(int index, double result) {this.performanceResults.add(index, result);}

    public String getName()        {return name;}
    public String getDateOfBirth() {return DEFAULT_DATE_FORMAT.format(dateOfBirth);}
    public String getCountry()     {return country;}
    public int    getTotalScore()  {return totalScore;}
    public String getPlace()       {return place;}

    public Double getPerformanceResult(int index) {return performanceResults.get(index);}
}
