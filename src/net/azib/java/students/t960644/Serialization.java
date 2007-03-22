package net.azib.java.students.t960644;

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
 * @author Lembit
 */
public class Serialization {

	public static class Dog implements Serializable, Cloneable {
		/** serialVersionUID */
		private static final long serialVersionUID = 1;
		private transient String name = "Nupi";
		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}
		
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("agJHDGD");
		Dog dog = new Dog();
		out.writeObject(dog);
		out.flush();
//		System.out.println(new String(baos.toByteArray()));
		byte[] buffer = baos.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		Dog copy = (Dog) in.readObject();
		System.out.println(copy.name);
		
		Dog clone = (Dog) dog.clone();
		System.out.println(dog.name == copy.name);
		System.out.println(dog.name == clone.name);
	}

}
