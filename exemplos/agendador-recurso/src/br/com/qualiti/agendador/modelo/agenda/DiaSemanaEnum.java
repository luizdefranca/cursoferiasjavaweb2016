package br.com.qualiti.agendador.modelo.agenda;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Locale;

public enum DiaSemanaEnum {

	DOMINGO(DayOfWeek.SUNDAY),
	SEGUNDA(DayOfWeek.MONDAY),
	TERCA  (DayOfWeek.TUESDAY),
	QUARTA (DayOfWeek.WEDNESDAY),
	QUINTA (DayOfWeek.THURSDAY),
	SEXTA  (DayOfWeek.FRIDAY),
	SABADO (DayOfWeek.SATURDAY);

	private DayOfWeek dayOfWeek;

	private DiaSemanaEnum(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getLocalizedName(Locale locale){

		String nomeDia = "";

		DateFormatSymbols symbols = DateFormatSymbols.getInstance(locale);

		nomeDia = symbols.getWeekdays()[this.ordinal()+1];

		return nomeDia;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

}
