package net.azib.java.lessons.io;

import java.io.*;
import java.util.Arrays;

public class BinaryDemo {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);

		dataOut.writeFloat(0.1f);
		dataOut.writeInt(5);
		dataOut.writeUTF("Hello");
		dataOut.flush();

		byte[] bytes = out.toByteArray();
		System.out.println(Arrays.toString(bytes));

		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		DataInputStream dataIn = new DataInputStream(in);
		System.out.println(dataIn.readFloat());
		System.out.println(dataIn.readInt());
		System.out.println(dataIn.readUTF());
	}
}
