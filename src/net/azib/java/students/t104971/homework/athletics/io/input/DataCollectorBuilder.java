package net.azib.java.students.t104971.homework.athletics.io.input;

/**
 * @author Jaroslav Judin
 */
public class DataCollectorBuilder {

    public static DataCollector getCollector(String type) {
        if ("-console".equals(type)) {
            return new ConsoleDataCollector();
        } else if ("-db".equals(type)){
            return new DbDataCollector();
        } else if ("-csv".equals(type)) {
            return new CsvDataCollector();
        }

        return null;
    }

}
