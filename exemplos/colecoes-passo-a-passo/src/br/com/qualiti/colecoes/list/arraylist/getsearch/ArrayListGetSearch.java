package br.com.qualiti.colecoes.list.arraylist.getsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListGetSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public static void getSubListOfArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "tres", "quatro"));

		List<String> subList = stringsList.subList(1, 3);//dois tres
	}

	public static void getTheIndexOfFirstOccurrenceOfTheElementInTheArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "tres", "um", "quatro", "um"));

		int firstIndexOf = stringsList.indexOf("um");
	}

	public static void getTheIndexOfLastOccurrenceOfTheElementInTheArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "tres", "um", "quatro", "um"));

		int lastIndexOf = stringsList.lastIndexOf("um");
	}

	public static void getElementFromArrayList() {
		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "tres", "um", "quatro", "um"));

		//INDICE JÁ CONHECIDO
		String um = stringsList.get(0);

		//DESCOBRINDO O INDICE PRIMEIRO
		int indexOf = stringsList.indexOf("um");
		String um2 = stringsList.get(indexOf);
	}


	public static void checkWhetherElementExistsInArrayList(){

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "tres", "quatro"));

		List<String> stringsList2 =
				new ArrayList<>(Arrays.asList("um", "dois", "tres", "quatro", "cinco", "seis"));

		//CHECANDO A EXISTENCIA DE UM UNICO ELEMENTO
		boolean existe = stringsList.contains("um");//true
		existe = stringsList.contains("asdrubal");//false

		//CHECANDO SE "TODOS" OS ELEMENTOS DE UMA LISTA ESTAO EM OUTRA LISTA

		boolean existemTodos = stringsList2.containsAll(stringsList);//true
		existemTodos = stringsList.containsAll(stringsList2);//false

		//CHECANDO A EXISTENCIA DE UM UNICO ELEMENTO USANDO INDEXOF
		int indexOf = stringsList.indexOf("um");//se maior ou igual zero - EXISTE
		indexOf = stringsList.indexOf("asdrubal");//retornal -1 - NÃO EXISTE
		existe = indexOf >= 0;

	}
}
