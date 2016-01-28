package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

public class Horista extends Colaborador {

	private double valorHora;
	//DISPONIBILIDADE

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

}
