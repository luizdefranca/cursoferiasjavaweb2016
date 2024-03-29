package br.com.qualiti.colecoes.list.arraylist.outros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.qualiti.colecoes.list.arraylist.ordenacao.Pessoa;

public class Outros {

	public static void main(String[] args) {

		//compareTwoArrayList();

		//overrideToStringMethodArrayList();

		trimTheSizeOfArrayList();
	}

	public static void compareTwoArrayList() {

		Pessoa bobo = new Pessoa("Bob", LocalDate.of(1985, 9, 1));
		Pessoa andre1 = new Pessoa("André", LocalDate.of(1978, 1, 2));
		Pessoa andre2 = new Pessoa("André", LocalDate.of(1978, 1, 1));

		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(bobo);
		pessoas.add(andre1);
		pessoas.add(andre2);

		List<Pessoa> pessoas2 = new ArrayList<>();
		pessoas2.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas2.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));
		pessoas2.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));

		List<Pessoa> pessoas3 = new ArrayList<>();
		pessoas3.add(bobo);
		pessoas3.add(andre1);
		pessoas3.add(andre2);

		List<Pessoa> pessoas4 = new ArrayList<>();
		pessoas4.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas4.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));
		pessoas4.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));

		List<Pessoa> pessoas5 = new ArrayList<>();
		pessoas5.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));
		pessoas5.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas5.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));

		//01
		boolean iguais = pessoas.equals(pessoas2);
		System.out.println(iguais);

		//02
		iguais = pessoas.equals(pessoas3);
		System.out.println(iguais);

		//03
		iguais = pessoas2.equals(pessoas4);
		System.out.println(iguais);

		//04
		iguais = pessoas4.containsAll(pessoas5);
		boolean iguais2 = pessoas5.containsAll(pessoas4);
		System.out.println(iguais && iguais2);
	}

	public static void synchronizeArrayList() {

		List<String> strings = new ArrayList<String>();
		strings = Collections.synchronizedList(strings);
	}

	public static void swapTwoElementsInArrayList() {

		List<Pessoa> pessoas5 = new ArrayList<>();
		pessoas5.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));
		pessoas5.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas5.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));

		Collections.swap(pessoas5, 1, 2);

	}

	public static void overrideToStringMethodArrayList() {

		List<String> strings = new ArrayList<String>(){

			@Override
			public String toString() {
				return "{\n\t"+super.toString()+"\n}";
			}
		};

		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");

		System.out.println(strings);
	}

	public static void serializeArrayList() {
	}

	public static void joinTwoArrayList() {
	}

	public static void cloneArrayListToAnotherArrayList() throws CloneNotSupportedException {


		List<Pessoa> pessoas5 = new ArrayList<>();
		pessoas5.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));
		pessoas5.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas5.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));


		List<Pessoa> pessoas6 = new ArrayList<>();
		pessoas6.add(new Pessoa("Afonso", LocalDate.of(1973, 1, 1)));
		pessoas6.add(new Pessoa("Eugenio", LocalDate.of(1989, 9, 1)));
		pessoas6.add(new Pessoa("Leandro", LocalDate.of(1981, 1, 2)));

		for (Pessoa pessoa : pessoas6) {
			Pessoa clonePessoa = (Pessoa)pessoa.clone();
			pessoas5.add(clonePessoa);
		}


		
		
		List<Pessoa> pessoas2 = new ArrayList<>();
		pessoas2.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas2.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));
		pessoas2.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));
	}

	public static void makeArrayListEmpty() {

		//LIMPAR
		List<String> strings = new ArrayList<String>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");

		strings.clear();

		//CRIAR VAZIA
		List<String> strings2 = new ArrayList<String>();
		List<String> strings3 = Collections.emptyList();

		//CRIAR COM UM UNICO ELEMENTO
		List<String> strings4 = Collections.singletonList("a");

	}

	public static void checkWhetherArrayListIsEmptyOrNot() {
		ArrayList<String> strings = new ArrayList<String>(200);
		boolean vazia = strings.isEmpty();

	}

	public static void trimTheSizeOfArrayList() {


		ArrayList<String> strings = new ArrayList<String>(200);

		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add(null);
		strings.add(null);
		strings.add(null);


		for (String string : strings) {
			System.out.println(string);
		}

		System.out.println("============================");

		strings.trimToSize();

		for (String string : strings) {
			System.out.println(string);
		}
	}

	public static void replaceTheValueOfExistingElementInArrayList() {

		ArrayList<String> strings = new ArrayList<String>(200);

		strings.add("a");
		strings.add("b");
		strings.add("c");
		strings.add("d");
		strings.add("b");

		strings.set(2, "z");

		Collections.replaceAll(strings, "b", "z");
	}

	public static void increaseSizeOfArrayList(){

		ArrayList<String> strings = new ArrayList<String>(200);

		strings.ensureCapacity(300);

	}

}
