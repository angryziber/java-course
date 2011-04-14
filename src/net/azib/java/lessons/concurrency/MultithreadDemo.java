package net.azib.java.lessons.concurrency;

public class MultithreadDemo implements Runnable {

	@Override
	public void run() {
		System.out.println("Hello from " + Thread.currentThread());
	}

	public static void main(String[] args) throws InterruptedException {
		Runnable code = new MultithreadDemo();

		Thread another = new Thread(code, "another");
		another.start();

		another.join();
		code.run();
	}
}
