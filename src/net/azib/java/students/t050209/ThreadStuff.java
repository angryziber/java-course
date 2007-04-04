package net.azib.java.students.t050209;

/**
 * ThreadStuff
 *
 * @author t050209
 */
public class ThreadStuff {

	
	private static class Code implements Runnable {
		public void run() {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started");
			try {
				Thread.sleep(2000);
				System.out.println(name + " stopped");
			}
			catch (InterruptedException e) {
				System.out.println(name + " interrupted");
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Thread t = new Thread(new Code());
		//t.setDaemon(true);
		System.out.println(t.getState());
		//t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		t.join(1000); //võib omada väärtust
		t.interrupt();
		System.out.println("Main stopped");
	}

}
