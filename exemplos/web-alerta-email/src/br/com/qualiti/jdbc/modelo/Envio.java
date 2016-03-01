package br.com.qualiti.jdbc.modelo;

import java.time.LocalDateTime;

public class Envio {

	private Long id;
	private LocalDateTime data;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
