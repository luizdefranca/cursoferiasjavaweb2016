package br.com.qualiti.agendador.modelo.curso;

import java.util.List;

public class Curso {

	//TEM-UM (UM-PARA-MUITOS - BIDIRECIONAL)
	private List<Turma> turmas;

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
