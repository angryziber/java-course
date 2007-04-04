package net.azib.java.students.t010687;

/**
 * Syncr
 *
 * @author t010687
 */
public class Syncr {
	private static int value;
	private static class Code implements Runnable {

		
		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()  {
			for (int i = 0; i < 100000000;i++){
				synchronized (this){
					value ++;	//Teet Lokk		
				}
			}
		}
		
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Code code = new Code();
		Thread t1 = new Thread(code);
		Thread t2 = new Thread(code);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(value);

	}

}
