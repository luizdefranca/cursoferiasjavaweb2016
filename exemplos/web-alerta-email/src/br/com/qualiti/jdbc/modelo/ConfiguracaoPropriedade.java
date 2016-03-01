package br.com.qualiti.jdbc.modelo;

public class ConfiguracaoPropriedade {

	private Long id;
	private String chave;
	private String valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	@Override
	public boolean equals(Object obj) {

		if((obj instanceof ConfiguracaoPropriedade) == false){
			return false;
		}

		ConfiguracaoPropriedade outro =
				(ConfiguracaoPropriedade)obj;

		return getChave().equals(outro.getChave());
	}





}
