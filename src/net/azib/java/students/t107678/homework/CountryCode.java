package net.azib.java.students.t107678.homework;

import java.util.regex.Pattern;

public class CountryCode {


    private static final Pattern PATTERN = Pattern.compile("[a-zA-z]{2}");
    private final String value;

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
