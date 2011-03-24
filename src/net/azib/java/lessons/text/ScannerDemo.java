package net.azib.java.lessons.text;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\n");

		System.out.println("Please enter your name:");
		String name = scanner.next("[A-Z][a-z]+\\s[A-Z][a-z]+");
		System.out.println("Hello, " + name);
		System.out.println("Please enter your age:");
		int age = scanner.nextInt();
		System.out.println(name + ", " + age + " years old");
	}
}
