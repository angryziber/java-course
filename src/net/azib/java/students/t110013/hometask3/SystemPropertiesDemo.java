package net.azib.java.students.t110013.hometask3;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Vadim
 * Date: 6.03.11
 * Time: 12:21
 */
public class SystemPropertiesDemo {
	public static void main(String[] args) {
		System.out.println("Running on " + System.getProperty("os.name") + " " + System.getProperty("os.arch"));
		System.out.println(System.getProperty("java.runtime.name") + " " + System.getProperty("java.runtime.version"));

		Properties properties = System.getProperties();
		StringBuilder sb = new StringBuilder("\n\nALL OTHER PROPERTIES:\n");
		for (Object name : properties.keySet()) {
			sb.append(name).append(" = ").append(properties.get(name)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
