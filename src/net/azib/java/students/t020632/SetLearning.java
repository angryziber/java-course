package net.azib.java.students.t020632;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SetLearning
 *
 * @author t020632
 */
public class SetLearning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List c = new ArrayList(Arrays.asList(new String [] {"a", "b", "z", "c", "z"}));
		c.add("w");
		
		System.out.println(c.lastIndexOf("z"));
		
		for(Object o : c){
			System.out.println(o);
		}
		
		Map<String, String> map = new HashMap(System.getProperties());
		
		for(Map.Entry<String, String> me : map.entrySet()){
			System.out.println(me.getKey() + " = " + me.getValue());
		}
		

	}

}
