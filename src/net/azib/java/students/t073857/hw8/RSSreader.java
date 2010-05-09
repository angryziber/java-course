package net.azib.java.students.t073857.hw8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;

/**
 * RSSreader
 * Connects to the CNN's RSS, to get recent news
 *
 * @author Joonas Vali
 * 
 */
public class RSSreader extends Thread{
	public static final int SLEEP_TIME = 6000000; // wait 10 minutes before refresh 	
		
	private LinkedList<String> data = new LinkedList<String>();
	private LinkedList<News> news = new LinkedList<News>();
	public boolean newContent = false;
	URL url; 
	
	public RSSreader(NewsType newsType) {
		try {
			url = new URL(newsType.getLink());
		}
		catch (MalformedURLException e) {	} 		
		start();
	}	
	
	public void run(){
		while(true){			
			try {
				news.clear();
				readData();
				Thread.sleep(SLEEP_TIME);
			}
			catch (InterruptedException e) {			
				e.printStackTrace();
			}
		}
	}
	
	private void readData(){
		
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new InputStreamReader(url.openStream()));			
		}
		catch (IOException e) {
			return;			
		}
		try {
			data.clear();
			String temp;
			while((temp = bf.readLine())!= null){
				data.add(temp);
			}
		}
		catch (IOException e) {
			return;
		}
		parseData();
	}
	
	public void parseData(){
		boolean inItem=false;
		String news=null;
		String link=null;
		String description=null;
		
		while(!data.isEmpty()){
			String active = data.removeFirst();
			if(!inItem){
				if(active.contains("<item>")){
					inItem = true;
				}
			}
			else{
				if(active.contains("<title>")){
					active = active.replace("<title>", "");
					active = active.replace("</title>", "");
					news = active;
				}else if(active.contains("<link>")){
					active = active.replace("<link>", "");
					active = active.replace("</link>", "");
					link = active;
				}else if(active.contains("<description>")){
					active = active.replace("<description>", "");
					active = active.replace("</description>", "");
					if(active.contains("&lt")){
						active = active.split("&lt")[0]; // Don't know why some RSS feed includes some code...
					}
					description = active;
				}else if(active.contains("</item>")){
					inItem = false;
					if(news != null && link != null && description != null){
						try {
							this.news.add(new News(news, link, description));
						}						
						catch (URISyntaxException e) {	}
						news = null;
						link = null;
						description = null;
					}
				}
			}			
		}	
		Collections.shuffle(this.news);
		newContent = true;				
	}
	
	public LinkedList<News> getNews(){
		return news;
	}
	
}
