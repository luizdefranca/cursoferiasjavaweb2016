import java.time.LocalDate;

public class Colaborador {

	private Long id;
	private String nome;
	private String cpf;
	private float salario;
	private LocalDate dataAdmissao;

	public Colaborador(Long id, String nome, String cpf, float salario, LocalDate dataAdmissao) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataAdmissao = dataAdmissao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

}
