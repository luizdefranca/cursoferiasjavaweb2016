package br.com.qualiti.colecoes.list.arraylist.basico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListBasico {

	public static void main(String[] args) {

	}

	public static void arrayListExample() {

		List<String> strings = new ArrayList<>();
		List<String> strings2 = new ArrayList<String>();
		ArrayList<String> strings3 = new ArrayList<String>();
	}

	public static void initializeArrayList() {

		String[] stringsArray = {"um", "dois"};

		//PRIMEIRA MANEIRA
		List<String> stringsList = new ArrayList<>();
		stringsList.add("um");
		stringsList.add("dois");

		//SEGUNDA MANEIRA
		List<String> stringsList2 =
			new ArrayList<>(Arrays.asList("um", "dois"));

		List<String> stringsList22 =
			new ArrayList<>(Arrays.asList(stringsArray));

		//TERCEIRA MANEIRA
		List<String> stringsList3 =
			new ArrayList<>(stringsList2);

		//QUARTA MANEIRA
		List<String> stringsList4 =
			new ArrayList<String>(){
			{
				add("um");
				add("dois");
			}
		};

		//QUINTA MANEIRA
		List<String> stringsList5 =
			new ArrayList<>();
		stringsList5.addAll(stringsList2);


	}

	public static void loopArrayList() {

		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("um", "dois"));

		//01
		for (int i = 0; i < stringsList2.size();
				i++) {
			String var = stringsList2.get(i);
		}

		//02
		for (String var : stringsList2) {

		}

		//03
		for (
			Iterator iterator = stringsList2.iterator();
			iterator.hasNext();
			) {
			String string = (String) iterator.next();

		}
	}

	public static void findLengthArrayList() {

		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("um", "dois"));


		int length = stringsList2.size();
	}

}
