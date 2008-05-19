package net.azib.java.students.t030629.homework.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Helper class for closing {@link java.io.Closeable Cloaseables} quietly.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 19.05.2008
 * <br>Time: 2:19:54
 */
public class QuietCloser {

    /* Forbid instantiation */
    private QuietCloser() {}

    public static void closeSilently(Closeable closeable, Logger log) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                log.severe("Error closing closeable \'" + closeable.getClass() + "\'");
            }
        }

    }

    public static void closeSilently(Connection connection, Logger log) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.severe("Error closing DB connection");
            }
        }
    }
}
