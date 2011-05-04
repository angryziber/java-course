package net.azib.java.students.t092877.demo;

import java.util.Properties;

public class GetPropertiesDemo {

	public static void main(String[] args) {

		Properties props = System.getProperties();

		// Separate system properties fields
		System.out.println("File separator: " + System.getProperty("file.separator"));
		System.out.println("User language: " + System.getProperty("user.language"));
		System.out.println("User home directory: " + System.getProperty("user.home"));

		// Provides the list of all system properties
		props.list(System.out);


	}

}
