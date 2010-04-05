package net.azib.java.lessons.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * BinaryDataDemo
 *
 * @author anton
 */
public class BinaryDataDemo {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		dataOut.writeInt(1);
		dataOut.writeFloat(0.1f);
		dataOut.writeUTF("abc");
		
		System.out.println(Arrays.toString(out.toByteArray()));
		
		DataInputStream dataInput = new DataInputStream(new ByteArrayInputStream(out.toByteArray()));
		System.out.println(dataInput.readInt());
		System.out.println(dataInput.readFloat());
		System.out.println(dataInput.readUTF());
	}
}
