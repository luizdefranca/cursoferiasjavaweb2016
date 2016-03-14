package org.eleicoes2014.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eleicoes2014.alerta.Alerta;
import org.eleicoes2014.alerta.Alerta;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {    
	
	private static Configuration instance;
	
	private String accessToken           ;
	private String accessTokenSecret     ;
	private String consumerkey           ;
	private String consumerSecret        ;
	private String password              ;
	private String user                  ;
	private List<String> usuariosSeguidos;
	private String email                 ;
	private List<Alerta> alertas         ;
	private String jobAtualizaTweetsCronExpression;
	
	
	public static Configuration getInstance() throws IOException {
		if(instance == null) {
			
			String jsonConfig = readJsonFile();
			
			instance = new Gson().
					fromJson(jsonConfig, Configuration.class);
		}
		
		return instance;
	}
	
	
	private Configuration() throws IOException {
		
	}
	
	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Configuration config = getInstance();
		
		System.out.println(config.accessToken);
	}
	
	private static String readJsonFile() throws IOException {
		String path = 
			Configuration.class.getResource(
					"/Twitter.config.json").getPath();
		
		String jsonConfig = 
				FileUtils.readFileToString(new File(path));
		
		return jsonConfig;
	}
	
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}
	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	public String getConsumerkey() {
		return consumerkey;
	}
	public void setConsumerkey(String consumerkey) {
		this.consumerkey = consumerkey;
	}
	public String getConsumerSecret() {
		return consumerSecret;
	}
	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public List<String> getUsuariosSeguidos() {
		return usuariosSeguidos;
	}
	public void setUsuariosSeguidos(List<String> usuariosSeguidos) {
		this.usuariosSeguidos = usuariosSeguidos;
	}
	public List<Alerta> getAlertas() {
		return alertas;
	}
	public void setAlertas(List<Alerta> alertas) {
		this.alertas = alertas;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getJobAtualizaTweetsCronExpression() {
		return jobAtualizaTweetsCronExpression;
	}


	public void setJobAtualizaTweetsCronExpression(
			String jobAtualizaTweetsCronExpression) {
		this.jobAtualizaTweetsCronExpression = jobAtualizaTweetsCronExpression;
	}
}
