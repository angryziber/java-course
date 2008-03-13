package net.azib.java.students.t654321.hometasks;

import net.azib.java.lessons.collections.WordFrequencyCalculator;
import java.util.Map;
import java.util.TreeMap;

/**
 * WordFrequencyCalculator
 *
 * @author Karl
 */
public class WordFrequencyCalculatorImpl implements WordFrequencyCalculator {

	private Integer ONE = new Integer("1");
	private Map<String, Integer> map = new TreeMap<String, Integer>();
	
	public Map<String, Integer> calculateFrequenciesOf(String text) {
		String[] originalStringToArray = text.split("\\s");
//		Arrays.sort(originalStringToArray);
		for (int i = 0; i < originalStringToArray.length; i++) {
	        if (originalStringToArray[i].length() > 0) {
	            Integer frequency = (Integer) map.get(originalStringToArray[i]);
	            if (frequency == null) {
	            	frequency = ONE;
	            } else {
	            	int value = frequency.intValue();
	            	frequency = new Integer(value + 1);
	            }
	            map.put(originalStringToArray[i], frequency);
	        } else {
	        	return null;
	        }
		}
		return map;
	}
}
