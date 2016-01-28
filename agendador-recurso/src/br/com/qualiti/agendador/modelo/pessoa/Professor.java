package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;
import java.util.List;

import br.com.qualiti.agendador.modelo.curso.Turma;

public class Professor extends Horista {

	//TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Turma> turmas;

	@Override
	double calculaPagamentoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		// TODO Auto-generated method stub
		return super.calculaPagamentoPeriodo(dataInicial, dataFinal);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
