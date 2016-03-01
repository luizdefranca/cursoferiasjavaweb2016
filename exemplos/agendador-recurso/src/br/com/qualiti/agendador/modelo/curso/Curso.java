package br.com.qualiti.agendador.modelo.curso;

import java.util.List;

import br.com.qualiti.agendador.modelo.agenda.AgendaSemanalTurnos;

public class Curso {

	private int cargaHoraria;
	//TEM-UM (UM-PARA-MUITOS - BIDIRECIONAL)
	private List<Turma> turmas;

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
}
