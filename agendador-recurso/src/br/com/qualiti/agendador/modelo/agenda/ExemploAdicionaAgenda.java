package br.com.qualiti.agendador.modelo.agenda;

import java.time.LocalDate;

import br.com.qualiti.agendador.modelo.pessoa.Professor;

public class ExemploAdicionaAgenda {

	public static void main(String[] args) {

		Professor professor = new Professor();

		Agenda agenda = new Agenda();

		agenda.adicionaDiaTurno(AgendaConstantes.SEGUNDA, AgendaConstantes.NOITE);
		agenda.adicionaDiaTurno(AgendaConstantes.TERCA, AgendaConstantes.NOITE);
		agenda.adicionaDiaTurno(AgendaConstantes.QUARTA, AgendaConstantes.NOITE);
		agenda.adicionaDiaTurno(AgendaConstantes.QUINTA, AgendaConstantes.NOITE);
		agenda.adicionaDiaTurno(AgendaConstantes.SEXTA, AgendaConstantes.NOITE);
		agenda.adicionaDiaTurno(AgendaConstantes.SABADO, AgendaConstantes.MANHA);
		agenda.adicionaDiaTurno(AgendaConstantes.SABADO, AgendaConstantes.TARDE);

		LocalDate inicio = LocalDate.of(2016, 3, 10);
		LocalDate fim = LocalDate.of(2016, 4, 10);

		professor.isDisponivel(
			inicio,
			fim,
			AgendaConstantes.NOITE,
			AgendaConstantes.SEGUNDA,
			AgendaConstantes.QUARTA,
			AgendaConstantes.SEXTA);

		professor.setAgenda(agenda);
	}

}
