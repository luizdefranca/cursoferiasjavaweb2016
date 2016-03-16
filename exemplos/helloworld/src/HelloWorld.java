import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class HelloWorld {

	public static void main(String[] args) throws IOException {
		List<String> strings = Arrays.asList("Lula", "Lourival", "Dilma", "Cunha", "Renan");

		//SEMI JAVA 8
		//imprime(strings, s-> s.startsWith("L") && s.length() <= 4);

		//== JAVA 8
		//strings.forEach(System.out::println);
		//System.out.println(parametro.toString())

		strings
		.stream()
		.filter(s-> s.startsWith("L") && s.length() <= 4)
		.forEach(System.out::println);

		Path path = Paths.get("texto.txt");

		Files.readAllLines(path)
		.stream()
		.filter(s-> s.startsWith("L") && s.length() <= 4)
		.forEach(System.out::println);

		URL url = new URL("http://www.folha.com");


	}

	private static void imprime(List<String> strings, Predicate<String> predicate) {
		for (String string : strings) {
			if(predicate.test(string)){
				System.out.println(string);
			}
		}
	}

}
