package net.azib.java.lessons.basic;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ScannerDemo
 *
 * @author anton
 */
public class ScannerDemo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String email = null;
		email = ask(s, "Please enter an email address:", "[a-zA-Z.]+@[a-zA-Z.]+.ee");
		
		System.out.println("You entered: " + email);
	}

	private static String ask(Scanner s, String message, String pattern) {
		String response = null;
		while (true) {
			try {
				System.out.print(message);
				response = s.next(pattern);
				break;
			}
			catch (InputMismatchException e) {
				// ask again
				System.out.println("Wrong format");
				s.next();
			}
		}
		return response;
	}
}
