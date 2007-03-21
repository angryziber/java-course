package net.azib.java.students.t030636.v_05;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization
 *
 * @author Martin
 */
public class Serialization {
	
	public static class Dog implements Serializable {
		/** serialVersionUID */
		private static final long serialVersionUID = 1L;
		private transient String name = "Buggy";
		
		@Override
		public Dog clone() throws CloneNotSupportedException {
			return (Dog) super.clone();
		}
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos); 
		out.writeUTF("ashajaskl");
		out.writeObject(new Dog());
		out.flush();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		Dog dog = (Dog) in.readObject();
		System.out.println(dog.name);
		
		Dog clone = dog.clone();
	}

}
