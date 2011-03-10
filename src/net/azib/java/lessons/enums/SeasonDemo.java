package net.azib.java.lessons.enums;

public class SeasonDemo {
	public static void main(String[] args) {
		Season season = Season.SPRING;
		System.out.println(season + ": " + season.ordinal());
		System.out.println(season.next());
		System.out.println(season.next().next());
		System.out.println(season.next().next().next());
	}
}
