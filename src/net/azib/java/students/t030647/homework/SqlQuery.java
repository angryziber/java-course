package net.azib.java.students.t030647.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * SqlQuery
 * Make queries from database according to selected competition
 * @author Igor
 */
public class SqlQuery {
	
	String[] outputData = null;
	ArrayList<String> al = new ArrayList<String>();
	public SqlQuery(String compName) {
		
		try {
	      Statement stmt, stmt2;
	      ResultSet rs = null;
	      ResultSet rs2 = null;
	      int id = 0;
	      Float race100m, race400m, race1500m, hurdles_110m, long_jump;
	      Float shot_put, high_jump, discus_throw, pole_vault, javelin_throw;
	      //Register the JDBC driver for MySQL.
	      Class.forName("com.mysql.jdbc.Driver");

	      String url = "jdbc:mysql://srv.azib.net:3306/decathlon?useUnicode=true&characterEncoding=UTF8";

	      Connection con = DriverManager.getConnection(url,"java", "java");

	      //Get a Statement object
	      stmt = con.createStatement();
	      rs = stmt.executeQuery("SELECT * FROM competitions WHERE description='"+compName+"'");
	      while (rs.next()) {
	    	  id = rs.getInt("id");
	      }
	      rs = stmt.executeQuery("SELECT * FROM results WHERE competition_id='"+id+"'");
	      while (rs.next()) {
	    	  StringBuffer data = new StringBuffer();
	    	  int id2 = rs.getInt("athlete_id");
	    	  stmt2 = con.createStatement();
	    	  rs2 = stmt2.executeQuery("SELECT * FROM athletes WHERE id='"+id2+"'");
	    	  while(rs2.next()) {
	    		  String[] dob = rs2.getString("dob").split("-");
	    		  data.append(rs2.getString("name")+","+dob[2]+"."+dob[1]+"."+dob[0]+","+rs2.getString("country_code")+",");
	    	  }
	    	  race100m = rs.getFloat("race_100m");
	    	  race400m = rs.getFloat("race_400m");
	    	  race1500m = rs.getFloat("race_1500m");
	    	  hurdles_110m = rs.getFloat("hurdles_110m");
	    	  long_jump = rs.getFloat("long_jump");
	    	  shot_put = rs.getFloat("shot_put");
	    	  high_jump = rs.getFloat("high_jump");
	    	  discus_throw = rs.getFloat("discus_throw");
	    	  pole_vault = rs.getFloat("pole_vault");
	    	  javelin_throw = rs.getFloat("javelin_throw");
	    	  data.append(race100m+","+long_jump+","+shot_put+","+high_jump+","+race400m+","+hurdles_110m+","
	    			  +discus_throw+","+pole_vault+","+javelin_throw+","+race1500m);
	    	  al.add(data.toString());
	      }
	      con.close();
	    }catch( Exception e ) {
	      e.printStackTrace();
	    }
	}

	/**
	 * @return competition's data
	 */
	public String[] getData() {
		
		outputData = new String[al.size()];
		al.toArray(outputData);
		return outputData;
	}
	
}
