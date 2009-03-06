package net.azib.java.lessons.collections;

import java.util.Map;

/**
 * MapDemo
 *
 * @author anton
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<Object, Object> m = System.getProperties();
		for (Map.Entry<Object, Object> e : m.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getKey());
		}
	}
}
