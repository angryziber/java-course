package net.azib.java.lessons.patterns;

import java.util.Collection;

public class Pizza {
	Collection<String> toppings;
	boolean doubleCheese;
	int diameterCm;
	boolean pepper;

	public Pizza() {
	}

	public Collection<String> getToppings() {
		return toppings;
	}

	public void setToppings(Collection<String> toppings) {
		this.toppings = toppings;
	}

	public boolean isDoubleCheese() {
		return doubleCheese;
	}

	public void setDoubleCheese(boolean doubleCheese) {
		this.doubleCheese = doubleCheese;
	}

	public int getDiameterCm() {
		return diameterCm;
	}

	public void setDiameterCm(int diameterCm) {
		this.diameterCm = diameterCm;
	}

	public boolean isPepper() {
		return pepper;
	}

	public void setPepper(boolean pepper) {
		this.pepper = pepper;
	}
}
