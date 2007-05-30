package net.azib.java.students.t010687.Beans;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * CommentApplet
 *
 * @author t010687
 */
public class CommentApplet extends Applet {
	private Image img;
	
	public void start(){
		add(new CommentBean());
		add(new Canvas() {
			{setSize(300,300);
			}
			public void paint(Graphics g){
				getGraphics().drawImage(img, 10,10,this);
			}
		});
	}
	
	public void init(){
		//System.out.println("H:\\java\\Pildike.bmp");
		try {
			img = Toolkit.getDefaultToolkit().getImage(new URL("http://ati.ttu.ee/img/vb000.gif"));
		}
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}///getClass().getClassLoader().getResource("http://ati.ttu.ee/img/vb000.gif"));
	}
}
