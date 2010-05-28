package net.azib.java.students.t100258.homework;


import net.azib.java.students.t100258.homework.Result;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * InMySQL
 *
 * @author mihkel
 */
public class InMySQL implements InputWithParameter {
	/**
  	 * Input from Mysql db
  	 *@param name Id of competition or competition name
  	 *@throws IOException, SQLException
  	 *@return Arraylist of Results
  	 */     

	public ArrayList<Object> getResults(String name) throws IOException, SQLException {
		ArrayList <Object> results;
		results= new ArrayList <Object>();
		
		URL propertiesLocation= this.getClass().getResource("db.properties");
		BufferedReader in;
		in = new BufferedReader(new FileReader(propertiesLocation.toString().substring(5)));
		String param;
		
			param = in.readLine();
		
			try{
		in.close();
			}
			catch(IOException e){
				System.err.println("Caught IOException on closing DB connection properties file: " 
                        +  e.getMessage());
			}
		
		//System.out.println(param);//test
		Connection connection=DriverManager.getConnection(param);
		Statement statement=connection.createStatement();
		String sql="select athletes.name, dob, athletes.country_code, race_100m, long_jump, shot_put, high_jump, race_400m, hurdles_110m, discus_throw, pole_vault, javelin_throw, race_1500m from athletes, competitions, results where athletes.id=results.athlete_id and competitions.id=results.competition_id and competitions.";
		if (isIntNumber(name)==true)
			{sql= sql + "id='" + name +"'";}
		else
			{ sql= sql + "name='" + name+"'";}
		//System.out.println(sql);//test
		ResultSet result=statement.executeQuery(sql);
		
		

		
		
		try {
			while (result.next())
			{
				String tempname = result.getString("name");
				String tempbirth;
				if(result.getString("dob")==null)
				{tempbirth= "0000-00-00";}
				else{
				tempbirth =  (result.getString("dob").toString() );}
				String tempcountry = result.getString("country_code");
				Float tempsprint_100 = Float.parseFloat( result.getString("race_100m"));
				Float templong_jump = Float.parseFloat(result.getString("long_jump"));
				Float tempshort_put = Float.parseFloat(result.getString("shot_put"));
				Float temphigh_jump = Float.parseFloat(result.getString("high_jump"));
				String tempsprint_400 = result.getString("race_400m");
				Float temphurdles = Float.parseFloat(result.getString("hurdles_110m"));
				Float tempdiscus_throw = Float.parseFloat(result.getString("discus_throw"));
				Float temppole_vault = Float.parseFloat(result.getString("pole_vault"));
				Float tempjevelin_throw = Float.parseFloat(result.getString("javelin_throw"));
				String temprace = result.getString("race_1500m");
				Integer tempsum = 0;
				Integer tempplace =0;
				Result result1= new Result(tempname ,tempbirth ,tempcountry ,tempsprint_100 ,templong_jump ,tempshort_put ,temphigh_jump ,tempsprint_400 ,temphurdles ,tempdiscus_throw ,temppole_vault ,tempjevelin_throw ,temprace, tempsum, tempplace);
				results.add(result1);
				

			}
		}
		
		catch (SQLException e) {
			System.err.println("Caught SQLException: " 
                    +  e.getMessage());
		}
		finally{
			
		try {
			connection.close();
		}
		catch (SQLException e) {
			System.err.println("Caught SQLException on closing connection: " 
                    +  e.getMessage());
		}
			 
		}
		
		return results;
	}
	/**
	 * Check if string is numeric
	 *@param num String to check
	 *@return true if string is numeric, else false
	 */
	      public boolean isIntNumber(String num){
	      try{
	      Integer.parseInt(num);
	      } catch(NumberFormatException nfe) {
	      return false;
	      }
	      return true;
	      }
	      
}
