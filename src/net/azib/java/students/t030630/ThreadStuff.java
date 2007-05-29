package net.azib.java.students.t030630;

/**
 * ThreadStuff
 * 
 * @author Kasutaja
 */
public class ThreadStuff {

	/**
	 * @param args
	 * @throws InterruptedException
	 */

	private static class Code implements Runnable {

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started");

			try {
				Thread.sleep(2000);
				System.out.println(name + " stopped");
			}
			catch (InterruptedException e) {
			}
			System.out.println(name + "  " + ((Thread.interrupted()) ? "interrupted" : "stopped"));
		}

	}

	public static void main(String[] args) throws InterruptedException {
		// Thread.sleep(1000);
		// System.out.println("aaa");
		// new Thread(new Code()).start();
		// System.out.println("Main stopped");
		Thread t = new Thread(new Code());
		System.out.println(t.getState());
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		// System.out.println(t.getState());
		t.join(1000);
		t.interrupt();
		System.out.println("Main stopped");
	}

}
