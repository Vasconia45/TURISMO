package com.example.Proyecto.Model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {
	
	private String calle;
	
	private String cod_postal;
	
	private String puerta;
	
	public Direccion() {
		
	}

	public Direccion(String calle, String cod_postal, String puerta) {
		super();
		this.calle = calle;
		this.cod_postal = cod_postal;
		this.puerta = puerta;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	
}
