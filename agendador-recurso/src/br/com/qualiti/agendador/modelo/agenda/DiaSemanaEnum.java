package br.com.qualiti.agendador.modelo.agenda;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

public enum DiaSemanaEnum {

	DOMINGO,
	SEGUNDA,
	TERCA  ,
	QUARTA ,
	QUINTA ,
	SEXTA  ,
	SABADO;

	public String getLocalizedName(Locale locale){

		String nomeDia = "";

		DateFormatSymbols symbols = DateFormatSymbols.getInstance(locale);

		nomeDia = symbols.getWeekdays()[this.ordinal()+1];

		return nomeDia;
	}

}
