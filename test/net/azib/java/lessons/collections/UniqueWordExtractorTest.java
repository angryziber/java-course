package net.azib.java.lessons.collections;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;


/**
 * UniqueWordExtractorTest
 *
 * @author anton
 */
public class UniqueWordExtractorTest {
	@Test
	public void happyPath() throws Exception {
		String inputText = "hello cruel world which is very cruel";
		
		final String[] removerInput = inputText.split(" ");
		final String[] removerResult = {"hello", "cruel", "world", "which", "is", "very"};
		
		DuplicateRemover mockRemover = createMock(DuplicateRemover.class);
		expect(mockRemover.removeDuplicateStrings(aryEq(removerInput))).andReturn(removerResult);
		replay(mockRemover);		
		
		UniqueWordExtractor extractor = new UniqueWordExtractor(inputText, mockRemover);
		Collection<String> uniqueWords = extractor.getUniqueWords();
		
		assertEquals(Arrays.asList(removerResult), uniqueWords);
		verify(mockRemover);
	}
	
	@Test
	public void complexSymbols() throws Exception {
		String inputText = "Hello, cruel world! (which is very cruel)";
		
		final String[] removerInput = inputText.split(" ");
		final String[] removerResult = {"hello", "cruel", "world", "which", "is", "very"};
		
		DuplicateRemover mockRemover = createMock(DuplicateRemover.class);
		expect(mockRemover.removeDuplicateStrings(removerInput)).andReturn(removerResult);
		replay(mockRemover);		
		
		UniqueWordExtractor extractor = new UniqueWordExtractor(inputText, mockRemover);
		Collection<String> uniqueWords = extractor.getUniqueWords();
		
		assertEquals(Arrays.asList(removerResult), uniqueWords);
		verify(mockRemover);
	}
}
