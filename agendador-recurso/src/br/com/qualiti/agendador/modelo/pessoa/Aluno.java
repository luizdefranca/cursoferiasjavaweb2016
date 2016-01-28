package br.com.qualiti.agendador.modelo.pessoa;

import java.util.List;

import br.com.qualiti.agendador.modelo.curso.Turma;

public class Aluno extends Pessoa {

	//TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Turma> turma;

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
}
