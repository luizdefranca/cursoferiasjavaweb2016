package br.com.qualiti.strings.string;

import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class StringExamples {

	public static void main(String[] args) {

		convertStringToArray();
	}

	public static void changeStringCase(){

		String string = "galo da madrugada";

		String stringMaiuscula = string.toUpperCase();

		string = "FRANK AGUIAR";

		String stringMiniuscula = string.toLowerCase();
	}
	public static void checkIfStringContainsAnother(){

		String frase = "Frevo não é tudo igual!";

		String palavra = "frevo";

		String fraseMinuscula = frase.toLowerCase();

		boolean contem = fraseMinuscula.contains(palavra);
	}
	public static void checkIfStringEndsWithAnother(){
		String frase = "Frevo não é tudo igual!";

		String palavra = "igual!";

		String fraseMinuscula = frase.toLowerCase();

		boolean terminaCom = fraseMinuscula.endsWith(palavra);
	}
	public static void checkIfStringIsEmpty(){
		String stringNula = null;

		if(stringNula == null){
			System.out.println("não pode ser nulo.");
		}

		String stringVazia = "";

		if (stringVazia.isEmpty()) {
			System.out.println("não pode ser vazia.");
		}
	}
	public static void contactStrings (){
		//JEITO BURRO (cria 4 strings na memória)
		String frase = "Frevo" + " não" + " é" +  " tudo" + " igual!";

		//JEITO MELHOR (teoricamente cria apenas uma)
		StringBuilder fraseBuilder = new StringBuilder();

		fraseBuilder.append("Frevo");
		fraseBuilder.append(" não");
		fraseBuilder.append(" é");
		fraseBuilder.append(" tudo");
		fraseBuilder.append(" igual!");

		System.out.println(fraseBuilder);//Maneiras equivalentes
		System.out.println(fraseBuilder.toString());

	}
	public static void convertAsciiToString(){}
	public static void convertBytesToStringAndStringToBytes(){}
	public static void convertCharToStringAndStringToChar(){}
	public static void convertDateToString(){}
	public static void convertStringToArray(){
		String frase = "Frevo não é tudo igual!";

		//STRING -> ARRAY DE CHARS
		char[] charArray = frase.toCharArray();

		for (char c : charArray) {
			boolean digit = Character.isDigit(c);
			boolean upperCase = Character.isUpperCase(c);
			boolean letter = Character.isLetter(c);
		}

		//ARRAY DE CHARS -> STRING

		String frase2 = String.valueOf(charArray);
		String frase2ComTraco =
			String.join("-","Frevo","não","é","tudo","igual!");

		System.out.println(frase2ComTraco);

		//SEPARAR AS PALAVRAS USANDO UM CARACTER COMO SEPARADOR

		String[] palavrasFrase = frase.split(" ");
		for (String palavra : palavrasFrase) {
			System.out.println(palavra);
		}
	}
	public static void convertStringToNumber() throws NumberFormatException{
		Integer wrapper = Integer.valueOf("3");
		int primitivo = Integer.parseInt("3");
	}
	public static void createSubstring(){
		String frase  = "Eu não sou gay!";

		String fraseVerdadeira = frase.substring(7);//sou gay!

		int lastIndex = frase.length() - 1;

		//primeiro inclusive, segundo exclusive
		// Conta - indice1 até indice2 - 1
		String fraseVerdadeira2 = frase.substring(7, lastIndex);//sou gay
	}
	public static void equalsAndEqualsIgnoreCase(){
		String fraseLower  = "eu não sou gay!";
		String fraseUpper  = "EU NÃO SOU GAY!";

		boolean iguais = fraseLower.equals(fraseUpper);//false

		iguais = fraseLower.equals(fraseUpper.toLowerCase());//true

		iguais = fraseLower.equalsIgnoreCase(fraseUpper);//true
	}
	public static void retrieveCharacterAtSpecifiedIndex(){
		char charEspecifico = "abcde".charAt(1);//b
	}
	public static void findLastOccurrenceOfString(){}
	public static void findStringIndex(){}
	public static void getStringLength(){
		int length = "aaaaaaaaaa".length();
	}
	public static void initalizeString(){}
	public static void removeBlankAtBorders(){}
	public static void replaceAllOcurrencesOfString(){
		String frase = "meu salário máximo é 3000";

		String agoraSim = frase.replaceAll("3000", "20000");
		//String agoraSim = frase.replaceAll("(?<!é )\\d{4,5}$", "20000");
	}
	public static void replaceCharacter(){}
	public static void stringReferencesPoolStrings(){}
	public static void usingRegularExpression(){}

}
