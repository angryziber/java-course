package net.azib.java.students.t030656;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SetLearning
 *
 * @author t030656
 */
public class CollectionLearning {
	public static void main(String[] args){
		List c = new ArrayList(Arrays.asList(new String[] {"a", "b", "z", "x", "z"}));
		
		c.add("m");
		
		System.out.println(c.lastIndexOf("z"));
		for(Object e: c){
			System.out.println(e);
		}
		
		Map<String, String> map = new HashMap(System.getProperties());
		
		for(Map.Entry<String, String> me: map.entrySet()){
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
}
