package br.com.qualiti.colecoes.list.arraylist.ordenacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenacaoArrayList {

	public static void main(String[] args) {

		customOrdering("nome", false);
		customOrdering("dataNascimento", false);
		//customOrdering("naoExiste", "ASC");
	}

	public static void sortArrayList() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "cinco", "seis"));

		//UTILIZANDO O compareTo dos objetos contidos na lista
		Collections.sort(stringsList);//cinco dois seis um
	}

	public static void sortArrayListInDescendingOrder() {

		List<String> stringsList =
				new ArrayList<>(Arrays.asList("um", "dois", "cinco", "seis"));

		//UTILIZANDO um comparator personalizado com classe anonima no metodo

		Comparator<String> comparatorDescendingOrder = new Comparator<String>() {

			@Override
			public int compare(String string1, String string2) {

				//return string2.compareTo(string1);
				return string1.compareTo(string2) * -1;
			}
		};

		Collections.sort(stringsList, comparatorDescendingOrder);//um seis dois cinco


		//UTILIZANDO um comparator personalizado usando uma classe fisica

		Comparator<String> comparatorDescendingOrder2 =
			new ComparatorDescendingOrder();

		Collections.sort(stringsList, comparatorDescendingOrder2);//um seis dois cinco

		//UTILIZANDO um comparator personalizado usando classe anonima dentro da classe

		Comparator<String> comparatorDescendingOrder3 =
			new ComparatorDescendingOrderInsideClass();

		Collections.sort(stringsList, comparatorDescendingOrder3);//um seis dois cinco

	}

	public static void sortArrayListOfObjectsUsingComparableAndComparator() {

		List<Pessoa> pessoas = new ArrayList<>();
		Pessoa bob = new Pessoa("Bob", LocalDate.of(1985, 9, 1));
		Pessoa andre1 = new Pessoa("André", LocalDate.of(1978, 1, 2));
		Pessoa andre2 = new Pessoa("André", LocalDate.of(1978, 1, 1));

		pessoas.add(bob);
		pessoas.add(andre1);
		pessoas.add(andre2);
		pessoas.add(new Pessoa("Mauro", LocalDate.of(1985, 9, 1)));

		//int resultado = pessoas.get(0).compareTo(pessoas.get(1));

		Collections.sort(pessoas);

		System.out.println(pessoas);

	}

	public static void customOrdering(final String nomeField, final boolean ascending){


		List<Pessoa> pessoas5 = new ArrayList<>();
		pessoas5.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));
		pessoas5.add(new Pessoa("Lindomar", LocalDate.of(1973, 1, 1)));
		pessoas5.add(new Pessoa("Alonso", LocalDate.of(1989, 9, 1)));
		pessoas5.add(new Pessoa("Olonso", LocalDate.of(1989, 9, 1)));
		pessoas5.add(new Pessoa("Jamerson", LocalDate.of(1981, 1, 2)));
		pessoas5.add(new Pessoa("Ramerson", LocalDate.of(1981, 1, 2)));

		Comparator<Pessoa> customComparator = new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {

				int resultado = 0;

				if("nome".equals(nomeField)){
					resultado = o1.getNome().compareTo(o2.getNome());
				}else if("dataNascimento".equals(nomeField)){
					resultado = o1.getDataNascimento().compareTo(o2.getDataNascimento());
				}

				int ordem = 1;

				if(!ascending){
					ordem = -1;
				}

				return resultado * ordem;
			}
		};

		System.out.println(nomeField+" ===========================================");

		Collections.sort(pessoas5, customComparator);

		for (Pessoa pessoa : pessoas5) {
			System.out.println(pessoa);
		}



	}

	static class ComparatorDescendingOrderInsideClass implements Comparator<String> {

		@Override
		public int compare(String string1, String string2) {

			//return string2.compareTo(string1);
			return string1.compareTo(string2) * -1;
		}
	}



}
