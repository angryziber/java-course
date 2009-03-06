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
		 * 		HashMap -- võti vaid korra
		 * 		LinkedHashMap -- järjekorraga HashMap
		 * 		TreeMap -- järjestatud
		 * 		IdentityHashMap -- sama equals()-iga objekte võib hoida...
		 * 		WeakHashMap -- objektid kaovad ise mingi spets värk :D
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
		
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new TreeSet<String>();
		Set<String> s3 = new LinkedHashSet<String>();
		
		fill(s1);
		print(s1);
		fill(s2);
		print(s2);
		fill(s3);
		print(s3);
		
		System.out.println(System.getProperty("line.separator") + "LISTID...");
		
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new LinkedList<String>();
		
		fill(l1);
		print(l1);
		fill(l2);
		print(l2);
		
		for (String s : l2) {
			System.out.print(s);
		}
	}
	
	private static void fill(Collection<String> s)
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
	
	private static void print(Collection<String> s)
	{
		System.out.println("size: " + s.size());
		System.out.println(s.getClass().getSimpleName() + ": " + s);
	}

}
