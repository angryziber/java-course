package net.azib.java.students.t092877.homework;

class Mode {

	private Strategy strategy;

	public Mode(Strategy strategy) {
		this.strategy = strategy;
	}

	public void executeStrategy(Competition competition) {
		 strategy.execute(competition);
	}
}
