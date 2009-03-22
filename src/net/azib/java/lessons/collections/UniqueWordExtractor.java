package net.azib.java.lessons.collections;

import java.util.Arrays;
import java.util.Collection;

/**
 * UniqueWordExtractor
 *
 * @author anton
 */
public class UniqueWordExtractor {
	
	private final String text;
	private DuplicateRemover remover;

	public UniqueWordExtractor(String text) {
		this(text, new DuplicateRemoverImpl());
	}
	
	UniqueWordExtractor(String text, DuplicateRemover removerImpl) {
		this.text = text;
		remover = removerImpl;
	}
	
	public Collection<String> getUniqueWords() {
		String[] duplicateWords = text.split("[\\s?!:,.()]+");
		String[] uniqueWords = remover.removeDuplicateStrings(duplicateWords);
		return Arrays.asList(uniqueWords);
	}
}
