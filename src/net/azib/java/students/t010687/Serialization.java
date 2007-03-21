package net.azib.java.students.t010687;

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
 * @author t010687
 */
public class Serialization {

	/**
	 * @param args
	 */
	public static class Dogx implements Serializable, Cloneable  {
		///** serialVersionUID */
		private static final long serialVersionUID = 1L;
		private String name = "MinuNunnu";
		/* (non-Javadoc)
		 * @see java.lang.Object#clone()
		 */
		@Override
		public Dogx clone() throws CloneNotSupportedException {
			return (Dogx)super.clone();
		}

		
	}
	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(new Dogx());
		out.flush();
		//System.out.println(new String(baos.toByteArray()));
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream in = new ObjectInputStream(bais);
		System.out.println(in.read());
		Dogx dog = (Dogx)in.readObject();
		Dogx copy = dog.clone();
		System.out.println(dog.name);
		System.out.println(copy.name);
	}

}
