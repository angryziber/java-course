package net.azib.java.students.t970880.homework;
import java.util.*;

interface Keyed {
	Object getKey();
}

// new Object() {
// 	public @Key String part1 = "name1";
// 	public @Key int part2 = 1;
// }

/**A set, that allows to retreive objects by key similarily to DB table.
 TODO A better idea would be to exploit the marker annotation on key fields.
*/

class Table<E extends Keyed> extends AbstractSet<E> {
	
	// The map is redundant solution for the table because it keeps the key
	// fields of the object in duplicate locations: key and value. In fact, this
	// is a motive for creating a new class.
	final Map<Object, E> underlying = new HashMap<Object, E>(); 

	public Table(Collection<E> c) {
		Iterator<E> i = c.iterator();
		while (i.hasNext())
			add(i.next());
	}
	
	public boolean add(E e) {
		return put(e) != null;
	}

	public E put(E e) {
		return underlying.put(e.getKey(), e);
	}

	public int size() {
		return underlying.size();
	}
	
	public Iterator<E> iterator() {return underlying.values().iterator();}
	
	public boolean contains(Object key) {
		return underlying.containsKey(key);
	}
	
	public E get(Object key) {
		return underlying.get(key);
	}
}