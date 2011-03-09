package net.azib.java.students.t104922.Lesson4;

import java.util.Properties;

public class SystemPropDemo {
    public static void main(String[] args) {
        Properties properties = System.getProperties();

		StringBuilder sb = new StringBuilder("\n\nPROPERTIES:\n");
		for (Object name : properties.keySet()) {
			sb.append(name).append(" = ").append(properties.get(name)).append("\n");
		}
		System.out.println(sb.toString());
    }
}
