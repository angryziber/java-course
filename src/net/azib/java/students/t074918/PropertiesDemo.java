package net.azib.java.students.t074918;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author Mart Mangus
 */
public class PropertiesDemo {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p = System.getProperties();
		for (Object name : p.keySet()) {
			System.out.println(name + " = " + p.getProperty((String) name));
		}
		
		// Üksik propery kiiremini...
		System.out.println(System.getProperty("os.name"));
		
		String filename = System.getProperty("java.io.tmpdir") + File.separator + "test.properties";
		p.store(new FileOutputStream(filename), "System properties test");
	}

}
