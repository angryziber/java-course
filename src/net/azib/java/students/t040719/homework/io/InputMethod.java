package net.azib.java.students.t040719.homework.io;


/**
 * InputMethod - enum for holding different data input methods
 *
 * @version 1.0
 * @author Romi Agar
 */
public enum InputMethod {
	K("Keyboard", InteractiveInput.class),
	F("CSV file", FileInput.class),
	D("MySQL database", DatabaseInput.class);
	
	private final String source;
	private final Class<? extends DataInput> inputClass;
	
	InputMethod(String src, Class<? extends DataInput> clazz){
		source = src;
		inputClass = clazz;
	}
	
	public String getSource(){
		return source;
	}
	
	public DataInput getCopier() {
		try {
			return inputClass.newInstance();
		}
		catch (Exception e) {
			System.err.println("Technical error, unable to instantiate " + inputClass.getName());
			return null;
		}
	}
}
