package br.com.qualiti.agendador.modelo.agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	private List<Dia> dias;

	public Agenda() {
		dias = new ArrayList<>();
	}

	public List<Dia> getDias() {
		return dias;
	}

	public void setDias(List<Dia> dias) {
		this.dias = dias;
	}

	public void adicionaDiaTurno(String nomeDia, String nomeTurno) {

		Dia dia = new Dia();
		dia.setNome(nomeDia);

		dia.adicionaTurno(nomeTurno);

		dias.add(dia);

	}
}
