package br.com.qualiti.agendador.modelo.agenda;

import java.util.ArrayList;
import java.util.List;

public class Dia {

	private String nome;
	private List<Turno> turnos;


	public Dia() {
		turnos = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public void adicionaTurno(String nomeTurno) {

		Turno turno = new Turno();
		turno.setNome(nomeTurno);
		turnos.add(turno);
	}
}
