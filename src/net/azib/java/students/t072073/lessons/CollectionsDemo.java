package net.azib.java.students.t072073.lessons;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * CollectionsDemo
 *
 * @author janika
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		Collection c = Arrays.asList("a", "b", "c");
		c.add("d");
		System.out.println(c.contains("b"));
		
		List l = (List) c;
		
		Map p = new Properties();
		p.put("a", "b");

	}

}
