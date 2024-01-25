package com.example.Proyecto.Model;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="establecimientos")
public class Establecimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	private String telefono;
	
	private Year año_fundacion;
	
	@Embedded
	private Direccion direccion;

	@ManyToOne()
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;
	
	@OneToMany(mappedBy = "establecimiento")	
	private Set<EstablecimientoPintxo> establecimientosPintxos = new HashSet<>();
	
	@OneToMany(mappedBy = "establecimiento")	
	private Set<EstablecimientoBebida> establecimientosBebidas = new HashSet<>();

	public Establecimiento() {
		super();
	}

	public Establecimiento(String nombre, String telefono, Year año_fundacion, Direccion direccion, Ciudad ciudad) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.año_fundacion = año_fundacion;
		this.direccion = direccion;
		this.ciudad = ciudad;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Year getAño_fundacion() {
		return año_fundacion;
	}

	public void setAño_fundacion(Year año_fundacion) {
		this.año_fundacion = año_fundacion;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Set<EstablecimientoPintxo> getEstablecimientosPintxos() {
		return establecimientosPintxos;
	}

	public void setEstablecimientosPintxos(Set<EstablecimientoPintxo> establecimientosPintxos) {
		this.establecimientosPintxos = establecimientosPintxos;
	}
	
}
