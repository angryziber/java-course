package net.azib.java.students.t010687.homework;
import java.sql.*;
//import com.mysql.jdbc.Driver;
/**
 * MySQL_Connection
 *
 * @author Matu
 */
public class MySQL_Connection {

  public static void main(String[] args){
      try {

          Class.forName("com.mysql.jdbc.Driver").newInstance();
      }
      catch(Exception e){
          System.out.println("Failed to load MySQL driver");
          System.exit
          (-1);
      }

      String connstring = "jdbc:mysql://srv.azib.net:3306/decathlon?user=java&password=java";
      try {
          Connection conn = DriverManager.getConnection(connstring);

          System.out.println("Connection established");

          Statement s = conn.createStatement();
          if (s.execute("SELECT * FROM `athletes`")){//decathlon
              System.out.println
              ("Query successful");
              ResultSet res = s.getResultSet();
              while(res.next()){
                  System.out.println(res.getString("name")+" | "+res.getString("dob"));
              }
          }
          else {
              System.out.println("Query failed");
          }

          conn.close();
      }
      catch(SQLException e){

          System.out.println("Failed to open a DB connection");
          System.out.println("Message: "+e.getMessage());
      }
  }
}