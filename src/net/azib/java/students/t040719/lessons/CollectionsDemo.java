package net.azib.java.students.t040719.lessons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet; // mingis järjekorras
import java.util.LinkedHashSet; //samas järjekorras
import java.util.LinkedList; 
import java.util.List;
import java.util.TreeSet; //võrdleb stringe ja paneb väikseimast suuremani


/**
 * CollectionsDemo
 *
 * @author t040719
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		Collection c = new LinkedHashSet();
		c.add("asd");
		c.add("123");
		c.add("756");
		c.add("000");
		
		//c.add(1,"adasd");
		
		//teeb listi immutableks, ehk ple võimalik enam muuta
		c = Collections.unmodifiableCollection(c); 
		
		System.out.println(c.size());
		for (Object o : c){
			System.out.println(o);
		}
	
	}
}
