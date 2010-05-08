package net.azib.java.students.t073857.hw8;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * News
 *
 * @author Joonas Vali
 */
public class News implements Serializable{
	private String description;
	private String news;
	private URI url;	
	public News(String news, String url, String description) throws URISyntaxException{
		this.news = news;
		this.url = new URI(url);
		this.description = description;
	}
	public String getNews() {
		return news;
	}
	
	public String getDescription() {
		return description;
	}
	
	public URI getUri() {
		return url;
	}
	
	public String toString() {
		return news;
	}
	
	public String slicedDescription(int words){
		StringBuilder sb = new StringBuilder(description);
		int count = 0;
		for(int i = 0; i < sb.length(); i++){
			if(sb.charAt(i)==' ') count++;
			if(count%words==0){ 
				sb.insert(i, "\n");
				i++;
				count++;
			}			
		}
		return sb.toString();
	}

}
