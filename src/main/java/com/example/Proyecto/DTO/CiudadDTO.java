package com.example.Proyecto.DTO;

import java.time.Year;
import java.util.List;

import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Establecimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CiudadDTO {

	private Long id;
	
	private String nombre;
	
	private String provincia;
	
	private String descripcion;

	private List<Establecimiento> establecimientos;

	public CiudadDTO(String nombre, String provincia, String descripcion) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.descripcion = descripcion;
		this.establecimientos = establecimientos;
	}
	
}
