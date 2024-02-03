package com.example.Proyecto.Model;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name="establecimientos")
public class Establecimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	private String phone;
	
	private Year año_fundacion;
	
	@Embedded
	private Direccion direccion;

	@ManyToOne()
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;
	
	@OneToMany(mappedBy = "establecimiento", cascade = CascadeType.REMOVE)	
	private Set<EstablecimientoPintxo> establecimientosPintxos = new HashSet<>();

	public Establecimiento() {
		super();
	}

	public Establecimiento(String nombre, String phone, Year año_fundacion) {
		super();
		this.nombre = nombre;
		this.phone = phone;
		this.año_fundacion = año_fundacion;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
