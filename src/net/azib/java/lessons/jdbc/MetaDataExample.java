package net.azib.java.lessons.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * MetaDataExample
 * 
 * @author ant
 */
public class MetaDataExample {

	protected Connection connection;

	public void initializeConnection(String url, String user, String password) throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		connection = DriverManager.getConnection(url, user, password);
	}

	public void f() throws SQLException {
		DatabaseMetaData metadata = connection.getMetaData();
		System.out.println(metadata);
		System.out.println("Database: " + metadata.getDatabaseProductName() + " " + metadata.getDatabaseProductVersion());
		ResultSet rs = metadata.getTables(null, null, null, null);

		while (rs.next()) {
			System.out.println("-----------------");
			System.out.println("TABLE: " + rs.getString("TABLE_NAME"));
			//System.out.println(rs.getString("TABLE_CAT"));
			System.out.println("SCHEMA: " + rs.getString("TABLE_SCHEM"));
			System.out.println("TYPE: " + rs.getString("TABLE_TYPE"));
			//System.out.println(rs.getString("REMARKS"));
			//System.out.println(rs.getString("TYPE_CAT"));
			//System.out.println(rs.getString("TYPE_SCHEM"));
			//System.out.println(rs.getString("TYPE_NAME"));
			//System.out.println(rs.getString("SELF_REFERENCING_COL_NAME"));
			//System.out.println(rs.getString("REF_GENERATION"));
		}
		rs.close();
	}

	public static void main(String[] args) throws Exception {
		MetaDataExample mde = new MetaDataExample();
		mde.initializeConnection("jdbc:derby:c:\\eclipse\\myderby", "test", "test");
		mde.f();
	}

}
