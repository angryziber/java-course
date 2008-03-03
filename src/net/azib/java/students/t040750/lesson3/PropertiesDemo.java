package net.azib.java.students.t040750.lesson3;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author t040750
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		String osName = properties.getProperty("os.name");
		System.out.println(properties);
		System.out.println(osName);
		
		/* Kuna sellist property't defaultina ei eksisteeri, siis 
		 * saame selle ise liseada. Open Run dialog -> Arguments ->
		 * -> VM Arguments: -Dhello.string="Tere hommikust!"
		 */
		
		System.out.println(properties.getProperty("hello.string"));
	}
}
