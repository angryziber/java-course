package net.azib.java.students.t040719.lessons;

import java.util.Map;
/**
 * LessonThree
 *
 * @author Administrator
 */
public class LessonThree {
	public static void main(String[] args) {
		DuplicateRemoverImpl test = new DuplicateRemoverImpl();
		String[] arr = new String[] {"asd","asd","afsfd","akllkk","asd","alak"};
		System.out.println("Enne:");
		for(String str : arr){
			System.out.println(str);
		}
		System.out.println("\nPärast:");
		arr = test.removeDuplicateStrings(arr);
		for(String str : arr){
			System.out.println(str);
		}
		System.out.println("");
		Map<String,Integer> map = WordFrequencyCalculator.calculateFrequenciesOf("how many times is ten times ten");
		for(Map.Entry e : map.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
}
