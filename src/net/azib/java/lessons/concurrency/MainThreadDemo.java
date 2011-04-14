package net.azib.java.lessons.concurrency;

public class MainThreadDemo {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("How many threads? " + Thread.activeCount());

		Thread thread = Thread.currentThread();
		System.out.println(thread.getName());
		System.out.println(thread.getId());
		System.out.println(thread.getState());
		System.out.println(thread.getPriority());
	}
}
