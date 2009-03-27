package net.azib.java.lessons.io;

import net.azib.java.lessons.basic.Dog;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 * BinaryDemo
 *
 * @author anton
 */
public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream dataOut = new ObjectOutputStream(baos);
		dataOut.writeObject(new Dog("Juku", 1));
		
		byte[] data = baos.toByteArray();
		System.out.println(Arrays.toString(data));
		
		ObjectInputStream dataIn = new ObjectInputStream(new ByteArrayInputStream(data));
		System.out.println("Object: " + dataIn.readObject());
	}
}
