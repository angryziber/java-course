package net.azib.java.lessons.collections;

/**
 * An interface for a task in the 4th lesson for practicing with Set.
 *  
 * @author anton
 */
public interface DuplicateRemover {
	
	/**
	 * Removes all duplicate elements from an array of Strings.
	 * 
	 * @param array
	 * @return an array of Strings, where each String appears only once. 
	 * The Strings have the same order as in the source array.
	 */
	public String[] removeDuplicateStrings(String ... array);

}
