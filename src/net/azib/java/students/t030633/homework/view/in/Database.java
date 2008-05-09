package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.view.Connections;
import net.azib.java.students.t030633.homework.view.Input;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Reads athletes from a database.
 * 
 * @author t030633
 */
public class Database implements Input {

	private Connection conn;
	private AthleteBuilder builder;

	public Database() throws SQLException, FileNotFoundException {
		this.conn = new Connections().getDatabaseConnection();
		System.out.println("Connection established.");
	}

	public Input builder(AthleteBuilder builder) {
		this.builder = builder;
		return this;
	}

	public List<Athlete> read() throws IOException {
		// TODO read athletes from database
		return null;
	}

	public void close() throws IOException {
		try {
			conn.close();
			System.out.println("Connection closed.");
		}
		catch (SQLException e) {
			throw new IOException();
		}
	}
	
}
