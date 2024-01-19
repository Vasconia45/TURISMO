package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="bebidas_no_alc")
public class Bebidas_no_alcoholicas {

	@Id
	private int id;
	
	private double pureza;
}
