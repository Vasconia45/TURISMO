package com.example.Proyecto.DTO;

import java.time.Year;
import java.util.Set;

import com.example.Proyecto.Model.Ciudad;
import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Establecimiento;
import com.example.Proyecto.Model.Pintxo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PintxoDTO {

	private Long id;
	
	private String nombre;
	
	private String ingredientes;
	
	private String extra;
	
	private Set<Establecimiento> establecimientos;

	public PintxoDTO(String nombre, String ingredientes, String extra) {
		super();
		this.nombre = nombre;
		this.ingredientes = ingredientes;
		this.extra = extra;
	}
}
