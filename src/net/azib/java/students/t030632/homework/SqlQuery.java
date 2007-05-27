package net.azib.java.students.t030632.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * SqlQuery - reads from selected competition competitors results from database.
 *
 * @author Toni
 */
public class SqlQuery {
	private String[] outputData = null;
	private ArrayList<String> al = new ArrayList<String>();
	public SqlQuery(String compName) {
		
		try {
	      Statement stmt, stmt2;
	      ResultSet rs = null;
	      ResultSet rs2 = null;
	      int id = 0;
	      Float sprint100m, sprint400m, race1500m, hurdles110m, longJump;
	      Float shotPut, highJump, discusThrow, poleVault, javelinThrow;
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
	    		  DateFormat sdfDataBase = new SimpleDateFormat("yyyy-MM-dd");
	    		  DateFormat sdfApplicaion = new SimpleDateFormat("dd.MM.yyyy");
	    		  Date birthDay = sdfDataBase.parse(rs2.getString("dob"));
	    		  data.append(rs2.getString("name")).append(",").append(
	    				  		sdfApplicaion.format(birthDay)).append(",").append(
	    						  rs2.getString("country_code")).append(",");
	    	  }
	    	  sprint100m = rs.getFloat("race_100m");
	    	  sprint400m = rs.getFloat("race_400m");
	    	  race1500m = rs.getFloat("race_1500m");
	    	  hurdles110m = rs.getFloat("hurdles_110m");
	    	  longJump = rs.getFloat("long_jump");
	    	  shotPut = rs.getFloat("shot_put");
	    	  highJump = rs.getFloat("high_jump");
	    	  discusThrow = rs.getFloat("discus_throw");
	    	  poleVault = rs.getFloat("pole_vault");
	    	  javelinThrow = rs.getFloat("javelin_throw");
	    	  data.append(sprint100m).append(",").append(
	    			  longJump).append(",").append(
	    					  shotPut).append(",").append(
	    							  highJump).append(",").append(
	    									  sprint400m).append(",").append(
	    											  hurdles110m).append(",").append(
	    													  discusThrow).append(",").append(
	    															  poleVault).append(",").append(
	    																	  javelinThrow).append(",").append(
	    																			  race1500m);
	    	  
	    	  al.add(data.toString());
	      }
	      con.close();
	    }catch( Exception e ) {
	      e.printStackTrace();
	    }
	}

	/**
	 * @return competitors results in strings array (string represented in csv view)
	 */
	public String[] getData() {
		
		outputData = new String[al.size()];
		al.toArray(outputData);
		return outputData;
	}
	
}
