package net.azib.java.students.t050657;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SetLearning
 *
 * @author t050657
 */
public class CollectionLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> collection = new ArrayList<String>(Arrays.asList(new String[] {"a", "b", "z", "x", "z"}));
		
		collection.add("a");
		
		
		/*
		collection.add("a");
		collection.add("b");
		collection.add("z");
		collection.add("x");
		collection.add("z");
		
		
		for(Object a : collection ) {
			System.out.println(a);
		}
		
		System.out.println(collection.lastIndexOf("z"));
		*/
		
		Map<String, String> map = new HashMap(System.getProperties());
		for(Map.Entry<String, String> me : map.entrySet()) {
			System.out.println(me.getKey() + " = " + me.getValue());
		}
	}
}
