package net.azib.java.students.t030675;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//*Set - ei saa olla 2 samasugust elementi, contains() naibolee bistrij v etom interface
//dlja proverki est taoj element uzhe ili net

//*SortedSet - vse elementi otsortirovani po vozrastaniju
//*HashSet - naibolee bistrij iz Collections, ispolzuet HashCode
//besporjadochno nahodjatsja, ne otsortirovani, t.k. po HashCode smotrjatsja
//*TreeSet - red-black tree, elem. peavad olema Comparable voi vaja luua Comporator, 
//mis oskab neid elemente vorrelda
//LinkedHashSet - tozhe samoe sto i HashSet, no vozvrashajutsja elementi v porjadke vvoda
//EnumSet - Set, sostojashij iz Enum
//equals - vordsed siis kui samad elem, jarjekord pole oluline
//======================

//*List
//iterator molemas suunas
//subList() - vozvrashaet kusok iz Lista, ne kopiruja elementi (ssilka)
//equals - vordsed siis kui samad elem ja samas jarjekorras

//*ArrayList
//insert - on vaga aeglane, kuna peab otsima oige koha uuele elemendile
//*LinkedList (implementeerib ka Queue lisaks Listile)
//indeksi jargi otsimine - aeglane
//insert - kiire
//======================

//*Queue
//offer() - lisab uue elem., kui ei lisa, siis tagastab false; add() viskab valja Exception
//======================

//*Map
// put(key,value),get(key)
//containsKey() - kiire
//containsValue() - aeglane
//entrySet() - key+value => Map.Entry
//*HashMap
//*TreeMap
//*LinkedHashMap
//*EnumMap
//*IdentityHashMap
//*WeakHashMap - hea cache jaoks, garbagecollector automaatselt kustutab mittekasutavaid

/*
 * Vector => ArrayList
 * Enumeration => iterator
 * Stack => LinkedList
 * HashTable => HashMap
 * BitSet => EnumSet ???
*/

/*
 * *Arrays()
 * 		sort() - horoshij sort
 * *Collections()
 * */
/**
 * SetLearning
 *
 * @author t030675
 */
public class CollectionLearning {
	
	public static void main(String[] args) {
//		Set set = new TreeSet();
//		set.add("a");
//		set.add("z");
//		set.add("b");
//		set.add("x");
//		set.add("z");
//		
//		for(Object e:set){
//			System.out.println(e);
//		}
	
		
//		Collection c = new LinkedList();
		//Collection c = Arrays.asList(new String[] {"a","z","b","x","z"});
		
		//et oleks voimalik lisada add() meetodiga:
		
//		List<String> c = new ArrayList(Arrays.asList(new String[] {"a","z","b","x","z"}));
//		
//		c.add("m");
//		
//		System.out.println(c.lastIndexOf("z"));
//		
//		for(Object e:c){
//			System.out.println(e);
//		}
		
		
		Map<String,String> map = new HashMap(System.getProperties());
		
		for(Map.Entry<String, String> me : map.entrySet()){
			System.out.println(me.getKey() + "=" + me.getValue());
		}
		
	}

}
