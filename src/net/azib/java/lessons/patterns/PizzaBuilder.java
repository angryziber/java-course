package net.azib.java.lessons.patterns;

public class PizzaBuilder {
	Pizza unfinished = new Pizza();

	private PizzaBuilder with(String topping) {
		unfinished.toppings.add(topping);
		return this;
	}

	private PizzaBuilder sizeCm(int diameter) {
		unfinished.diameterCm = diameter;
		return this;
	}

	private PizzaBuilder withPepper() {
		unfinished.pepper = true;
		return this;
	}

	private Pizza build() {
		return unfinished;
	}

	public static void main(String[] args) {
		Pizza pizza =
			new PizzaBuilder().with("tomato").with("cheese").
				sizeCm(30).withPepper().build();
	}

}
