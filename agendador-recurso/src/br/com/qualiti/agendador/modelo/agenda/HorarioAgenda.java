package br.com.qualiti.agendador.modelo.agenda;

public class HorarioAgenda {

	private DiaSemanaEnum dia;
	private TurnoEnum turno;

	public HorarioAgenda(DiaSemanaEnum dia, TurnoEnum turno) {
		this.dia = dia;
		this.turno = turno;
	}

	public DiaSemanaEnum getDia() {
		return dia;
	}

	public void setDia(DiaSemanaEnum dia) {
		this.dia = dia;
	}

	public TurnoEnum getTurno() {
		return turno;
	}

	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}
}
