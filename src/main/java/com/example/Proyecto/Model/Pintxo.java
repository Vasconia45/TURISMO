package com.example.Proyecto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="pintxos")
public class Pintxo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String ingredientes;
	
	@OneToMany(mappedBy = "pintxo", cascade = CascadeType.REMOVE)
	private Set<EstablecimientoPintxo> establecimientosPintxos = new HashSet<>();
	
	@OneToMany(mappedBy = "pintxo", cascade =  CascadeType.REMOVE)
	private Set<Favorito> favoritos = new HashSet<>();
	
	@OneToMany(mappedBy = "pintxoOp", cascade =  CascadeType.REMOVE)
	private Set<Opinion> opiniones = new HashSet<>();

	public Pintxo() {
		super();
	}
	
	public Pintxo(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Pintxo(String nombre, String ingredientes) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setTipo(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public Set<EstablecimientoPintxo> getEstablecimientosPintxos() {
		return establecimientosPintxos;
	}

	public void setEstablecimientosPintxos(Set<EstablecimientoPintxo> establecimientosPintxos) {
		this.establecimientosPintxos = establecimientosPintxos;
	}

	public Set<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Set<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public Set<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(Set<Opinion> opiniones) {
		this.opiniones = opiniones;
	}
	
	
}
