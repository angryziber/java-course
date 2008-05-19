package net.azib.java.students.t030629.homework.base.utils;

import net.azib.java.students.t030629.homework.base.Results;
import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.base.Result;
import net.azib.java.students.t030629.homework.base.Athlete;

import java.util.Date;
import java.util.Locale;
import java.math.BigDecimal;

/**
 * Class builds instances of {@link net.azib.java.students.t030629.homework.base.Athlete} class
 * according to the Builder design pattern.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 2:20:33
 */
public class AthleteBuilder {
    private static final Locale[] AVAILABLE_LOCALES = Locale.getAvailableLocales();
    private static final String UNSUPPORTED_COUNTRY_CODE_TEXT = "The following country code is not supported by the installed version of JRE: ";

    private String name;
    private Date birthday;
    private Locale locale;
    private Results results;

    /**
     * Marks the beginning of a new Athlete construction
     */
    public void newAthlete() {
        name = null;
        birthday = null;
        locale = null;
        results = new Results();
    }

    /**
     * Sets the name to the athlete under construction
     * @param name the name to set
     */
    public void addName(String name) {
        this.name = name;
    }

    /**
     * Sets the date of birth to the athlete under construction
     * @param birthdayDate the day of birth to set
     */
    public void addBirthday(Date birthdayDate) {
        birthday = birthdayDate;
    }

    /**
     * Sets the country to the athlete under construction
     * @param countryCode ISO 2-letter country code to set
     * @throws UnsupportedCountryException if {@link #getLocaleFor(String)} throws it
     */
    public void addCountry(String countryCode) throws UnsupportedCountryException {
        locale = getLocaleFor(countryCode);
    }

    /**
     * Since it's not possible to create an instance of {@link java.util.Locale} from a country code,
     * the method has to iterate all Locales available in the installed JRE and look for the one
     * with the <code>countryCode</code> specified as a parameter.
     *
     * @param countryCode country code for whtich to get an instance of {@link java.util.Locale}
     * @return an instance of {@link java.util.Locale} corresponding to the specified <code>countryCode</code>
     * @throws UnsupportedCountryException  if the installed version of JRE does not support the Locale
     *                                      with the specified <code>countryCode</code>
     */
    Locale getLocaleFor(String countryCode) throws UnsupportedCountryException {
        for (Locale availLocale : AVAILABLE_LOCALES) {
            if (availLocale.getCountry().equals(countryCode)) return availLocale;
        }
        throw new UnsupportedCountryException(UNSUPPORTED_COUNTRY_CODE_TEXT + countryCode);
    }

    /**
     * Creates and adds the result to the athlete under construction
     * @param event of the <code>result</code>
     * @param result of the <code>event</code>
     */
    public void addResult(DecathlonEvent event, BigDecimal result) {
        results.addResult(new Result(event, result));
    }

    /**
     * Returns the instance of a newly created {@link net.azib.java.students.t030629.homework.base.Athlete}
     * @return newly created {@link net.azib.java.students.t030629.homework.base.Athlete} instance
     * @throws IncompleteAthleteException if some of the requires Athlete fields were not set
     *          (determined by {@link #isIncomplete()} method).
     */
    public Athlete getAthlete() throws IncompleteAthleteException {
        if (isIncomplete()) {
            throw new IncompleteAthleteException();
        }
        return new Athlete(name, birthday, locale, results);
    }

    /**
     * Checks <code>name</code>, <code>birthday</code>, <code>locale</code> and all the <code>results</code>
     * to be set for the athlete under construction
     * @return <code>false</code> if all the fields are set. <code>true</code> otherwise.
     */
    private boolean isIncomplete() {
        return name == null || birthday == null || locale == null || !results.areComplete();
    }

    /**
     * Helper class, to see the descriptive exception when building fails
     */
    public class UnsupportedCountryException extends Exception {
        public UnsupportedCountryException(String message) {
            super(message);
        }

    }

    /**
     * Helper class, to see the descriptive exception when building fails
     */
    public class IncompleteAthleteException extends Exception {}
}
