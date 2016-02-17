package br.com.qualiti.exemplo.er;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ERExemplo {

	public static void main(String[] args) {

		String textoParaTeste = "http://www.google.com";
		String expressaoRegular = "(http)(s)?(://)([\\w\\-]+\\.?\\/?)+((\\?|&)[\\w;]*=?[\\w;]*)*";

		//Representa a expressao em si
		Pattern pattern = Pattern.compile(expressaoRegular);

		Matcher matcher = pattern.matcher(textoParaTeste);

		//OU TUDO OU NADA
		System.out.println(matcher.matches());

		textoParaTeste = "http:www.google.com";
		matcher = pattern.matcher(textoParaTeste);
		System.out.println(matcher.matches());

		textoParaTeste = "zzzhttp://www.google.comzzz";
		matcher = pattern.matcher(textoParaTeste);
		System.out.println(matcher.matches());

		//INFORMA SE A EXPRESSAO ACHOU ALGUMA COISA NO TEXTO
		textoParaTeste = "inicio http://www.google.com inicio";
		matcher = pattern.matcher(textoParaTeste);
		System.out.println(matcher.find());

		//RECUPERANDO AS STRINGS CAPTURADAS

		String stringCapturada = matcher.group();
		System.out.println(stringCapturada);

		textoParaTeste =
			"inicio http://www.google.com inicio http://g1.globo.com";
		matcher = pattern.matcher(textoParaTeste);

		while(matcher.find()){
			stringCapturada = matcher.group();
			System.out.println(stringCapturada);
		}


	}

}
