package caracteres;

import java.io.Console;

public class ConsoleExemplo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Console console = System.console();

		String nome =
				console.readLine("Digite seu nome");

		System.out.println("nome digitado - " +nome);


	}

}
