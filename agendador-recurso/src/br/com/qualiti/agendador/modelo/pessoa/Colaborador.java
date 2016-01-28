package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

import br.com.qualiti.agendador.modelo.interfaces.Auditavel;

public abstract class Colaborador
	extends Pessoa implements Auditavel {

	abstract double calculaPagamentoPeriodo(LocalDate dataInicial,
			                                LocalDate dataFinal);
}
