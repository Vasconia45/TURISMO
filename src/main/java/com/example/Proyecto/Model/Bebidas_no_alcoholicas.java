package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="bebidas_no_alc")
public class Bebidas_no_alcoholicas extends Bebida{

	@Id
	private Long id;
	
	private double pureza;

	public Bebidas_no_alcoholicas() {
		super();
	}

	public Bebidas_no_alcoholicas(String nombre, int volumen, String marca, String descripcion, String origen, double pureza) {
		super(nombre, volumen, marca, descripcion, origen);
		this.pureza = pureza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPureza() {
		return pureza;
	}

	public void setPureza(double pureza) {
		this.pureza = pureza;
	}
	
	
}
