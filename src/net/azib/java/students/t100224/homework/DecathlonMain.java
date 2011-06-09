package net.azib.java.students.t100224.homework;

import net.azib.java.students.t100224.homework.controller.DecathlonController;
import org.apache.log4j.xml.DOMConfigurator;

public class DecathlonMain {

	public static void main(String[] args) {
		if (args.length < 2) {
			System.err
					.println("Usage: <program> -<input-method> [input-parameters] -<output-method> [output-parameters]");
		} else {
			DOMConfigurator.configure("./src/net/azib/java/students/t100224/homework/log4j.xml");
			DecathlonController c = new DecathlonController(args);
			c.getDecathlonResults();
		}


	}

}
