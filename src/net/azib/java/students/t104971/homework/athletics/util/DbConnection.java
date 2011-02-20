package net.azib.java.students.t104971.homework.athletics.util;

import net.azib.java.students.t104971.homework.athletics.config.PropertiesLoader;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author Jaroslav Judin
 */
public class DbConnection {

    private Logger log = Logger.getLogger(getClass());
    private static Connection connection;


    public static Connection getConnection() {
        return connection != null ? connection : new DbConnection().connect();
    }

    private Connection connect() {
        try {
            ResourceBundle bundle = PropertiesLoader.getDbProperties();
            Class.forName(bundle.getString("Driver"));
            connection = DriverManager.getConnection(
                    bundle.getString("url"),
                    bundle.getString("usr"),
                    bundle.getString("pwd"));
        } catch (ClassNotFoundException e) {
            log.error("Cannot find driver class", e);
            close();
        } catch (SQLException e) {
            log.error("Cannot get db connection", e);
            close();
        }
        return connection;
    }

    private void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Cannot close connection", e);
            }
        }
    }

}
