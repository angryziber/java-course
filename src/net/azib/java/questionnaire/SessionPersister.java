package net.azib.java.questionnaire;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SessionPersister {
	
	// these ideally need to be configurable
	private static final String DB_URL = "jdbc:mysql://srv.azib.net:3306/java";
	private static final String DB_USER = "java";
	private static final String DB_PASSWORD = "java";
	private static final String SVN_HOME = "/home/svn/";
	private static final String USERADD_SCRIPT = ".java_useradd.sh";
	
	private Session session;

	/**
	 * Creates a persistent instance
	 * @param session the session which data to persist
	 * @throws IllegalStateException if session has already been persisted
	 */
	public SessionPersister(Session session) throws IllegalStateException {
		this.session = session;
		
		if (session.isFinished()) {
			// don't save again
			throw new IllegalStateException("Session is already finished!");
		}
	}

	/**
	 * Persists the data permanently to the Database.
	 */
	public void storeUserInfo() throws PersistException {
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
			else if (e instanceof PersistException) 
				throw (PersistException)e;
			else
				throw new PersistException("Unable to persist data: " + e.toString(), e);
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
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		conn.setAutoCommit(false);
		return conn;
	}

	private int saveUser(Connection conn, User user) throws SQLException, PersistException {
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

	private void saveAnswer(Connection conn, int userId, Answer answer) throws SQLException, PersistException {
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
	
	/**
	 * Gives access to Subversion
	 * @return the newly created username 
	 */
	public String giveAccess() throws PersistException {
		// synchronize globally to prevent multiple simultaneous calls
		synchronized (SessionPersister.class) {
			try {
				String username = "t" + session.user.studentCode;
				// run the script for addition
				Process p = Runtime.getRuntime().exec(
						new String[] {USERADD_SCRIPT, username, session.user.password}, 
						null, new File(SVN_HOME));
				
				int exitCode = p.waitFor();
				if (exitCode != 0) {
					throw new PersistException("Failed to give Subversion access (code " + exitCode + ")");
				}
				return username;
			}
			catch (Exception e) {
				throw new PersistException("Failed to give Subversion access", e);
			}
		}
		
	}
	
	public static class PersistException extends Exception {

		private static final long serialVersionUID = 1L;

		public PersistException(String message) {
			super(message);
		}

		public PersistException(String message, Throwable cause) {
			super(message, cause);
		}
	}
}
