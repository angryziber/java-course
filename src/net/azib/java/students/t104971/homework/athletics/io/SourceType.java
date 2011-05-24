package net.azib.java.students.t104971.homework.athletics.io;

import net.azib.java.students.t104971.homework.athletics.io.input.ConsoleDataCollector;
import net.azib.java.students.t104971.homework.athletics.io.input.CsvDataCollector;
import net.azib.java.students.t104971.homework.athletics.io.input.DataCollector;
import net.azib.java.students.t104971.homework.athletics.io.input.DbDataCollector;

/**
 * @author Jaroslav Judin
 */
public enum SourceType {

    CSV {
        @Override
        public DataCollector getCollector() {
            return new CsvDataCollector();
        }
    },
    DB {
        @Override
        public DataCollector getCollector() {
            return new DbDataCollector();
        }
    },
    CONSOLE {
        @Override
        public DataCollector getCollector() {
            return new ConsoleDataCollector();
        }
    };

    public abstract DataCollector getCollector();
}
