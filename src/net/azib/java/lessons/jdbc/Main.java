package net.azib.java.lessons.jdbc;

import net.azib.java.lessons.jdbc.SimpleExample.Person;

import java.util.List;

/**
 * Main
 * 
 * @author ant
 */
public class Main {
	public static void main(String[] args) throws Exception {
		//SimpleExample se = new SimpleExample();
		SimpleExample se = new PreparedStatementExample();
		se.initializeConnection("jdbc:derby:c:\\eclipse\\myderby", "test", "test");
		List<Person> list = se.makeQuery();
		se.releaseConnection();
		System.out.println(list);
	}
}
