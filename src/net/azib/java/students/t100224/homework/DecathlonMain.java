package net.azib.java.students.t100224.homework;

import net.azib.java.students.t100224.homework.controller.DecathlonController;

import java.io.IOException;

public class DecathlonMain {
	public static void main(String[] args) throws IOException {

		if (args.length > 0)
			new DecathlonController(args);
		else
			System.err
					.println("Usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
	}
}
