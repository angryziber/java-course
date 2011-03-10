package net.azib.java.students.t103717;

import java.util.HashMap;
import java.util.Map;

/**
 * User: ruzard
 * Malyshev Konstantin 103717IAPB28
 * Date: 10.03.11
 */
public class WordCounter {
	public static void main(String[] args) {
		String textt = "Hello hello world world Param Param Param pam";
		Map<String, Integer> map;
		map = calculateFrequenciesOf(textt);
		System.out.println(map);

	}

	private static Map<String, Integer> calculateFrequenciesOf(String text) {
		String[] arrayString = text.split(" ");
		Map<String, Integer> map;
		map = new HashMap<String, Integer>();


		for (int i = 0; i < arrayString.length; i++) {
			Integer count = map.get(arrayString[i]);
			map.put(arrayString[i], (count == null) ? 1 : count + 1); //if Count = null then put 1, else put count + 1
		}
		map.get(text);
		//	System.out.print(map);

		return map;
	}
}
