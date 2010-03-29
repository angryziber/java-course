package net.azib.java.lessons.text;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ScannerDemo
 *
 * @author anton
 */
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your age:");
		int age = scanner.nextInt();
		System.out.println("Age: " + age);
		System.out.println("Please enter your email:");
		Pattern emailPattern = Pattern.compile("[a-z0-9_A-Z.]+@[-a-zA-Z0-9.]+\\.[a-zA-Z]{2,4}");
		String email = scanner.next(emailPattern);
		System.out.println("Email: " + email);
	}
}
