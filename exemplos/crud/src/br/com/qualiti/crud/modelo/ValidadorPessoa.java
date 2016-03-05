package br.com.qualiti.crud.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorPessoa {

	public static boolean cpfValido(String cpf) {

		if(isStringInvalida(cpf)){
			return false;
		}

		String regexCpf = "\\d{11}";
		Pattern patternCpf = Pattern.compile(regexCpf);
		Matcher matchCpf = patternCpf.matcher(cpf);

		return matchCpf.matches();
	}

	public static boolean emailValido(String email) {

		if(isStringInvalida(email)){
			return false;
		}

		String regexEmail = "[\\w]+[@][^\\s]+";
		Pattern patternEmail = Pattern.compile(regexEmail);
		Matcher matchEmail = patternEmail.matcher(email);

		return matchEmail.matches();
	}

	public static boolean sexoValido(String sexoString) {

		if(isStringInvalida(sexoString)){
			return false;
		}

		char sexo = sexoString.charAt(0);

		return (sexo == 'M' || sexo == 'F' || sexo == 'T');
	}

	public static boolean isStringInvalida(String string){
		if(string == null || string.trim().isEmpty()){
			return true;
		}

		return false;
	}

}
