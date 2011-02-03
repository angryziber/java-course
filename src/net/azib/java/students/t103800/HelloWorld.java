package net.azib.java.students.t103800;

/**
 * Created by IntelliJ IDEA.
 * User: Jaan Aigro 103800 IASB21
 * Date: 3.02.11
 * Time: 19:04
 * Programm kirjutab tähekaupa 500ms pausidega sõna HelloWorld.
 */
public class HelloWorld implements Runnable {

    public HelloWorld() {
        Thread thread = new Thread(this);
        thread.setName("HelloWorldThreadThingy");
        thread.run();
    }

    public static void main(String[] args) {
        new HelloWorld();
    }

    public void run() {
        String hellostring = "HelloWorld";
        int chars = hellostring.length();
        for (int i = 0; i < chars; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Viga: " + e.getMessage());
                e.printStackTrace();
            }
            System.out.print(hellostring.charAt(i));
        }
    }
}
