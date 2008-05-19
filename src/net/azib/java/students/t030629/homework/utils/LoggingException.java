package net.azib.java.students.t030629.homework.utils;

import java.util.logging.Logger;

/**
 * Helper class acting as an unchecked expression and holding the logger
 * of the class where the cause exception occurred.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 19.05.2008
 * <br>Time: 2:44:21
 */
public class LoggingException extends RuntimeException {
    private final Logger log;

    public LoggingException(String message, Logger log) {
        super(message);
        this.log = log;
    }

    /**
     * @return log
     */
    public Logger getLog() {
        return log;
    }
}
