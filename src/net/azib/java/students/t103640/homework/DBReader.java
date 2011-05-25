package net.azib.java.students.t103640.homework;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class DBReader {
    Connection conn = null;
    PreparedStatement stmnt = null;


    public ArrayList<Athlete> getDBData(String inputParam) {

        ArrayList<Athlete> athletes = new ArrayList<Athlete>();

        Properties properties = getProperties();

        getConnection(properties);

        ResultSet rs = extractData(inputParam);

        boolean noBadData= false;

        try {
            while(rs.next()) {
                Athlete athlete = null;

                try{
                    athlete = new Athlete();

                    athlete.setName(rs.getString("name"));

                    athlete.setBirthday(addDate(rs.getDate("dob")));

                    athlete.setCountry(addCountry(rs.getString("country_code")));

                    athlete.setHundredMSprint(rs.getDouble("race_100m"));

                    athlete.setLongJump(rs.getDouble("long_jump"));

                    athlete.setShotPut(rs.getDouble("shot_put"));

                    athlete.setHighJump(rs.getDouble("high_jump"));

                    athlete.setFourHundredMSprint(rs.getDouble("race_400m"));

                    athlete.setHundredAndTenHurdles(rs.getDouble("hurdles_110m"));

                    athlete.setDiscusThrow(rs.getDouble("discus_throw"));

                    athlete.setPoleVault(rs.getDouble("pole_vault"));

                    athlete.setJavelinThrow(rs.getDouble("javelin_throw"));

                    athlete.setKilometerAndHalfRace(rs.getDouble("race_1500m"));

                    noBadData = true;

                }catch (Exception e){
                System.out.println(athlete.getName()+ " had some bad values");

                }
                 if(noBadData){
                     athletes.add(athlete);
                 }
                }

            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return athletes;
    }

    private String addCountry(String country_code) {
        CoustomUtilities validator = new CoustomUtilities();
        try {
            return validator.checkISOCountry(country_code);
        } catch (Exception e) {
            System.out.println("Not valid Country code");
        }
        return country_code;
    }

    private Date addDate(Date dob) {
        CoustomUtilities validator = new CoustomUtilities();
        try {
            return validator.parseDbDate(dob);
        } catch (ParseException e) {
            System.out.println("Could not parse date, using the db one");
        }
        return dob;
    }


    private ResultSet extractData(String inputParam) {
        ResultSet rs = null;
        int id;

        try{
            id = Integer.parseInt(inputParam);

            stmnt = conn.prepareStatement("SELECT a.*,r.* FROM competitions as c LEFT JOIN results as r " +
                    "ON c.id = r.competition_id LEFT JOIN athletes as a ON r.athlete_id = a.id WHERE c.id = ?");

            stmnt.setInt(1, id);
            return  rs = stmnt.executeQuery();


        }catch (NumberFormatException e){
            System.out.println("Entered value was not ID, must have been name;");
            try{
                stmnt = conn.prepareStatement("SELECT id FROM competitions WHERE name = ?");

                stmnt.setString(1, inputParam);
                ResultSet ids = stmnt.executeQuery();

                if(ids.next()){
                    return rs = extractData(String.valueOf(ids.getInt("id")));
                }
            } catch (SQLException e1) {

                 System.out.println("Error getting ID using name");
            }
        } catch (SQLException e) {
            System.out.println("Error reading by ID");
        }


        return rs;
    }

    private void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getConnection(Properties pro) {

         try{
       conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("username"), pro.getProperty("password"));
     } catch (SQLException e) {
         e.printStackTrace();
     }

    }

    private Properties getProperties() {
        Properties properties = new Properties();
        InputStream stream = null;

        try{
            stream = getClass().getResourceAsStream("db.properties");
            properties.load(stream);
            } catch (IOException e) {
            System.out.println("Can´t read db.properties");
        }finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
