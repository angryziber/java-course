package net.azib.java.lessons.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * BinaryDemo
 *
 * @author anton
 */
public class BinaryDemo {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(baos);
		dataOut.writeInt(10);
		dataOut.writeUTF("Hello");
		
		byte[] data = baos.toByteArray();
		System.out.println(Arrays.toString(data));
		
		DataInputStream dataIn = new DataInputStream(new ByteArrayInputStream(data));
		System.out.println("Int: " + dataIn.readInt());
		System.out.println("String: " + dataIn.readUTF());
	}
}
