package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="productos")
public class Producto {

	@Id
	private Long id;
	
	private String nombre;
	
	private double precio;
	
	private String marca;
	
	private String descripcion;
	
	
}
