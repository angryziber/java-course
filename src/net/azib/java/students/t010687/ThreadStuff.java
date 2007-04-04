package net.azib.java.students.t010687;

/**
 * ThreadStuff
 *
 * @author t010687
 */
public class ThreadStuff {

	private static class Code implements Runnable {

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()  {
			String name = Thread.currentThread().getName();
			System.out.println(name + " started");
			try {
				Thread.sleep(3000);
				System.out.println(name + " stopped");
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(name + " interrupted");
			}	
			finally {
				
			}
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {//throws Exception
		//Thread.sleep(1000);
		Thread t = new Thread(new Code());
		t.setPriority(Thread.MAX_PRIORITY);
		t.start();
		//t.join(1000);
		//t.interrupt();
		System.out.println("Main stopped!");
		//System.out.println(Thread.currentThread().getId());

	}

}
