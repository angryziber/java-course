package net.azib.java.students.t107678.homework;

import java.sql.*;

/** Logic for establishing connection with database and asking data form it
 *
 */
public class DataBaseConnector {



    private static final String dbUrl = "jdbc:mysql://java.azib.net:3306/decathlon";
    private static final String dbClass = "com.mysql.jdbc.Driver";

    protected static final String USER = "java";
    protected static final String PASSWORD = "java";


    protected void closeConnection(Connection con) throws SQLException {
        con.close();
    }

    /** This method uses Driver Manager to establish connection with database
     *
     * @return connection upon success, otherwise null
     */
    protected Connection getConnection() {
        try {
            Class.forName(dbClass);
            Connection connection = DriverManager.getConnection(dbUrl, USER, PASSWORD);
            return connection;
        } catch (Exception e) {
            return null;
        }
    }

    protected int executeUpdateInsert(String query) {               // will not use this probably
        try {
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(dbUrl, USER, PASSWORD);
            Statement stmt = con.createStatement();
            // ResultSet rs = stmt.executeQuery(query);
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            String out = e.toString();
            return -1;
        }
    }

    /**
     *
     * @param query
     * @return Desired data (that we asked in our statementById) from data base
     */
    protected ResultSet executeSelect(String query) {
        try {
            Class.forName(dbClass);
            Connection con = DriverManager.getConnection(dbUrl, USER, PASSWORD);
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            String out = e.toString();
            return null;
        }
    }

}
