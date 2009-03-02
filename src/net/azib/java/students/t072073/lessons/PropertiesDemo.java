package net.azib.java.students.t072073.lessons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Properties
 *
 * @author janika
 */
public class PropertiesDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		Properties props = System.getProperties();
		for(Object name : props.keySet()){
			System.out.println(name + "=" + props.getProperty((String) name));
		}
		String filename = System.getProperty("java.io.tmpdir") + File.separator + "props.properties";
		props.store(new FileOutputStream(filename), "System properties");
		System.out.println(System.getProperty("os.name"));	
	}

}
