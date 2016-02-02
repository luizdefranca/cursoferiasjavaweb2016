package br.com.qualiti.agendador.modelo.pessoa;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.qualiti.agendador.modelo.agenda.AgendaSemanalTurnos;
import br.com.qualiti.agendador.modelo.agenda.HorarioAgenda;
import br.com.qualiti.agendador.modelo.curso.Turma;

public class Professor extends Horista {

	//TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Turma> turmas;


	public LocalDate calculaProximaDataDisponivel(
			AgendaSemanalTurnos agendaProposta){

		List<Turma> turmasComMesmaAgenda = new ArrayList<>();

		for (Turma turma : turmas) {
			if (agendaProposta.isCompativel(turma.getAgenda())) {
				turmasComMesmaAgenda.add(turma);
			}
		}

		Collections.sort(turmasComMesmaAgenda, new Comparator<Turma>() {
			@Override
			public int compare(Turma turma1, Turma turma2) {
				return turma2.getFim().compareTo(turma1.getFim());
			}
		});

		Turma turmaMaisRecente = turmasComMesmaAgenda.get(0);

		LocalDate ultimaData = turmaMaisRecente.getFim();

		DayOfWeek dayOfWeek = ultimaData.getDayOfWeek();

		List<HorarioAgenda> horarios = agendaProposta.getHorarios();

		for (HorarioAgenda horarioAgenda : horarios) {
			if(horarioAgenda.getDia().getDayOfWeek().equals(dayOfWeek)){

			}
		}

	}

	@Override
	double calculaPagamentoPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
		// TODO Auto-generated method stub
		return super.calculaPagamentoPeriodo(dataInicial, dataFinal);
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public boolean isDisponivel(LocalDate inicio,
							 LocalDate fim,
							 String turno,
							 String... diasSemana) {


		return true;
	}
}
