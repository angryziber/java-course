package net.azib.java.students.t020544;

import java.io.*;

/**
 * Serialization
 * 
 * @author Julija
 */
public class Serialization {

	/**
	 * @param args
	 */

	public static class Dog implements Serializable {
		/** serialVersionUID */
		private static final long serialVersionUID = 1L;
		private String name = "Buggy";
		
		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		public Object clone() throws CloneNotSupportedException {			
			return super.clone();
		}		
		
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("dasd");
		out.writeObject(new Dog());
		out.flush();
		
		byte[] buffer = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		Dog dog = (Dog) in.readObject();
		System.out.println(dog.name);
		
		Dog copy = (Dog) in.readObject();
		
		Dog clone = (Dog) dog.clone();

	}
	
	
}
