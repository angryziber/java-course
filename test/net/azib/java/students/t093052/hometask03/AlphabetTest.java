package net.azib.java.students.t093052.hometask03;
//
//import static org.junit.Assert.assertArrayEquals;
//
//import java.text.Collator;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Locale;
//import java.util.Set;
//import java.util.TreeSet;
//
//import org.junit.Ignore;
//import org.junit.Test;
//
///**
// * AlphabetTest
// *
// * @author Kostja
// */
//public class AlphabetTest {
//	private static final String ENG = 
//		"A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
//	private static final String GER = 
//		"A Ä B C D E F G H I J K L M N O Ö P Q R S ß T U Ü V W X Y Z";
//	private static final String RUS = 
//		"А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ы Ь Э Ю Я";
//	private static final String EST = 
//		"A B D E F G H I J K L M N O P R S Š Z Ž T U V Õ Ä Ö Ü";
//	
//	@Test
//	public void eng() throws Exception {
//		assertArrayEquals(split(ENG), sort(ENG, Locale.ENGLISH));
//	}
//	
//	@Test
//	public void ger() throws Exception {
//		assertArrayEquals(split(GER), sort(GER, Locale.GERMAN));
//	}
//	
//	@Test 
//	public void rus() throws Exception {
//		assertArrayEquals(split(RUS), sort(RUS, new Locale("ru")));
//	}
//	
//	@Test
//	public void est() throws Exception {
//		assertArrayEquals(split(EST), sort(EST, new Locale("et")));
//	}
//	
//	private String[] sort(String alphabet, Locale locale) {
//		Collator comparator = Collator.getInstance(locale);
//		Set<String> set = new TreeSet<String>(comparator);
//		set.addAll(Arrays.asList(split(alphabet)));
//		return set.toArray(new String[set.size()]);
//	}
//	
//	private String[] split(String string) {
//		return string.split(" ");
//	}
//}
import static org.junit.Assert.assertArrayEquals;
import java.text.Collator;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;
import org.junit.Test;
public class AlphabetTest {
    private static final String ENG = 
        "A B C D E F G H I J K L M N O P Q R S T U Va Vc Wb Wd X Y Z";
    private static final String GER = 
        "A B C D E F G H I J K L M N O P Q R S T U Va Vc Wb Wd X Y Z Ä Ö Ü ß";
    private static final String RUS = 
        "А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ы Ь Э Ю Я";
    private static final String EST = 
        "A B D E F G H I J K L M N O P R S Š Z Ž T U Va Vc Wb Wd Õ Ä Ö Ü";
    
    @Test
    public void eng() throws Exception {
        print(collatorSort(ENG, Locale.ENGLISH));
        assertArrayEquals(split(ENG), collatorSort(ENG, Locale.ENGLISH));
        assertArrayEquals(split(ENG), sort(ENG));
    }
    
    @Test
    public void ger() throws Exception {
        print(collatorSort(ENG, Locale.GERMAN));
        assertArrayEquals(split(ENG), collatorSort(ENG, Locale.GERMAN));
        assertArrayEquals(split(GER), sort(GER));
    }
    
    @Test
    public void rus() throws Exception {
        print(sort(RUS));
        assertArrayEquals(split(RUS), sort(RUS));
    }
    
    @Test
    public void rusCollator() throws Exception {
        print(collatorSort(RUS, new Locale("ru")));
        assertArrayEquals(split(RUS), collatorSort(RUS, new Locale("ru")));
    }
    
    @Test
    public void est() throws Exception {
        print(sort(EST));
        assertArrayEquals(split(EST), sort(EST));
    }
    
    @Test
    public void estCollator() throws Exception {
        print(collatorSort(EST, new Locale("et")));
        assertArrayEquals(split(EST), collatorSort(EST, new Locale("et")));
    }
    
    private void print(String[] strings) {
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println();
    }
    
    private String[] collatorSort(String alphabet, Locale locale) {
        Collator instance = Collator.getInstance(locale);
        instance.setStrength(Collator.PRIMARY);
		return sort(new TreeSet<String>(
                instance), alphabet);
    }
    
    private String[] sort(String alphabet) {
        return sort(new TreeSet<String>(), alphabet);
    }
    
    private String[] sort(Set<String> set, String alphabet) {
        set.addAll(Arrays.asList(split(alphabet)));
        return set.toArray(new String[set.size()]);
    }
    
    private String[] split(String string) {
        return string.split(" ");
    }
}
