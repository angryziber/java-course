package net.azib.java.lessons.text;

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
 * @author anton
 */
public class Serialization {
	
	public static class Dog implements Serializable, Cloneable {
		/** serialVersionUID */
		private static final long serialVersionUID = 1L;
		
		private String name = "Buggy";

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("asjdhaskd");
		Dog dog = new Dog();
		out.writeObject(dog);
		out.flush();
		
		byte[] buffer = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		
		Dog copy = (Dog) in.readObject();
		
		Dog clone = (Dog) dog.clone();
	}

}
