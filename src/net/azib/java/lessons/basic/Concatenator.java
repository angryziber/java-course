package net.azib.java.lessons.basic;

public class Concatenator {
	public String concat(String a, String b) {
		return (a == null ? "" : a) + (b == null ? "" : b);
	}
}
