package net.azib.java.students.t092861.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


/**
 * @author Stanislav / 092861
 * 
 */
public class IOdb extends AbstractIO {
	
	/**
	 * File name or the path to the file.
	 */
	public String param = "";
	
	private String nameOrId = "";

	private static Properties cProps;

	private static String url;
	
	public IOdb(String param, Controller ctrl) {
		super(ctrl);
		this.param = param;
	}

	@Override
	ArrayList<Athlete> input() {
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		cProps = new Properties();
		FileInputStream in;

		try {
			in = new FileInputStream(Const.PACKAGE + "db.properties");
			cProps.load(in);
			in.close();
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
			conn = openConnection();		
			st = (Statement) conn.createStatement();
			rs = st
					.executeQuery("SELECT A.*, R.*, C.* FROM athletes A, results R, competitions C WHERE (C.name = '"
							+ getParameters()
							+ "' OR C.id = '"
							+ getParameters()
							+ "') AND C.id = R.competition_id AND A.id=R.athlete_id");
			while (rs.next())
			{
				inputData = new ArrayList<String>();
				inputData.add(rs.getString("name"));
				
				String date = convertDateDMY(rs.getDate("dob"));
				inputData.add(date);
				
				inputData.add(rs.getString("country_code"));
				inputData.add(rs.getString("race_100m"));
				inputData.add(rs.getString("long_jump"));
				inputData.add(rs.getString("shot_put"));
				inputData.add(rs.getString("high_jump"));
				inputData.add(rs.getString("race_400m"));
				inputData.add(rs.getString("hurdles_110m"));
				inputData.add(rs.getString("discus_throw"));
				inputData.add(rs.getString("pole_vault"));
				inputData.add(rs.getString("javelin_throw"));
				inputData.add(rs.getString("race_1500m"));
				athletes.add(ctrl.readData(inputData));
			}
			
			rs.close();
			out.println("\nSuccessful input from " + "\"" + url + "\"" + " database!\n");
		}catch (ArrayIndexOutOfBoundsException e) {
			out.println("Error! Some data from " + "\"" + url + "\"" + " is unreadable\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}
			catch (Exception e) {
			}
		}
		return athletes;
	}
	
	static Connection openConnection() throws SQLException {
		url = "jdbc:mysql://" + cProps.getProperty("server") + ":" + cProps.getProperty("port.default") + "/";
		String dbName = cProps.getProperty("database");
		String userName = cProps.getProperty("user");
		String password = cProps.getProperty("password");
		out.println("Connected to database");		
		return (Connection) DriverManager.getConnection(url + dbName, userName, password);
	}

	@Override
	void output(ArrayList<Athlete> athletes) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @return the nameOrId
	 */
	public String getNameOrId() {
		return nameOrId;
	}

	void ShowingInDB(String nameOrId) {
		this.nameOrId = nameOrId;
	}

	@Override
	public String getParameters() {
		return param;
	}

}
