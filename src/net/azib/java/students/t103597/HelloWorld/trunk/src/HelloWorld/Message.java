package HelloWorld;

import java.awt.Canvas;     // Used for windows
import java.awt.Graphics;   //
import java.awt.FontMetrics;
import java.awt.Rectangle;

/**
 * Created by IntelliJ IDEA.
 * User: Tom
 * Date: 11.02.11
 * Time: 12:56
 * To change this template use File | Settings | File Templates.
 */
public class Message extends Canvas {

    Message() {
        setSize(400,200);
    }
    public void paint(Graphics g){
        Rectangle rect;
        rect = getBounds();
        String howdy;
        howdy = "Hello World!!!";
        FontMetrics fm = g.getFontMetrics();
        int howdywidth = fm.stringWidth(howdy);
        int y = rect.height / 2;
        int x = (rect.width / 2) - (howdywidth / 2);


        g.drawString(howdy,x,y);  // Draws my string
    }
}
