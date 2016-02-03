package br.com.qualiti.colecoes.list.arraylist.addremove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListAddRemove {

	public static void main(String[] args) {

		copyAllListElementsToArrayList();
	}


	public static void addElementToArrayList() {

		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("um", "dois"));

		stringsList2.add("tres");
	}

	public static void addElementAtparticularIndexOfArrayList() {

		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("um", "dois"));

		stringsList2.add(0,"tres");//tres um dois


		stringsList2.set(0, "quatro");//quatro um dois


	}

	public static void appendCollectionElementsToArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois"));
		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("tres", "quatro"));

		stringsList.addAll(stringsList2); //um dois tres quatro

		stringsList2.addAll(stringsList); //tres quatro um dois tres quatro

	}

	public static void insertAllTheCollectionElementsToTheSpecifiedPositionInArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois"));
		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("tres", "quatro"));

		stringsList.addAll(0, stringsList2);//tres quatro um dois
	}

	//ESTE SOBRESCREVE !!!!!
	public static void copyAllListElementsToArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "cinco", "seis"));
		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("tres", "quatro"));

		Collections.copy(stringsList, stringsList2);//um dois tres quatro

		createArrayListWithNCopies();
	}


	public static void createArrayListWithNCopies() {

		List<String> nCopies = Collections.nCopies(5, "um");

		System.out.println(nCopies);

		for (String string : nCopies) {
			System.out.println(string);
		}
	}


	public static void removeElementFromTheSpecifiedIndexInArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("tres", "quatro"));

		stringsList.remove(0);//quatro
	}

	public static void removeSpecifiedElementFromArrayList(){

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("tres", "quatro"));

		//MANEIRA LONGA
		int indexOf = stringsList.indexOf("tres");
		stringsList.remove(indexOf);

		//MANEIRA CURTA
		stringsList.remove("tres");

	}

}
