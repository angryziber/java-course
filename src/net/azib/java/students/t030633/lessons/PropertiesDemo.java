package net.azib.java.students.t030633.lessons;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author t030633
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties prop = System.getProperties();
		
		String osName = prop.getProperty("os.name");
		System.out.println(osName);
		System.out.println(prop);
	}

}
