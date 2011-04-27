package net.azib.java.students.t073756.homework.validator;

import java.io.File;

public interface Validator<T> {
    String RESULT_PATTERN = "\\d{1,3}\\.\\d{1,2}";
    String TIME_RESULT_PATTERN = "(\\d{1,2}:)?" + RESULT_PATTERN;
    String NAME_PATTERN = "(\")?(\\(?\\p{IsL}+\\s?\\)?)+(\")?";
    String BIRTHDAY_PATTERN = "\\d{1,2}\\.\\d{2}.\\d{4}";
    String ISO2_PATTERN = "[A-Z]{2}";

    String FILE_PATH_PATTERN = "([a-zA-Z]:)?(" + File.separator + "?[a-zA-Z0-9_.-]+)+" + File.separator + "?";

    /**
     * Main method for input validation
     *
     * @param input - String for validation
     * @return - is input String valid for processing
     */
    boolean validate(T input);
}