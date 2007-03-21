package net.azib.java.students.t030656;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * Serialization
 *
 * @author t030656
 */
public class Serialization {
	public static class Dog implements Serializable, Cloneable{
		/** serialVersionUID */
		private static final long serialVersionUID = 1L;
		
		private String name = "Buddy";

		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		
		@Override
		protected Dog clone() throws CloneNotSupportedException {
			
			Dog dog = (Dog) super.clone();
			name= dog.name;
			return dog;
		}
		

		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		Dog dog = new Dog();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("abcdefghaijklmnoprstuv");
		out.writeObject(new Dog());
		out.flush();
		
		byte[] buffer = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		Dog copy = (Dog) in.readObject();
		System.out.println(copy.name);
		
		Dog clone = (Dog) dog.clone();
		
		System.out.println(copy.name == clone.name);
	}
}
