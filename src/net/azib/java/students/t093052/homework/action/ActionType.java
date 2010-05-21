package net.azib.java.students.t093052.homework.action;

/**
 * This interface represents the common behavior of the input and output action types
 * */
public interface ActionType<T extends Action> {
	/**
	 * @return the name of the action type
	 * */
	public String getName();
	/**
	 * Decides is the additional parameter needed or not
	 * @return true if additional parameter needed
	 * */
	public boolean isParamNeeded();
	/**
	 * @return the class of the action which corresponds to the action type
	 * */
	public Class<? extends T> getActionClass();
}
