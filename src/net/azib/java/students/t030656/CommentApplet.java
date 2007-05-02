package net.azib.java.students.t030656;

import net.azib.java.students.t030656.CommentBean.CommentBean;

import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.net.URL;

/**
 * CommentApplet
 *
 * @author t030656
 */
public class CommentApplet extends Applet {

	/** serialVersionUID */
	private static final long serialVersionUID = 1121098868878285781L;
	private Image img;

	/* (non-Javadoc)
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void init() {
		 
			URL resource = getClass().getClassLoader().getResource("m2rk.GIF");
	//		System.out.println(resource);
			img = Toolkit.getDefaultToolkit().getImage(resource);
	}

	/* (non-Javadoc)
	 * @see java.applet.Applet#start()
	 */
	@Override
	public void start() {
	//	add(new CommentBean());
	//	add(new Canvas(){
	//		setSize(300,300);
	//	}
		
		
		
	}

	
}
