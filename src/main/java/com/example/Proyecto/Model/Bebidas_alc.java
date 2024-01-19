package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="bebidas_alc")
public class Bebidas_alc {

	@Id
	private int id;
	
	private double tasa_alc;
	
	private String tipo;
	
	private String prohibiciones;
}
