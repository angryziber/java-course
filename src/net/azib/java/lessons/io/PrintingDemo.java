package net.azib.java.lessons.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * PrintingDemo
 *
 * @author anton
 */
public class PrintingDemo {
	public static void main(String[] args) throws IOException {
		Writer writer = new StringWriter(1000);
		writer.write("Hello");
		
		PrintWriter printer = new PrintWriter(writer, false);
		printer.print(' ');
		printer.print("World");
		printer.flush();
		
		System.out.println(writer.toString());
	}
}
