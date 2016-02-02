package br.com.qualiti.agendador.modelo.agenda;

import java.time.LocalDate;
import java.util.Locale;

import br.com.qualiti.agendador.modelo.pessoa.Professor;

public class ExemploAdicionaAgenda {

	public static void main(String[] args) {

		Professor professor = new Professor();

		AgendaSemanalTurnos agendaSemanalTurnos = new AgendaSemanalTurnos();

		agendaSemanalTurnos.habilitaTurnoNoite(DiaSemanaEnum.SEGUNDA);
		agendaSemanalTurnos.habilitaTurnoNoite(DiaSemanaEnum.TERCA);
		agendaSemanalTurnos.habilitaTurnoNoite(DiaSemanaEnum.QUARTA);
		agendaSemanalTurnos.habilitaTurnoNoite(DiaSemanaEnum.QUINTA);
		agendaSemanalTurnos.habilitaTurnoNoite(DiaSemanaEnum.SEXTA);
		agendaSemanalTurnos.habilitaTurnoManha(DiaSemanaEnum.SABADO);
		agendaSemanalTurnos.habilitaTurnoTarde(DiaSemanaEnum.SABADO);

		LocalDate inicio = LocalDate.of(2016, 3, 10);
		LocalDate fim = LocalDate.of(2016, 4, 10);

		professor.isDisponivel(curso);

		professor.setAgenda(agendaSemanalTurnos);

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
