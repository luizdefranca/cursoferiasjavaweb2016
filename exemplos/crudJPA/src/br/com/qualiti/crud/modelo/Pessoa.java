package br.com.qualiti.crud.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_pessoa database table.
 * 
 */
@Entity
@Table(name="tb_pessoa")
@NamedQueries(
{ 
	@NamedQuery(name = "Pessoa.findAll", 
			    query = "SELECT p FROM Pessoa p"),
	@NamedQuery(name = "Pessoa.findAll.nome", 
				query = "SELECT p.nome FROM Pessoa p") 
})
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pes_id_int_pk")
	private int id;

	@Column(name="pes_cpf_char"
			,nullable=false
			,length=11
			,unique=true)
	private String cpf;

	@Column(name="pes_email_var")
	private String email;

	@Column(name="pes_nome_var")
	private String nome;

	@Column(name="pes_sexo_char")
	private String sexo;

	public Pessoa() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}