package net.azib.java.questionnaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SessionPersister {
	
	private String url;
	private String username;
	private String password;

	public SessionPersister() {
		url = "jdbc:mysql://srv.azib.net:3306/java";
		username = "java";
		password = "java";
	}

	/**
	 * Persists the data permanently to the Database.
	 */
	public void persist(Session session) {
		if (session.isFinished())
			// don't save the session again
			return;
		
		Connection conn = null;
		try {
			conn = openConnection();
			
			int userId = saveUser(conn, session.user);
			
			for (Answer answer : session.answers) {
				saveAnswer(conn, userId, answer);
			}
			
			conn.commit();
			
			// don't save again
			session.setFinished();
		}
		catch (Exception e) {
			try {
				// try to roll everything back
				conn.rollback();
			} 
			catch (SQLException e2) {
			}
			
			// wrap exception if needed
			if (e instanceof RuntimeException)
				throw (RuntimeException)e;
			else
				throw new RuntimeException("Unable to persist data: " + e.toString(), e);
		}
		finally {
			try {
				conn.close();
			}
			catch (Exception e) {
			}
		}
	}

	private Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(false);
		return conn;
	}

	private int saveUser(Connection conn, User user) throws SQLException {
		// insert the new user
		PreparedStatement statement = conn.prepareStatement("insert into users (year, name, studentCode, curriculumCode, email, phone, company, password) values (2007, ?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, user.name);
		statement.setString(2, user.studentCode);
		statement.setString(3, user.curriculumCode);
		statement.setString(4, user.email);
		statement.setString(5, user.phone);
		statement.setString(6, user.company);
		statement.setString(7, user.password);
		if (statement.executeUpdate() != 1)
			throw new PersistException("Cannot save user");
		
		// now retrieve the newly-created userId
		ResultSet generatedKeys = statement.getGeneratedKeys();
		generatedKeys.next(); 
		int userId = generatedKeys.getInt(1);
		generatedKeys.close();
		
		return userId;
	}

	private void saveAnswer(Connection conn, int userId, Answer answer) throws SQLException {
		PreparedStatement statement = conn.prepareStatement("insert into answers (user_id, question_id, answer, is_correct) values (?,?,?,?)");
		for (String answerText : answer.answers) {
			statement.setInt(1, userId);
			statement.setInt(2, answer.question.id);
			statement.setString(3, answerText);
			statement.setBoolean(4, answer.isCorrect());
			if (statement.executeUpdate() != 1)
				throw new PersistException("Cannot save answer to the question " + answer.question.id);
		}
	}
	
	public static class PersistException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public PersistException(String message) {
			super(message);
		}
		
	}
}
