package br.com.qualiti.colecoes.list.arraylist.ordenacao;

import java.util.Comparator;

public class ComparatorDescendingOrder implements Comparator<String> {

	@Override
	public int compare(String string1, String string2) {

		//return string2.compareTo(string1);
		return string1.compareTo(string2) * -1;
	}

}
