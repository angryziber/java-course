package net.azib.java.lessons.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * SavepointExample
 * 
 * @author ant
 */
public class SavepointExample {
	
	protected Connection connection;

	public void initializeConnection(String url, String user, String password) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		connection = DriverManager.getConnection(url, user, password);
	}
	
	private void example() throws SQLException {
		connection.setAutoCommit(false);
		String sql = "update test set age=? where name=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setInt(1, 11);
		ps.setString(2, "Foo Bar");
		int updateCount = ps.executeUpdate(); // update returns the counter
		System.out.println("update " + updateCount + " rows");
		
		Savepoint savepoint = connection.setSavepoint(); // bookmark
		
		ps.clearParameters();
		ps.setInt(1, 34);
		ps.setString(2, "Foo Bar");
		updateCount = ps.executeUpdate(); 
		System.out.println("update " + updateCount + " rows");
		
		ps.close();
		
		connection.rollback(savepoint);  // rolback the bookmarked transaction
		connection.commit();
		
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select age from test where name = 'Foo Bar'");
		rs.next();
		
		int age = rs.getInt(1);
		System.out.println("Foo Bar's age is " + age);
		
		st.close();
	}
	
	public void releaseConnection() throws SQLException{
		try {
		   connection.close();
		}catch(Exception e){
			//don't care at the moment
		}
	}
	
	public static void main(String[] args) throws Exception {
		SavepointExample se = new SavepointExample();
		se.initializeConnection("jdbc:derby:c:\\eclipse\\myderby", "test", "test");
		se.example();
		se.releaseConnection();
	}

}
