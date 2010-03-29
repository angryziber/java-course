package net.azib.java.lessons.text;

import static org.junit.Assert.assertArrayEquals;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Ignore;
import org.junit.Test;

/**
 * AlphabetTest
 *
 * @author Kostja
 */
public class AlphabetTest {
	private static final String ENG = 
		"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
	private static final String GER = 
		"A Ä B C D E F G H I J K L M N O Ö P Q R S ß T U Ü V W X Y Z";
	private static final String RUS = 
		"А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ы Ь Э Ю Я";
	private static final String EST = 
		"A B D E F G H I J K L M N O P R S Š Z Ž T U V Õ Ä Ö Ü";
	
	@Test
	public void eng() throws Exception {
		assertArrayEquals(split(ENG), sort(ENG, Locale.ENGLISH));
	}
	
	@Test
	public void ger() throws Exception {
		assertArrayEquals(split(GER), sort(GER, Locale.GERMAN));
	}
	
	@Test 
	public void rus() throws Exception {
		assertArrayEquals(split(RUS), sort(RUS, new Locale("ru")));
	}
	
	@Test
	public void est() throws Exception {
		assertArrayEquals(split(EST), sort(EST, new Locale("et")));
	}
	
	private String[] sort(String alphabet, Locale locale) {
		Collator comparator = Collator.getInstance(locale);
		Set<String> set = new TreeSet<String>(comparator);
		set.addAll(Arrays.asList(split(alphabet)));
		return set.toArray(new String[set.size()]);
	}
	
	private String[] split(String string) {
		return string.split(" ");
	}
}
