package net.azib.java.students.t092877.homework;

class Context {

	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(Competition competition) {
		 strategy.execute(competition);
	}
}
