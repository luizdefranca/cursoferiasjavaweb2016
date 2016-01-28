package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

public class Terceirizado extends Colaborador {

	private double custoFixo;

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

	public double getCustoFixo() {
		return custoFixo;
	}

	public void setCustoFixo(double custoFixo) {
		this.custoFixo = custoFixo;
	}

}
