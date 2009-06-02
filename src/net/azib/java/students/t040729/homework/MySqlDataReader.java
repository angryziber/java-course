package net.azib.java.students.t040729.homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * MySQL implementation for getting competition data from DataBase.
 *
 * @author ValleTon
 */
public class MySqlDataReader implements CompetitionDataIn {
	private List<Athlete> athletes = new ArrayList<Athlete>();
	private Properties properties;
	private Properties dbProperties;
	private int competitionId = -1;
	private String competitionName = null;

	Connection connection = null;
	
	/**
	 * @param inputParameter Given parameter determines which competition
	 * is retrieved from database. If this parameter is numeric then
	 * it is considered ID value for competition. If this parameter is string
	 * then competition named by that string is retrieved, if applicable.
	 */
	MySqlDataReader(String inputParameter, Properties dbProperties){
		this.dbProperties = dbProperties;
		try{
			competitionId = Integer.parseInt(inputParameter);
		}catch(NumberFormatException e){
			competitionName = inputParameter;
		}
	}

	void makeConnection() throws Exception{
		try{
			connection = DriverManager.getConnection(dbProperties.getProperty("sql.connection_string"), dbProperties.getProperty("sql.user"), dbProperties.getProperty("sql.password"));
		}catch(SQLException e){
			throw new SQLException("Cannot connect to SQL database.\n"+e.getMessage());
		}
	}
	
	private void closeConnection(){
		if (connection!=null){
			try {
				connection.close();
			}
			catch (SQLException e) {
			}
		}
	}
	
	private boolean getCompetitionId() throws SQLException{
		PreparedStatement pstmt;
		
		if (competitionName!=null){
			pstmt = connection.prepareStatement("SELECT "+dbProperties.getProperty("sql.competitions_tbl.id")+" FROM "+dbProperties.getProperty("sql.competitions_tbl")+" WHERE "+dbProperties.getProperty("sql.competitions_tbl.name")+" = ? LIMIT 1");
			pstmt.setString(1, competitionName);
		}else{
			pstmt = connection.prepareStatement("SELECT "+dbProperties.getProperty("sql.competitions_tbl.id")+" FROM "+dbProperties.getProperty("sql.competitions_tbl")+" WHERE "+dbProperties.getProperty("sql.competitions_tbl.id")+" = ? LIMIT 1");
			pstmt.setInt(1, competitionId);
		}

		ResultSet rs = pstmt.executeQuery();
		if (!rs.next()){
			System.err.println("Competition "+((competitionName!=null)?("named \""+competitionName+"\""):("ID="+competitionId))+" not found");
			return false;
		}else{
			competitionId = rs.getInt(dbProperties.getProperty("sql.competitions_tbl.id"));
			return true;
		}
	}
	
	private ResultSet getAthletesData() throws SQLException{
		PreparedStatement pstmt;
		//pstmt = connection.prepareStatement("SELECT a.name, DATE_FORMAT(a.dob,'%d.%m.%Y') AS dob, a.country_code, r.* FROM "+dbProperties.getProperty("sqlresultstbl")+" AS r INNER JOIN "+properties.getProperty("sqlathletestbl")+" AS a ON r.athlete_id = a.id WHERE r.competition_id = ?");
		pstmt = connection.prepareStatement("SELECT a."+dbProperties.getProperty("sql.athletes_tbl.name")+", a."+dbProperties.getProperty("sql.athletes_tbl.dob")+", a."+dbProperties.getProperty("sql.athletes_tbl.country_code")+", r.* FROM "+dbProperties.getProperty("sql.results_tbl")+" AS r INNER JOIN "+dbProperties.getProperty("sql.athletes_tbl")+" AS a ON r."+dbProperties.getProperty("sql.results_tbl.athlete_id")+" = a."+dbProperties.getProperty("sql.athletes_tbl.id")+" WHERE r."+dbProperties.getProperty("sql.results_tbl.competition_id")+" = ?");
		pstmt.setInt(1,competitionId);
		
		return pstmt.executeQuery();
	}
	
	@Override
	public List<Athlete> getCompetitionData() throws Exception{
		String name = null;
		Date birthDate;
		String birthDateString;
		String countryCode;
		SimpleDateFormat sdf = new SimpleDateFormat(properties.getProperty("dateformat_string"));
		
		List<String> listOfResultColumns = Arrays.asList(dbProperties.getProperty("sql.event_columns").split(","));
		
		makeConnection();
		
		try {
			if (getCompetitionId()){
				ResultSet rs = getAthletesData();

				while(rs.next()){
					name = rs.getString(dbProperties.getProperty("sql.athletes_tbl.name"));
					countryCode = rs.getString(dbProperties.getProperty("sql.athletes_tbl.country_code"));
						
					try{
						birthDate = rs.getDate(dbProperties.getProperty("sql.athletes_tbl.dob"));
						birthDateString = sdf.format(birthDate);
					}catch(SQLException e){
						//in case we get 0000-00-00 or somekind of a surprise
						birthDateString = null;
					}
						
					Athlete athlete = new Athlete(new Name(name),new BirthDate(birthDateString,properties.getProperty("dateformat_string")),new Country(countryCode));
					byte i = 0;
					for (String columnName : listOfResultColumns){
						athlete.insertEventResult(i, rs.getFloat(columnName));
						i++;
					}
						
					athletes.add(athlete);
				}
				if (name==null){
					throw new Exception("No athletes on that competition.");
				}
			}else{
				throw new Exception("Cannot continue without data.");
			}
		}catch (SQLException e) {
			throw e;
		} finally {
			closeConnection();
		}
		
		return athletes;
	}
	
	@Override
	public void setAppProperties(Properties properties) {
		this.properties = properties;		
	}
}
