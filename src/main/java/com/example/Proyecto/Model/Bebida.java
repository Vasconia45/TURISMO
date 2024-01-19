package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="bebidas")
public class Bebida {

	@Id
	private Long id;
	
	private String nombre;
	
	private int volumen;
	
	private String marca;
	
	private double precio;
	
	private String descricpion;
	
	private String origen;
}
