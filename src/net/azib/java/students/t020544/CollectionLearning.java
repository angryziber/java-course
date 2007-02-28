package net.azib.java.students.t020544;

import java.util.*;

/**
 * SetLearning
 * 
 * @author Julija Kondratjeva
 */
public class CollectionLearning {

	public static void main(String[] args) {
		// Set set = new HashSet();
		// Set set = new LinkedHashSet();
		// Set set = new TreeSet();

		// List c = new ArrayList();
		// List c = new LinkedList();
		// c.add("a");
		// c.add("b");
		// c.add("z");
		// c.add("c");
		// c.add("z");

		List <String>c = new ArrayList(Arrays.asList(new String[] { "a", "b", "z", "c", "z" }));
		c.add("m");
		
		System.out.println(c.indexOf("z"));

		for (Object e : c) {
			System.out.println(e);
		}
		
		Map<String, String> map = new HashMap(System.getProperties());
		for (Map.Entry<String, String> me:map.entrySet()){
			System.out.println(me.getKey()+"="+me.getValue());
		}
	}

}
