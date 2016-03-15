package org.eleicoes2014.alerta;

import java.util.ArrayList;
import java.util.List;

public class Alerta {

	private List<String> wordFilters;
	
	public void setWords(String... wordFilters) {
		
		this.wordFilters = normalizeWords(wordFilters);
	}

	private List<String> normalizeWords(String... words) {
		
		wordFilters = new ArrayList<>();
		
		for (String word : words) {
			
			String normalizedWord = normalizeWord(word);
			
			wordFilters.add(normalizedWord);
		}
		
		return wordFilters;
	}

	private String normalizeWord(String word) {
		return word.toUpperCase();
	}

	public boolean containFilters(String tweet) {
		
		String normalizedTweet = normalizeWord(tweet);
		
		for (String word : wordFilters) {
			if (!normalizedTweet.contains(word)) {
				return false;
			}
		}
		
		return true;
	}

}
