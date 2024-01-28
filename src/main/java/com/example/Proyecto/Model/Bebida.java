package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="bebidas")
public class Bebida {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected String nombre;
	
	protected int volumen;
	
	protected String marca;
	
	protected String descricpion;
	
	protected String origen;

	public Bebida() {
		super();
	}
	
	public Bebida(Long id, String nombre, int volumen, String marca, String descricpion, String origen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.volumen = volumen;
		this.marca = marca;
		this.descricpion = descricpion;
		this.origen = origen;
	}

	public Bebida(String nombre, int volumen, String marca, String descricpion, String origen) {
		super();
		this.nombre = nombre;
		this.volumen = volumen;
		this.marca = marca;
		this.descricpion = descricpion;
		this.origen = origen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricpion() {
		return descricpion;
	}

	public void setDescricpion(String descricpion) {
		this.descricpion = descricpion;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	
}
