package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

import br.com.qualiti.agendador.modelo.agenda.Agenda;

public class Horista extends Colaborador {

	private double valorHora;
	//DISPONIBILIDADE
	private Agenda agenda;

	@Override
	double calculaPagamentoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String geraDadosAuditoria() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

}
