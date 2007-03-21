package net.azib.java.students.t020632;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Seralization
 *
 * @author t020632
 */
public class Seralization {

	
	public static class Dog implements Serializable, Cloneable{
		
		private static final long serialVersionUID = 1l;
		private transient String name = "Buggy";
		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		
		@Override
		protected Dog clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			Dog dog = (Dog) super.clone();
			name = dog.name;
			
			return dog;
		}
		
	}
	
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeUTF("sgaff");
		Dog dog = new Dog();
		out.writeObject(dog);
		out.flush();
		
		//System.out.println(new String(baos.toByteArray()));
		byte [] buffer = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.readUTF());
		
		Dog copy = (Dog) in.readObject();
		System.out.println(copy.name);
		
		System.out.println(dog.name == copy.name);

	}

}
