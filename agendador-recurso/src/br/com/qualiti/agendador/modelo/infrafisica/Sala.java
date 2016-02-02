package br.com.qualiti.agendador.modelo.infrafisica;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import br.com.qualiti.agendador.modelo.agenda.AgendaSemanalTurnos;
import br.com.qualiti.agendador.modelo.agenda.PeriodoOcupacao;
import br.com.qualiti.agendador.modelo.curso.Turma;

public class Sala {

	private int quantidadeMaximaAlunos;
	private Set<PeriodoOcupacao> periodosOcupacao;

	public Sala() {
		this.setPeriodosOcupacao(new TreeSet<>());
	}


	public boolean addPeriodoOcupacao(Turma turma){

		return addPeriodoOcupacao(turma.getAgenda(), turma.getInicio(), turma.getFim());
	}

	public boolean addPeriodoOcupacao(AgendaSemanalTurnos agenda,
									  LocalDate inicio,
									  LocalDate fim){

		PeriodoOcupacao periodoOcupacao = new PeriodoOcupacao(agenda, inicio, fim);

		boolean inseridoComSucesso = periodosOcupacao.add(periodoOcupacao);

		return inseridoComSucesso;
	}


	public int getQuantidadeMaximaAlunos() {
		return quantidadeMaximaAlunos;
	}

	public void setQuantidadeMaximaAlunos(int quantidadeMaximaAlunos) {
		this.quantidadeMaximaAlunos = quantidadeMaximaAlunos;
	}


	public Set<PeriodoOcupacao> getPeriodosOcupacao() {
		return periodosOcupacao;
	}


	public void setPeriodosOcupacao(Set<PeriodoOcupacao> periodosOcupacao) {
		this.periodosOcupacao = periodosOcupacao;
	}
}
