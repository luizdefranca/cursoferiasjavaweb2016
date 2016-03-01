package br.com.qualiti.agendador.modelo.endereco;

public class Endereco {

	private String complemento;
	private String numero;
	private String pontoReferencia;

	//TEM-UM (MUITOS-PARA-UM - NAO BIDIRECIONAL)
	private CEP cep;

	public Endereco() {
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public CEP getCep() {
		return cep;
	}

	public void setCep(CEP cep) {
		this.cep = cep;
	}

	public String getPontoReferencia() {
		return pontoReferencia;
	}

	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
}