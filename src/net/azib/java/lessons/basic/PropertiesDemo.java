package net.azib.java.lessons.basic;

import java.util.Properties;

public class PropertiesDemo {
	public static void main(String[] args) {
		System.out.println("Running on " + System.getProperty("os.name"));

		Properties properties = System.getProperties();
		for (Object name : properties.keySet()) {
			System.out.println(name + "=" + properties.get(name));
		}
	}
}
