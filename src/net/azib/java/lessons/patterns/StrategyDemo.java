package net.azib.java.lessons.patterns;

import java.util.Arrays;

import com.mysql.jdbc.SocketFactory;

/**
 * StrategyDemo
 *
 * @author anton
 */
public class StrategyDemo {
	public static interface State {
		void doSomething();
		boolean isFinished();
		State next();
	}
	
	public static class InitState implements State {
		public void doSomething() {
			System.out.println("init");
		}

		public boolean isFinished() {
			return false;
		}

		public State next() {
			return new InProgressState();
		}
		
	}
	
	public static class InProgressState implements State {
		public void doSomething() {
			for (int i = 0; i < 10; i++)
				System.out.println("working...");
		}

		public boolean isFinished() {
			return false;
		}

		public State next() {
			return new BeforeCompleteState();
		}
	}
	
	public static class BeforeCompleteState implements State {
		public void doSomething() {
			System.out.println("finishing....");
		}

		public boolean isFinished() {
			return false;
		}

		public State next() {
			return new CompleteState();
		}
	}
	
	public static class CompleteState implements State {
		public void doSomething() {
			System.out.println("end!");
		}

		public boolean isFinished() {
			return true;
		}

		public State next() {
			return null;
		}
	}
	
	public static void main(String[] args) {
		State currentState = new InitState();
		do {
			currentState.doSomething();
			currentState = currentState.next();
		}
		while (!currentState.isFinished());
		currentState.doSomething();
	}
}
