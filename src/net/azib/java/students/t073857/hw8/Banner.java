package net.azib.java.students.t073857.hw8;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Banner
 *
 * @author Joonas Vali
 */
public class Banner extends Canvas{
	LinkedList<News> text = new LinkedList<News>();
	News active;
	int x=0, y = 10;
	private Image offscreen; 
	private Graphics offscreenG;  
	boolean updateWidth = true;
	int stringWidth = 0;
	RSSreader rss;
		
	public Banner(int width) {		
		init(width);		
		Timer animationTimer = new Timer();
		animationTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				x--;
				
				if (x+stringWidth < 0 && text.size()!=0) {
					fetchMessage();
					x = getWidth();
					if(rss.newContent){
						text = rss.getNews();
						rss.newContent = false;
					}
				}				
				repaint();
			}
		}, 100, 10);
	}
	
	public void init(int width){
		rss = new RSSreader(RSSreader.RECENT_NEWS);
		while(!rss.newContent){
			try {
				Thread.sleep(200);
			}
			catch (InterruptedException e) {	}
		}
		rss.newContent = false;
		text = rss.getNews();		
		fetchMessage();
		this.setSize(new Dimension(width, 12));
	}
	
	public void fetchMessage(){
		try{
			active = text.peekFirst();			
			text.addLast(text.removeFirst());					
			updateWidth = true;
		} catch(NoSuchElementException e){ }
	}
	
	public void initOffscreen(){
		offscreen = createImage(getWidth(), getHeight());
		offscreenG = offscreen.getGraphics();
	}
	
	@Override
	public void update(Graphics g) {	
		
		if (offscreen == null) {
			initOffscreen();
		}
		offscreenG.clearRect(0, 0, getWidth(), getHeight());
		try{
			if(updateWidth){
				stringWidth = g.getFontMetrics().stringWidth(active.toString());
				updateWidth = false;				
			}			
			offscreenG.drawString(active.toString(), x, y);
		} catch(NullPointerException e){ }
		g.drawImage(offscreen, 0, 0, this);
	}
}
