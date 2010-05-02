package net.azib.java.lessons.patterns;

import java.util.Arrays;

/**
 * StrategyDemo
 *
 * @author anton
 */
public class StrategyDemo {
	public static interface SortingStrategy {
		void sort(Object[] something);
	}
	
	public static class BubbleSortStrategy implements SortingStrategy {
		public void sort(Object[] something) {
			// implement bubble sort here
		}
	}
	
	public static class MergeSortStrategy implements SortingStrategy {
		public void sort(Object[] something) {
			Arrays.sort(something);
		}
	}

	public static void main(String[] args) {
		Object[] array = new String[] {"c", "a", "b"};
		handleArray(array, new MergeSortStrategy());
		System.out.println(Arrays.toString(array));
	}

	/**
	 * @param array
	 */
	private static void handleArray(Object[] array, SortingStrategy sorter) {
		// do something with array here
		
		// sort
		sorter.sort(array);
		
		// do something more
	}
}
