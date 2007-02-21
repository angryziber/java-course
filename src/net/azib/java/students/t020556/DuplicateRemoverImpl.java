package net.azib.java.students.t020556;

import net.azib.java.collections.DuplicateRemover;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.sun.xml.internal.stream.Entity;
import com.sun.xml.internal.ws.wsdl.parser.Message;

/**
 * DuplicateRemoverImpl implements DuplicateRemover
 *
 * @author t020556
 * 
 */
public class DuplicateRemoverImpl implements DuplicateRemover {

	/**
	 * @param array
	 * 
	 */

	@Override
	public String[] removeDuplicateStrings(String[] array) {
		Set<String> set = new LinkedHashSet<String>(Arrays.asList(array));
		return set.toArray(new String[set.size()]);
	}

}
