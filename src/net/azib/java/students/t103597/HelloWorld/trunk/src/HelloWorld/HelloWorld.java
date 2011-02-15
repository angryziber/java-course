package HelloWorld;

import java.awt.Frame;
import java.awt.AWTEvent;
import java.awt.event.WindowEvent;
/**
 * Created by IntelliJ IDEA.
 * User: Tom
 * Date: 11.02.11
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 *
 * Info:
 *         Just testing and combining exercises.
 */
public class HelloWorld extends Frame {
    public static void main(String[] args){

        new HelloWorld();
    }

    HelloWorld(){
        Message to;
        to = new Message();
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        add(to);
        pack();
        show();
    }

    public void processWindowEvent(WindowEvent event) {
        if(event.getID() == WindowEvent.WINDOW_CLOSING)
            System.exit(0);
    }
}
