package br.com.qualiti.agendador.modelo.agenda;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

	List<HorarioAgenda> horarios;

	public Agenda() {
		horarios = new ArrayList<>();
	}


	public void habilitaTurnoManha(DiaSemanaEnum diaSemana){
		HorarioAgenda horarioAgenda =
			new HorarioAgenda(diaSemana, TurnoEnum.MANHA);

		horarios.add(horarioAgenda);
	}

	public void habilitaTurnoTarde(DiaSemanaEnum diaSemana){
		HorarioAgenda horarioAgenda =
				new HorarioAgenda(diaSemana, TurnoEnum.TARDE);

			horarios.add(horarioAgenda);
	}

	public void habilitaTurnoNoite(DiaSemanaEnum diaSemana){
		HorarioAgenda horarioAgenda =
				new HorarioAgenda(diaSemana, TurnoEnum.NOITE);

			horarios.add(horarioAgenda);
	}
}
