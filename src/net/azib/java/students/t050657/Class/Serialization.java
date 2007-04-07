package net.azib.java.students.t050657.Class;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization
 *
 * @author t050657
 */
public class Serialization {

	public static class Dog implements Serializable{
		/** serialVersionUID */
		private static final long serialVersionUID = 1L;
		
		private String name = "Booggy";
	}
	
	
	public static void main(String[] args) throws IOException, 
						ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeChars("dsfgsdfgsdfg");
		out.writeObject(new Dog());
		out.flush();
		//System.out.println(new String(baos.toByteArray()));
		
		byte[] buffer = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream ois = new ObjectInputStream(bais);
		
		//System.out.println(ois.readUTF());
		
		Dog dog = (Dog)ois.readObject();
		
		System.out.println(dog.name);

	}
}
