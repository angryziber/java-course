package net.azib.java.lessons.io;

import java.util.Scanner;

/**
 * ScannerDemo
 *
 * @author anton
 */
public class NameReader {
	private Scanner scanner;
	
	public NameReader() {
		scanner = new Scanner(System.in);
	}
	
	NameReader(Scanner scanner) {
		this.scanner = scanner;
	}

	public String readName() {
		return scanner.next();
	}
}
