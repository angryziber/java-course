package net.azib.java.students.t104950;
          import java.util.HashMap;
          import java.util.Hashtable;
          import java.util.Map;
		  import java.util.Set;
		  import  java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: Mii
 * Date: 24.03.11
 * Time: 10:04
 * To change this template use File | Settings | File Templates.
 */
public class WordFrecuencyCalculator {
	public static Map<String, Integer> calculateFrequency(String text)  {
		String [] words=text.split("\\s");
		//System.out.println(words.length);

		Map <String,Integer>map = new HashMap <String, Integer>();


	for (String a :words)
		{
			if (map.containsKey(a))
			{
				int count = map.get(a);//current count
				map.put(a,count+1); // increment count
			}
			else map.put(a,1);//new word with count one
		}

		return map;
	}

	public static void main(String[] args) {
		String text="mMingi sisestatud test tekst et test kontroll et et";
		Map<String, Integer> Sorteerimiseks;//<Key, value>
		Sorteerimiseks=calculateFrequency(text);
		Set< String > keys = Sorteerimiseks.keySet(); // get keys
		TreeSet< String > sortedKeys = new TreeSet< String >( keys );  // sort keys

		for ( String key : sortedKeys )
           System.out.printf("%-10s%10s\n", key, Sorteerimiseks.get(key));



	}
}
