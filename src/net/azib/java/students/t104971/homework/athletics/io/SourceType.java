package net.azib.java.students.t104971.homework.athletics.io;

/**
 * @author Jaroslav Judin
 */
public enum SourceType {

    XML("-xml"),
    CSV("-csv"),
    DB("-db"),
    HTML("-html"),
    CONSOLE("-console");

    private String type;

    SourceType(String type) {
        this.type = type;
    }

    public static SourceType parse(String type) {
        for (SourceType source : SourceType.values()) {
            if (source.type.equals(type)) {
                return source;
            }
        }
        return null;
    }
}
