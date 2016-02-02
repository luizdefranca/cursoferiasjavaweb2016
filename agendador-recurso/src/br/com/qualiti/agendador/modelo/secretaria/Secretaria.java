package br.com.qualiti.agendador.modelo.secretaria;

import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.agendador.modelo.agenda.AgendaSemanalTurnos;
import br.com.qualiti.agendador.modelo.curso.Turma;
import br.com.qualiti.agendador.modelo.infrafisica.Sala;
import br.com.qualiti.agendador.modelo.pessoa.Professor;

public class Secretaria {

	public Turma getProximaTurmaPossivel(
			Turma turma, List<Professor> professores, List<Sala> salas){


		int cargaHoraria = turma.getCurso().getCargaHoraria();
		int quantidadeDiasSemana = turma.getAgenda().getHorarios().size();
		double quantidadeSemanas = (cargaHoraria/4)/quantidadeDiasSemana;

		List<Professor> professoresAgendasCompativeis =
			turma.getProfessoresAgendasCompativeis(professores);



		return turma;
	}

	public static void main(String[] args) {
		Secretaria secretaria = new Secretaria();


	}
}
