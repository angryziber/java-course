package net.azib.java.students.t030633;

import net.azib.java.lessons.io.FileCopier;

/**
 * CopyMethod
 * 
 * @author t030633
 */
public enum CopyMethod {

	S("Simple", SimpleCopyProgram.class), 
	B("Buffered", BufferedCopyProgram.class), 
	C("Channeled", ChanneledCopyProgram.class), 
	D("Direct Channeled", DirectChanneledCopyProgram.class);

	private final String name;
	private final Class<? extends FileCopier> copierClass;

	CopyMethod(String name, Class<? extends FileCopier> clazz) {
		this.name = name;
		this.copierClass = clazz;
	}

	public String getName() {
		return name;
	}

	public FileCopier getCopier() {
		try {
			return copierClass.newInstance();
		}
		catch (Exception e) {
			System.err.println("Technical error, unable to instantiate " + copierClass.getName());
			return null;
		}
	}
}
