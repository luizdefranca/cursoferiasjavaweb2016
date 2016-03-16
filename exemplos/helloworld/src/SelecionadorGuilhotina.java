import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class SelecionadorGuilhotina {

	private static List<Colaborador> colaboradores;

	static {
		colaboradores = new ArrayList<>();

		colaboradores.add(new Colaborador(1L, "Januário",   "11111111111", 10000, LocalDate.of(1998, 9, 7)));
		colaboradores.add(new Colaborador(2L, "Feruário",   "22222222222", 8000, LocalDate.of(1997, 9, 7)));
		colaboradores.add(new Colaborador(3L, "Marciário",  "33333333333", 6000, LocalDate.of(1996, 9, 7)));
		colaboradores.add(new Colaborador(4L, "Abriário",   "44444444444", 4000, LocalDate.of(1995, 9, 7)));
		colaboradores.add(new Colaborador(5L, "Maiário",    "55555555555", 2000, LocalDate.of(1994, 9, 7)));
		colaboradores.add(new Colaborador(6L, "Juniário",   "66666666666", 2000, LocalDate.of(1993, 9, 7)));
		colaboradores.add(new Colaborador(7L, "Juliário",   "77777777777", 1000, LocalDate.of(1992, 9, 7)));
		colaboradores.add(new Colaborador(8L, "Agostiário","88888888888", 1000, LocalDate.of(1991, 9, 7)));

	}

	public static void main(String[] args) {

		long total = colaboradores
				.stream()
				.filter(c -> c.getSalario() > 5000)
				.count();

		System.out.println("total : "+total);

		System.out.println("Nomes dos ricos\n");
		colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.map(c -> c.getNome())
		.forEach(System.out::println);

		System.out.println("\nCpf dos ricos\n");

		List<String> cpfs = colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.map(c -> c.getCpf())
		.collect(Collectors.toList());

		cpfs.forEach(System.out::println);

		System.out.println("\nRicos completos\n");

		List<Colaborador> ricos = colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.collect(Collectors.toList());

		ricos.forEach(System.out::println);

		System.out.println("\nCpf dos ricos\n");

		double totalSalarios = colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.collect(Collectors.summingDouble(Colaborador::getSalario));

		System.out.println( "\nTotal dos salários "+totalSalarios);

		long totalId = colaboradores
				.stream()
				.filter(c -> c.getSalario() > 5000)
				.collect(Collectors.summingLong(Colaborador::getId));

		System.out.println( "\nTotal dos ids "+totalId);

		System.out.println("\nExibindo por ordem alfabética os nomes\n");

		colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.map(c -> c.getNome().toUpperCase())
		.sorted()
		.forEach(System.out::println);

		colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.map(c -> c.getNome().toUpperCase())
		.sorted(Comparator.comparing(String::toUpperCase))
		.forEach(System.out::println);


		System.out.println("\nExibindo por ordem alfabética inversa os nomes\n");

		colaboradores
		.stream()
		.filter(c -> c.getSalario() > 5000)
		.sorted(Comparator.comparing(Colaborador::getNome).reversed())
		.map(c -> c.getNome().toUpperCase())
		.forEach(System.out::println);


	}

}
