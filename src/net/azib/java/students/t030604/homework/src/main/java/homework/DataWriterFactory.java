package net.azib.java.students.t030604.homework.src.main.java.homework;

/**
 * Factory pattern to produce DataWriters
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public final class DataWriterFactory {
	
	private DataWriterFactory() {
		//intended
	}
	
	public static IDataWriter getWriter(String writerName) {
		return null;
	}

}
