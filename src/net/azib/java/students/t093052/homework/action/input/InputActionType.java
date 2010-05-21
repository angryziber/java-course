package net.azib.java.students.t093052.homework.action.input;

import net.azib.java.students.t093052.homework.action.ActionType;

/**
 * This enum represents the input action types
 * */
public enum InputActionType implements ActionType<InputAction> {
	CONSOLE("-console", false, ConsoleInputAction.class),
	CSV("-csv", true, CsvInputAction.class),
	DB("-db", true, DatabaseInputAction.class);
	
	private String name;
	private boolean paramNeeded;
	private Class<? extends InputAction> actionClass;
	
	private InputActionType(String name, 
			boolean paramNeeded, Class<? extends InputAction> actionClass) {
		this.name = name;
		this.paramNeeded = paramNeeded;
		this.actionClass = actionClass;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isParamNeeded() {
		return paramNeeded;
	}

	public Class<? extends InputAction> getActionClass() {
		return actionClass;
	}
}
