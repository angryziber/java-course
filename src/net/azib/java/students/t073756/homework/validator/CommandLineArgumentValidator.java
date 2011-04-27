package net.azib.java.students.t073756.homework.validator;

public enum CommandLineArgumentValidator implements Validator<String> {
    CONSOLE("-console"),
    CSV("-csv"), FILE_PATH(FILE_PATH_PATTERN),
    DB_INPUT("-db"), COMPETITION_ID("\\d+"),
    XML_OUTPUT("-xml"),
    HTML_OUTPUT("-html");

    private String regexp;

    CommandLineArgumentValidator(String regexp) {
        this.regexp = regexp;
    }

    public boolean validate(String input) {
        return RegexpValidator.validate(input, regexp);
    }
}
