package net.azib.java.lessons.concurrent;

/**
 * DefaultThreadsDemo
 * 
 * Enables jconsole
 * -Dcom.sun.management.jmxremote
 *
 * @author anton
 */
public class DaemonDemo {
	
	public static void main(String[] args) throws InterruptedException {
		Runnable bgCode = new Runnable() {
			public void run() {
				while (!Thread.interrupted()) {
					try {
						Thread.sleep(1000);

						if ((int)(Math.random() * 5) == 0) {
							int i = 1/0;
						}
						System.out.print(".");					
					}
					catch (InterruptedException e) {
						// terminate the thread if someone asks us
						System.err.println("Interupted!");
						break;
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t = new Thread(bgCode);
		t.setDaemon(true);
		t.start();
		
		System.out.println(Thread.currentThread().getName());
		
		Thread.sleep(5000);
		t.interrupt();
		
		Thread.sleep(100000);
	}
}
