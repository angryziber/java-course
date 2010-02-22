package net.azib.java.students.t073862.third;

import java.util.Map;
import java.util.Map.Entry;

/**
 * ThirdHomeworkDemo
 *
 * @author Pets
 */
public class ThirdHomeworkDemo {
	public static void main(String[] args) {
		new ThirdHomeworkDemo().start();
	}

	private void start() {
		
		ThirdHomework t = new ThirdHomework();
		System.out.println("------------------WORD-FREQUENCY--------------------");
		Map<?, ?> map = t.calculateFrequenciesOf("a a a b d");
		for(Entry<?, ?> e : map.entrySet()) {
			System.out.println(e.toString());
		}
		System.out.println("----------------DUPLICATE-REMOVER--------------------");
		String[] data = t.removeDuplicateStrings(new String[]{"a","a","b"});
		for(String s : data) {
			System.out.println(s);
		}
	}
}
