package net.azib.java.students.t093052.homework.action.output;

import net.azib.java.students.t093052.homework.action.ActionType;

/**
 * This enum represents the output action types
 * */
public enum OutputActionType implements ActionType<OutputAction> {
	CONSOLE("-console", false, ConsoleOutputAction.class),
	CSV("-csv", true, CsvOutputAction.class),
	XML("-xml", true, XmlOutputAction.class),
	HTML("-html", true, HtmlOutputAction.class);
	
	private String name;
	private boolean paramNeeded;
	private Class<? extends OutputAction> actionClass;
	
	private OutputActionType(String name, boolean paramNeeded, 
			Class<? extends OutputAction> actionClass) {
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

	public Class<? extends OutputAction> getActionClass() {
		return actionClass;
	}
}
