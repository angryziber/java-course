package ee.ttu.decathlon.io;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import ee.ttu.decathlon.DecathlonException;
import ee.ttu.decathlon.Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnectionProvider {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = provideConnection();
            }
        } catch (SQLException e) {
            throw new DecathlonException("problems with DB connection");
        }
        return connection;
    }


    private static Connection provideConnection() {
        Properties p = new Properties();
        try {
            p.load(Main.class.getResourceAsStream("dbconnection.properties"));
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl(p.getProperty("url"));
            return dataSource.getConnection(p.getProperty("user"), p.getProperty("password"));
        } catch (Exception e) {
            throw new DecathlonException("unable to provide DB connection");
        }
    }
}