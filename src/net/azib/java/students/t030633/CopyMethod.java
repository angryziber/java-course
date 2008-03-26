package net.azib.java.students.t030633;

/**
 * CopyMethod
 * 
 * @author t030633
 */
public enum CopyMethod {

	S("Simple"), B("Buffered"), C("Channeled"), D("Direct Channeled");

	private final String name;

	CopyMethod(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
