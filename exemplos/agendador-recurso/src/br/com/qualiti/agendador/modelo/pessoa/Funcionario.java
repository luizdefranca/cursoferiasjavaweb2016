package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

public class Funcionario extends Colaborador {

	private double salario;

	@Override
	double calculaPagamentoPeriodo(LocalDate dataInicial,
									LocalDate dataFinal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String geraDadosAuditoria() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
