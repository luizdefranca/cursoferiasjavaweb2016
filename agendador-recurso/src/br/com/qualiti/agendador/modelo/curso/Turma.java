package br.com.qualiti.agendador.modelo.curso;

import java.time.LocalDate;
import java.util.List;

import br.com.qualiti.agendador.modelo.pessoa.Aluno;
import br.com.qualiti.agendador.modelo.pessoa.Professor;

public class Turma {

	private LocalDate inicio;
	private LocalDate fim;
	private String turno;//virar um enum
	//TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Aluno> alunos;
	//TEM-UM (MUITOS-PARA-MUITOS - BIDIRECIONAL)
	private List<Professor> professores;
	//TEM-UM (MUITOS-PARA-UM - BIDIRECIONAL)
	private Curso curso;


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
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
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
}
