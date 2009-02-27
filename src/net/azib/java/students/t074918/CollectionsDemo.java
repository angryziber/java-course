package net.azib.java.students.t074918;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * CollectionsDemo
 *
 * @author matikati
 */
public class CollectionsDemo {
	
	public static void main(String[] args) {
		
		/**
		 * 	.size()
		 *  .isEmpty()
		 *  
		 * Set -- nagu matemaatiline hulk, ühte objekti ei saa topelt olla, interatsiooni järjekord ~random
		 * 	.contains()
		 * SortedSet + first(), last()...
		 * 
		 * 		HashSet -- hash koodide baasil, otsimine väga kiire
		 * 		TreeSet -- lisamine väga kiire
		 * 		LinkedHashSet --HashSet + elementide järjekord 		
		 * 
		 * List -- elementide järjekorda ei saa muuta...
		 * 	.get() .set() .indexOf() .lastIndexOf()
		 * 
		 * 		ArrayList -- muutuva suurusega array
		 * 			Otsimine kiire, lisamine/kustutamine kallis
		 * 		LinkedList -- lisamine/kustutamine kiirem
		 * 			Indeksi põhine otsing aga aeglane!
		 * 			.addFirst() .getFirst() .removeFirst()
		 * 
		 * Map -- key => value paarid...
		 * 		Collection views: keySet() values() entrySet()
		 * 	.put() .get() .remove() 
		 * 	.containsKey()
		 * 	.containsValue()
		 *  
		 * Queue -- FIFO or LIFO...
		 * 
		 * 		PriorityQueue...
		 *   
		 *  Interable interface -- saab foreach-iga läbi käia
		 *  
		 */
		
//		c.add("f");
//		System.out.println(c.contains("b"));
//		
//		Map m = new Properties();
//		m.put("key", "value");
		
		System.out.println(System.getProperty("line.separator") + "SETID...");
		
		Set s1 = new HashSet();
		Set s2 = new TreeSet();
		Set s3 = new LinkedHashSet();
		
		fill(s1);
		print(s1);
		fill(s2);
		print(s2);
		fill(s3);
		print(s3);
		
		System.out.println(System.getProperty("line.separator") + "LISTID...");
		
		List l1 = new ArrayList();
		List l2 = new LinkedList();
		
		fill(l1);
		print(l1);
		fill(l2);
		print(l2);
	}
	
	private static void fill(Collection s)
	{
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("e");
		s.add("f");
		s.add("g");
		s.add("g");
		s.add("a");
	}
	
	private static void print(Collection s)
	{
		System.out.println("size: " + s.size());
		System.out.println(s.getClass().getSimpleName() + ": " + s);
	}

}
