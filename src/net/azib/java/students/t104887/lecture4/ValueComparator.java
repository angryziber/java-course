package net.azib.java.students.t104887.lecture4;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: BJU
 * Date: 5.04.11
 * Time: 23:55
 * To change this template use File | Settings | File Templates.
 */
public class ValueComparator implements Comparator {

	Map base;
	int comparedValue;

	public ValueComparator(Map base) {
		this.base = base;
	}

	public int compare(Object a, Object b) {
		return ((Integer) base.get(a)).compareTo(((Integer) base.get(b)));
	}
}
