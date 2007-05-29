package net.azib.java.students.t030630;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Serialization
 *
 * @author Kasutaja
 */
public class Serialization {

	public static class Dog implements Serializable {
		private static final long serialVersionID = 1L;
		private  String name = "Buggy";
		
//		@Override
//		public clone 
		
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("sajosafkdfjad");
		out.writeObject(new Dog());
		out.flush();
		
		byte[] buffer = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		Dog dog = (Dog) in.readObject();
		System.out.println(dog.name);
	}

}
