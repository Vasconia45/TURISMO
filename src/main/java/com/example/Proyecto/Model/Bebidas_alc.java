package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="bebidas_alc")
public class Bebidas_alc extends Bebida{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double tasa_alc;
	
	private String tipo;
	
	private String prohibiciones;

	public Bebidas_alc() {
		super();
	}

	public Bebidas_alc(Long id, String nombre, int volumen, String marca, String descripcion, String origen, double tasa_alc, String tipo, String prohibiciones) {
		super(id, nombre, volumen, marca, descripcion, origen);
		this.tasa_alc = tasa_alc;
		this.tipo = tipo;
		this.prohibiciones = prohibiciones;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTasa_alc() {
		return tasa_alc;
	}

	public void setTasa_alc(double tasa_alc) {
		this.tasa_alc = tasa_alc;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getProhibiciones() {
		return prohibiciones;
	}

	public void setProhibiciones(String prohibiciones) {
		this.prohibiciones = prohibiciones;
	}
	
	
}
