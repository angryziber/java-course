package net.azib.java.students.t093052.hometask03;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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
		"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z Ä Ö Ü ß";
	private static final String RUS = 
		"А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ы Ь Э Ю Я";
	private static final String EST = 
		"A B D E F G H I J K L M N O P R S Š Z Ž T U V Õ Ä Ö Ü";
	
	@Test
	public void eng() throws Exception {
		assertArrayEquals(split(ENG), sort(ENG));
	}
	
	@Test
	public void ger() throws Exception {
		assertArrayEquals(split(GER), sort(GER));
	}
	
	@Test
	public void rus() throws Exception {
//		assertArrayEquals(split(RUS), sort(RUS));
	}
	
	@Test
	public void est() throws Exception {
//		assertArrayEquals(split(EST), sort(EST));
	}
	
	private String[] sort(String alphabet) {
		Set<String> set = new TreeSet<String>(Arrays.asList(split(alphabet)));
		return set.toArray(new String[set.size()]);
	}
	
	private String[] split(String string) {
		return string.split(" ");
	}
}
