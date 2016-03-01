package br.com.qualiti.alerta.modelo;

import java.time.LocalDateTime;

public class LinkAchado {

	private Long id;
	private String url;
	private LocalDateTime data;

	public LinkAchado() {
	}

	public LinkAchado(String url) {
		this.url = url;
		this.data = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
