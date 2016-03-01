package br.com.qualiti.agendador.modelo.agenda;

import java.time.LocalDate;
import java.time.Period;

public class PeriodoOcupacao {

	private Period periodo;
	private AgendaSemanalTurnos agenda;

	public PeriodoOcupacao(AgendaSemanalTurnos agenda,
			               LocalDate inicio,
			               LocalDate fim) {
		this.periodo = Period.between(inicio, fim.plusDays(1));
		this.agenda = agenda;
	}

	public AgendaSemanalTurnos getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaSemanalTurnos agenda) {
		this.agenda = agenda;
	}

	public Period getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Period periodo) {
		this.periodo = periodo;
	}

}
