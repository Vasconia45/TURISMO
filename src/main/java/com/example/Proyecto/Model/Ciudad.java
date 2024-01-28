package com.example.Proyecto.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name="ciudades")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String provincia;
	
	private int num_poblacion;
	
	private String descripcion;

	@OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL)
	private List<Establecimiento> establecimientos;

	public Ciudad() {
		super();
	}

	public Ciudad(String nombre, String provincia, int num_poblacion, String descripcion) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.num_poblacion = num_poblacion;
		this.descripcion = descripcion;
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getNum_poblacion() {
		return num_poblacion;
	}

	public void setNum_poblacion(int num_poblacion) {
		this.num_poblacion = num_poblacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Establecimiento> getEstablecimientos() {
		return establecimientos;
	}

	public void setEstablecimientos(List<Establecimiento> establecimientos) {
		this.establecimientos = establecimientos;
	}
	
}
