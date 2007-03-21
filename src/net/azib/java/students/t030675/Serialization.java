package net.azib.java.students.t030675;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialization
 *
 * @author t030675
 */
public class Serialization {

	public static class Dog implements Serializable,Cloneable{
		/** serialVersionUID */
		private static final long serialVersionUID = 1L;
		
		private String name = "Pjos";
		
		@Override
		protected Object clone() throws CloneNotSupportedException {
			return super.clone();
//			Dog dog = (Dog) super.clone();
//			name = dog.name;
//			return dog;
		}
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("fsdgf");
		Dog dog = new Dog();
		out.writeObject(new Dog());
		out.flush();
		
		byte[] buffer = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		
		System.out.println(dog.name);
		
		Dog copy = (Dog) in.readObject();
		Dog clone = (Dog) dog.clone();
		
		System.out.println(dog.name == clone.name);
	}
	
}
