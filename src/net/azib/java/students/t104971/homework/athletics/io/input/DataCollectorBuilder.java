package net.azib.java.students.t104971.homework.athletics.io.input;

import net.azib.java.students.t104971.homework.athletics.io.SourceType;

/**
 * @author Jaroslav Judin
 */
public class DataCollectorBuilder {

    public static DataCollector getCollector(SourceType type) {
        switch (type) {
            case CONSOLE:
                return new ConsoleDataCollector();
            case DB:
                return new DbDataCollector();
            case CSV:
                return new CsvDataCollector();
            default:
                return null;
        }
    }
}
