package net.azib.java.lessons.io;

import java.io.PrintStream;

public class Printer {
	PrintStream out = System.out;

	public void printSomething() {
		out.println("Hello");
	}
}
