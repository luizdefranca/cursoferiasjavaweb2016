package br.com.qualiti.agendador.modelo.pessoa;

import java.time.LocalDate;

public abstract class Colaborador extends Pessoa {

	abstract double calculaPagamentoPeriodo(LocalDate dataInicial,
			                                LocalDate dataFinal);
}
