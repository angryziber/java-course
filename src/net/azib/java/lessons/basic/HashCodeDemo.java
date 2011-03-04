package net.azib.java.lessons.basic;

import java.util.HashSet;

public class HashCodeDemo {

	public static class Foo {
		@Override
		public boolean equals(Object obj) {
			return true;
		}

		@Override
		public int hashCode() {
			return 1;
		}
	}

	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());

		HashSet set = new HashSet();
		Foo foo = new Foo();
		set.add(o1);
		set.add(foo);
		System.out.println(foo.hashCode());
		System.out.println(set.contains(o1));
		System.out.println(set.contains(foo));
	}
}
