package com.example.Proyecto.DTO;

import java.time.Year;
import java.util.Set;

import org.hibernate.validator.constraints.UniqueElements;

import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Pintxo;

import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstablecimientoDTO {

	private Long id;
	
	private String nombre;
	
	private String telefono;
	
	private Year año_fundacion;
	
	@Null
	@UniqueElements
	private Direccion direccion;

	private Ciudad ciudad;
	
	private Set<Pintxo> pintxos;

	public EstablecimientoDTO(String nombre, String telefono, Year año_fundacion, Direccion direccion, Ciudad ciudad) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.año_fundacion = año_fundacion;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}
	
	public EstablecimientoDTO(Long id, String nombre, String telefono, Year año_fundacion, Direccion direccion, Ciudad ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.año_fundacion = año_fundacion;
		this.direccion = direccion;
		this.ciudad = ciudad;
	}
}
