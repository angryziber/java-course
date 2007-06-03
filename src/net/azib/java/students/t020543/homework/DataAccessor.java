package decathlon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * A class which implements access to the database
 * and holds needed methods and parameters.
 * @author t020543
 */
public class DataAccessor implements IDataAccessor {
	
	/**
	 * Connection to the database
	 */
	private Connection connection;
	
	/**
	 * Calls method {@link #calculatePoints(IAthlete)} of {@link IPointCalculator}
	 * @param calculator - {@link IPointCalculator} interface
	 * @param man - {@link IAthlete} interface
	 */
	private int calculatePoints (IPointCalculator calculator, IAthlete man){
		return calculator.calculatePoints(man);
	}
	/**
	 * Calls {@link #checkAllNegative(IAthletee)} method of {@link IDataValidation} class
	 * @param check - {@link IDataValidation} interface
	 * @param man - {@link IAthlete} interface
	 */
	private boolean checkAllNegative(IDataValidation check, IAthlete man){
		return check.checkAllNegative(man);
	}
	/**
	 * Calls {@link #checkWorldRecord(Athlete)} method of {@link IDataValidation} class
	 * @param check - {@link IDataValidation} interface
	 * @param man - {@link IAthlete} interface
	 */
	private static boolean checkWorldRecord(IDataValidation checker, IAthlete man){
		return checker.checkWorldRecord(man);
	}
	
	public void initializeConnection(String url) {
		try{
			//link to the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//link to the database
			connection = DriverManager.getConnection(url);
		}
		//Exception handling
		catch(SQLException e){
			System.out.println("Error while opening connection!");
		}
		catch(ClassNotFoundException e){
			System.out.println("Driver is not found!");
		}
	}
	
	public void releaseConnection(){
		try{
			connection.close(); // closing connection
		}
		catch(SQLException e){
			System.out.println("Error while closing connection!");
		}
	}
	
	public List<Competition> makeQueryForCompetition(){
		
		Statement statement = null;
		List<Competition> list = new ArrayList<Competition>();
		
		try{
			statement = connection.createStatement();
			
			/*Making query to the DB, to read all data from  `competitions` table*/
			ResultSet resultSet = statement.executeQuery("SELECT * FROM `competitions` LIMIT 0 , 30");
			
			/*Extracting data from query result to Competition*/
			list = extractDataToCompetition(resultSet); 
			
			resultSet.close();
			statement.close();	//regular statement close
			return list;
		}
		//Exception handling
		catch(SQLException e){
			System.out.println("Error while executing query!");
			return list;
		}
		catch(NullPointerException e){
			System.out.println("Null was received as a query result!");
			return list;
		}
		finally {
			try{
				if(statement!=null) 
					statement.close(); //closing statement
			}
			catch(SQLException e){
				System.out.println("Error while closing query!");
			}
		}
	}
	
	public List<Athlete> makeQueryForAthlete(int choice){
		
		Statement statement = null;
		List<Athlete> list = new ArrayList<Athlete>();
		
		try{
			statement = connection.createStatement();
			/*
			 Making query to the DB, to read Athlete data from  
			 "athletes" and "results" tables, for a chosen competition.
			 */
			ResultSet resultSet = statement.executeQuery("SELECT * FROM results INNER JOIN athletes ON results.athlete_id = athletes.id WHERE competition_id =" + choice);

			/*Extracting data from query result to Athlete*/
			list = extractDataToAthlete(resultSet); 		
			
			resultSet.close(); 
			statement.close(); //regular statement close
			return list;
		}
		//Exception handling
		catch(SQLException e){
			System.out.println("Error while executing query!");
			return list;
		}
		catch(NullPointerException e){
				System.out.println("Null was received as a query result!");
				return list;
		}	
		finally {
			try{
				if(statement!=null) 
					statement.close(); //closing statement
			}
			catch(SQLException e){
				System.out.println("Error while closing query!");
			}
		}
	}
	
	/**
	 * Transforms received query ResulSet into list of {@link Competition} objects
	 * @param resultSet - input query result
	 * @return	list of objects with data
	 * @throws SQLException
	 */
	private List<Competition> extractDataToCompetition(ResultSet resultSet) throws SQLException{
		
		List<Competition> list = new ArrayList<Competition>(); 
		
		while (resultSet.next()) {
			
			/*adding to the list new instance of Competition, using constructor*/
			
			list.add(new Competition(	resultSet.getInt("id"), 
										resultSet.getString("country_code"), 
										resultSet.getString("date"), 
										resultSet.getString("description")));	
		}
		return list;
	}
	
	/**
	 *  Transforms received query ResulSet into list of {@link Athlete} objects
	 * @param resultSet - input query result
	 * @return	list of objects with data
	 * @throws SQLException
	 */
	private List<Athlete> extractDataToAthlete(ResultSet resultSet) throws SQLException{
		
		List<Athlete> list = new ArrayList <Athlete>(); 
		
		while (resultSet.next()) {
			
			//creating new instance of Athlete
			IAthlete man = new Athlete();
			
			//creating new instance of DataValidation
			IDataValidation check = new DataValidation();
			
			//reading values from query result
			
			man.setName(resultSet.getString("name"));
			man.setBirthday(resultSet.getString("dob"));
			man.setCountry(resultSet.getString("country_code"));
			man.setSprint100(resultSet.getDouble("race_100m"));
			man.setLongJump(resultSet.getDouble("long_jump"));
			man.setShotPut(resultSet.getDouble("shot_put"));		
			man.setHighJump(resultSet.getDouble("high_jump"));
			man.setSprint400(resultSet.getDouble("race_400m"));
			man.setHurdles110(resultSet.getDouble("hurdles_110m"));
			man.setDiscusThrow(resultSet.getDouble("discus_throw"));;
			man.setPoleVault(resultSet.getDouble("pole_vault"));
			man.setJavelinThrow(resultSet.getDouble("javelin_throw"));
			man.setRace1500(resultSet.getDouble("race_1500m"));
			
			//calculating scores for a Athlete instance
			man.setScore(calculatePoints(new PointCalculator(), (Athlete)man));
			
			//check input for being negative
			if(checkAllNegative(check, man)) 
			{
				//if negative - warn user and ignore data
				System.out.println("Wrong data! Input cannot be negative! Check the source file!");
				System.out.println("Input ignored.");
			}
			// if OK. adding Athlete instance to the list
			else list.add((Athlete)man);
			
			//check input for being to good
			if(checkWorldRecord(check,man)) 
			{
				//if true - warn user
				System.out.println("Warning! Input is greater than or equal to the World Record!");
			}
		}
		return list;
	}	
	
	
}
