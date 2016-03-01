package br.com.qualiti.agendador.modelo.curso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.qualiti.agendador.modelo.agenda.AgendaSemanalTurnos;
import br.com.qualiti.agendador.modelo.pessoa.Aluno;
import br.com.qualiti.agendador.modelo.pessoa.Professor;

public class Turma {

	private LocalDate inicio;
	private LocalDate fim;
	// TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Aluno> alunos;
	// TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Professor> professores;
	// TEM-UM (MUITOS-PARA-UM - BIDIRECIONAL)
	private Curso curso;
	// TEM-UM (UM-PARA-UM - UNIDIRECIONAL)
	private AgendaSemanalTurnos agendaSemanalTurnos;

	public List<Professor> getProfessoresAgendasCompativeis(
			List<Professor> professores){

		List<Professor> professoresComAgendasCompativeis = new ArrayList<>();

		for (Professor professor : professores) {
			if(this.agendaSemanalTurnos.isCompativel(professor.getAgenda())){
				professoresComAgendasCompativeis.add(professor);
			}
		}

		return professoresComAgendasCompativeis;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFim() {
		return fim;
	}

	public void setFim(LocalDate fim) {
		this.fim = fim;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public AgendaSemanalTurnos getAgenda() {
		return agendaSemanalTurnos;
	}

	public void setAgenda(AgendaSemanalTurnos agendaSemanalTurnos) {
		this.agendaSemanalTurnos = agendaSemanalTurnos;
	}
}
