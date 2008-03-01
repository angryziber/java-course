package net.azib.java.students.t980814.lec3;

import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author dell
 */
public class PropertiesDemo {
	public static void main(String[] args) {
		Properties properties = System.getProperties();
		System.out.println(properties);

		// Et väljastada oma properteid...
		System.out.println(properties.getProperty("hello.string"));
		// Kuidas seda hello.string oma programmile kaasa anda... -D keyword command line pealt
	
	}
}
