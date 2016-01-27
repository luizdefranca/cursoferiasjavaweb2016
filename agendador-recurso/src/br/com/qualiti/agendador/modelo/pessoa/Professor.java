package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

public class Professor extends Horista {

	@Override
	double calculaPagamentoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		// TODO Auto-generated method stub
		return super.calculaPagamentoPeriodo(dataInicial, dataFinal);
	}
}
