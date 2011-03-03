package net.azib.java.students.t110051.Lesson4;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Priit
 * Date: 3.03.11
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class SystemProperties {

	public static void main(String[] args) {
		Properties properties = System.getProperties();

		for (Object name : properties.keySet()) {
			System.out.println(name + " = " + properties.getProperty("name"));

		}
		}

	}
