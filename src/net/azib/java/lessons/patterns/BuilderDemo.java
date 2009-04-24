package net.azib.java.lessons.patterns;

import java.util.HashSet;
import java.util.Set;

/**
 * BuilderDemo
 *
 * @author anton
 */
public class BuilderDemo {
	public static class Pizza {
		String name;
		boolean doubleCheese;
		boolean thickBottom;
		Set<String> ingredients = new HashSet<String>();
		int diameter;
		
		public static class Builder {
			public Builder name(String name) {
				return this;
			}
			
			public Builder withDoubleCheese() {
				return this;
			}
			
			public Builder withThickBottom() {
				return this;
			}
			
			public Builder with(String ingredient) {
				return this;
			}
			
			public Builder size(int size) {
				return this;
			}
			
			public Pizza build() {
				return new Pizza();
			}
		}
		
		public Pizza() {
			name = "Marherita";
			ingredients.add("Cheese");
			ingredients.add("Tomato");
		}
		
		public Pizza(String name) {
			this();
			this.name = name;
		}
		
		public Pizza(String name, boolean doubleCheese, int diameter, boolean thickBottom) {
			this();
			this.name = name;
			this.doubleCheese = doubleCheese;
			this.diameter = diameter;
			this.thickBottom = thickBottom;
		}

		/**
		 * @param string
		 */
		public void setName(String string) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public static void main(String[] args) {
		// direct
		Pizza p1 = new Pizza("SuperPizza", true, 30, true);
		
		// setters
		Pizza p2 = new Pizza();
		p2.setName("SuperPizza");
		//...
		
		// builder
		Pizza p3 = new Pizza.Builder().size(30).name("SuperPizza").
			withDoubleCheese().with("Onions").with("Ham").build();
	}
	
}
