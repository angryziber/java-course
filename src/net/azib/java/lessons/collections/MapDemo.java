package net.azib.java.lessons.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "b");
		map.put("c", "d");
		for (String key : map.keySet()) {
			System.out.println(key + "=" + map.get(key));
		}
		for (Map.Entry<String, String> e : map.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}
}
