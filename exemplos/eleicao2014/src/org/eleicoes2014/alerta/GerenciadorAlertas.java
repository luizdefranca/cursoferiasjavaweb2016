package org.eleicoes2014.alerta;

import java.io.IOException;
import java.util.List;

import org.eleicoes2014.config.Configuration;

public class GerenciadorAlertas {

	private static GerenciadorAlertas instance;
	
	private List<Alerta> alertas;
	

	public static GerenciadorAlertas newGerenciadorAlertas() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		if (instance == null) {
			instance = new GerenciadorAlertas();
		}
		
		return instance;
	}
	
	
	private GerenciadorAlertas() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		alertas  = 
				Configuration.getInstance().getAlertas();
	}
	
	
	public boolean containFilters(String tweet) {
		
		for (Alerta alerta : alertas) {
			if (!alerta.containFilters(tweet)) {
				return false;
			}
		}
		
		return true;
	}
	
}
