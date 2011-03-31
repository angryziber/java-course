package net.azib.java.lessons.io;

import net.azib.java.lessons.basic.Dog;

import java.io.*;
import java.util.Arrays;

public class SerializationDemo {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(out);

		objectOut.writeObject(new Dog("Pluto"));
		objectOut.flush();

		byte[] bytes = out.toByteArray();
		System.out.println(Arrays.toString(bytes));
		System.out.println(new String(bytes));

		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream objectIn = new ObjectInputStream(in);
		Object date = objectIn.readObject();
		System.out.println(date);
	}
}
