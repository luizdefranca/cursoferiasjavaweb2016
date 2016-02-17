import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FilesExemplo {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("/Users/miguelangelo/Downloads/CENTRO.csv");

		List<String> readAllLines = Files.readAllLines(path);

//		for (String string : readAllLines) {
//			System.out.println(string);
//		}

		readAllLines.forEach(System.out::println);

		path = Paths.get("/Users/miguelangelo/Downloads/CENTRO2.csv");

		Files.write(path, readAllLines);
	}

}
