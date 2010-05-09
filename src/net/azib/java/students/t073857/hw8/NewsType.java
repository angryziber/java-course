package net.azib.java.students.t073857.hw8;

/**
 * NewsType
 *
 * @author Joonas Vali
 */
public enum NewsType {
	RECENT_NEWS("http://rss.cnn.com/rss/cnn_latest.rss", "Recent news"),
	EUROPE_NEWS("http://rss.cnn.com/rss/edition_europe.rss", "Europe"),
	US_NEWS("http://rss.cnn.com/rss/edition_us.rss", "US"),
	WORLD_NEWS("http://rss.cnn.com/rss/edition_world.rss", "World"),
	TOP_NEWS("http://rss.cnn.com/rss/edition.rss", "Top News"),
	AFRICA_NEWS("http://rss.cnn.com/rss/edition_africa.rss", "Africa"),
	ASIA("http://rss.cnn.com/rss/edition_asia.rss", "Asia"),
	MIDDLE_EAST("http://rss.cnn.com/rss/edition_meast.rss", "Middle East"),
	BUSINESS("http://rss.cnn.com/rss/edition_business.rss","Business"),
	TECHNOLOGY("http://rss.cnn.com/rss/edition_technology.rss","Technology"),
	SCIENCE_SPACE("http://rss.cnn.com/rss/edition_space.rss","Sci&Space"),
	SPORT("http://rss.cnn.com/rss/edition_sport.rss", "Sport");
	
	private String link;
	private String name;
	
	private NewsType(String link, String display){
		this.link = link;
		name = display;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public String getLink(){
		return link;
	}
}
