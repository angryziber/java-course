package net.azib.java.students.t104607.homework;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 104607 IASM
 */
public class InputDb {
	// java properties http://download.oracle.com/javase/tutorial/essential/environment/properties.html

	InputDb (String db) throws SQLException, IOException {
		System.out.println("InputDb: " + db);
		String url = null;
		String user = null;
		String password = null;

		Properties props = new Properties();
		props.load(InputDb.class.getResourceAsStream( "db.properties" ));
		url = props.getProperty("url");
		user = props.getProperty("user");
		password = props.getProperty("password");
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn.getMetaData().getDatabaseProductName());
		conn.close();
	}
}
