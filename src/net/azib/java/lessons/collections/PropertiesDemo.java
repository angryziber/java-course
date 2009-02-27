package net.azib.java.lessons.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesDemo
 *
 * @author anton
 */
public class PropertiesDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = System.getProperties();
		for (Object name : props.keySet()) {
			System.out.println(name + "=" + props.get((String)name));
		}
		
		String filename = props.getProperty("java.io.tmpdir") + File.separator + "props.properties";
		props.store(new FileOutputStream(filename), "System properties");
		System.out.println(System.getProperty("abc"));
	}
}
