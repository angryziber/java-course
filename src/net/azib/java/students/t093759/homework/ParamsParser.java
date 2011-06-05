package net.azib.java.students.t093759.homework;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for parsing params.
 *
 * @author dionis
 *         6/5/11 3:59 AM
 */
public class ParamsParser {
	private static ParamsParser instance;

	private ParamsParser() {
	}

	public static ParamsParser getInstance() {
		if (instance == null) {
			instance = new ParamsParser();
		}
		return instance;
	}

	/**
	 * Parse params from given string and return map with key-values pairs.
	 *
	 * @param params Params to parse from.
	 * @return Map with string as a key ('-' sign is kept) and values (String-list).
	 */
	public Map<String, List<String>> parse(String... params) {
		Map<String, List<String>> results = new LinkedHashMap<String, List<String>>();
		if (params.length == 0) return results;
		String lastKey = null;
		for (String param : params) {
			if (param.startsWith("-")) {
				if (!results.containsKey(param)) {
					results.put(param, new ArrayList<String>());
				}
				lastKey = param;
			} else {
				if (lastKey != null) {
					results.get(lastKey).add(param);
				}
			}
		}
		return results;
	}
}
