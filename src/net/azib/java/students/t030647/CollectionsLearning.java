package net.azib.java.students.t030647;

import java.util.HashMap;
import java.util.Map;

/**
 * CollectionsLearning
 *
 * @author t030647
 */
public class CollectionsLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap(System.getProperties());
		for (Map.Entry<String, String> me : map.entrySet()) {
			System.out.println(me.getKey() + " = "+ me.getValue());
		}
		
	}

}
