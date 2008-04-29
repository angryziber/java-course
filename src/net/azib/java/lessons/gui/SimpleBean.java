package net.azib.java.lessons.gui;

import java.io.Serializable;

/**
 * SimpleBean
 *
 * @author anton
 */
public class SimpleBean implements Serializable {
	
	private String name = "Default";
	private int color = 0xFF0000;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the color
	 */
	public int getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(int color) {
		this.color = color;
	}
	
	public void setVersion(String ver) {
		
	}
	
}

