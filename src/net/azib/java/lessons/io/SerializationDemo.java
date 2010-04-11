package net.azib.java.lessons.io;

import net.azib.java.lessons.basic.Dog;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import org.apache.commons.io.IOUtils;

/**
 * SerializationDemo
 *
 * @author anton
 */
public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog dog = new Dog("Muku", 12);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		objectOut.writeObject(dog);
		
		System.out.println(Arrays.toString(out.toByteArray()));
		System.out.println(new String(out.toByteArray()).replace('\u0000', ' '));
		
		//IOUtils.write(out.toByteArray(), new FileOutputStream("dog.dat"));
		ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("dog.dat"));
		Dog dog2 = (Dog) objectInput.readObject();
		
		System.out.println(dog);
		System.out.println(dog == dog2);
		System.out.println(dog.equals(dog2));
	}
}
