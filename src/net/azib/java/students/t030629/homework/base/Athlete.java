package net.azib.java.students.t030629.homework.base;

import java.util.Date;
import java.util.Locale;

/**
 * Base class representing both the athlete's personal data and its results
 * obtained in the competition.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 11.05.2008
 * <br>Time: 17:44:53
 */
public class Athlete {

    private String name;
    private Date birthday;
    private Locale locale;
    private Results results;


    /**
     * Full constructor, used by {@link net.azib.java.students.t030629.homework.base.utils.AthleteBuilder}
     * @param name name of the athlete
     * @param birthday athlete's date of birth
     * @param locale instance of {@link java.util.Locale} representing athlete's country of origin
     * @param results results of the athlete
     */
    public Athlete(String name, Date birthday, Locale locale, Results results) {
        this.name = name;
        this.birthday = birthday;
        this.locale = locale;
        this.results = results;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the date of birth
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @return the locale corresponding to the country of origin
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @return the results
     */
    public Results getResults() {
        return results;
    }

}
