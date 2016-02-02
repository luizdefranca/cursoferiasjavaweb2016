package br.com.qualiti.agendador.modelo.agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaSemanalTurnos {

	List<HorarioAgenda> horarios;

	public AgendaSemanalTurnos() {
		horarios = new ArrayList<>();
	}


	public boolean isCompativel(AgendaSemanalTurnos outraAgenda){

		boolean compativeis = false;

		List<HorarioAgenda> outrosHorarios = outraAgenda.horarios;
		if(outrosHorarios.containsAll(horarios)){
			compativeis = true;
		}

		return compativeis;
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


	public List<HorarioAgenda> getHorarios() {
		return horarios;
	}


	public void setHorarios(List<HorarioAgenda> horarios) {
		this.horarios = horarios;
	}
}
