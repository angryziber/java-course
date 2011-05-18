package net.azib.java.students.t107678.homework;

import java.util.regex.Pattern;

/**
 * County Code (ISO 2 letter characters)
 */
public class CountryCode {


    private static final Pattern PATTERN = Pattern.compile("[a-zA-Z]{2}");
    private final String value;

    /** Constructor; It will take value provided by used, it will validate it and make sure it consist of two letter
     *
     * @param value ISO 2-letter code
     */
    public CountryCode(String value) {

        if (!PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException("Country code must be of length 2");
        }


        this.value = value.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryCode that = (CountryCode) o;

        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public String getValue() {
        return this.value;
    }

}
