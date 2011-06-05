package net.azib.java.students.t093759.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Helper class for parsing CLI params.
 *
 * @author dionis
 *         6/5/11 3:59 AM
 */
public class ParamsParser {
	/**
	 * Get unmodifiable list of keys.
	 * @return
	 */
	public List<String> getKeys() {
		return Collections.unmodifiableList(keys);
	}

	/**
	 * Get unmodifiable list of values.
	 * @return
	 */
	public List<List<String>> getValues() {
		return Collections.unmodifiableList(values);
	}

	List<String> keys = new ArrayList<String>();
	List<List<String>> values = new ArrayList<List<String>>();

	/**
	 * Parse params from given string and return map with key-values pairs.
	 *
	 * @param params Params to parse from.
	 */
	public ParamsParser(String... params) {
		if (params.length == 0) return;
		int lastKeyIndex = -1;
		for (String param : params) {
			if (param.startsWith("-")) {
				keys.add(param);
				values.add(new ArrayList<String>());
				lastKeyIndex++;
			} else {
				if (lastKeyIndex != -1) {
					values.get(lastKeyIndex).add(param);
				}
			}
		}
	}
}
