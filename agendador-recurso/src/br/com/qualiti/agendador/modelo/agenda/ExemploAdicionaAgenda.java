package br.com.qualiti.agendador.modelo.agenda;

import java.time.LocalDate;
import java.util.Locale;

import br.com.qualiti.agendador.modelo.pessoa.Professor;

public class ExemploAdicionaAgenda {

	public static void main(String[] args) {

		Professor professor = new Professor();

		Agenda agenda = new Agenda();

		agenda.habilitaTurnoNoite(DiaSemanaEnum.SEGUNDA);
		agenda.habilitaTurnoNoite(DiaSemanaEnum.TERCA);
		agenda.habilitaTurnoNoite(DiaSemanaEnum.QUARTA);
		agenda.habilitaTurnoNoite(DiaSemanaEnum.QUINTA);
		agenda.habilitaTurnoNoite(DiaSemanaEnum.SEXTA);
		agenda.habilitaTurnoManha(DiaSemanaEnum.SABADO);
		agenda.habilitaTurnoTarde(DiaSemanaEnum.SABADO);

		LocalDate inicio = LocalDate.of(2016, 3, 10);
		LocalDate fim = LocalDate.of(2016, 4, 10);

		professor.isDisponivel(curso);

		professor.setAgenda(agenda);

		//===========================

		DiaSemanaEnum[] values = DiaSemanaEnum.values();

		for (DiaSemanaEnum dia : values) {
			System.out.println(dia.ordinal() + " - " + dia.getLocalizedName(Locale.ENGLISH));
		}

		System.out.println("\n\n\n");
		for (DiaSemanaEnum dia : values) {
			System.out.println(dia.ordinal() + " - " + dia.getLocalizedName(Locale.FRANCE));
		}


	}

}
