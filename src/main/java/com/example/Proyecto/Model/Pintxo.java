package com.example.Proyecto.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="pintxos")
public class Pintxo {

	@Id
	private Long id;
	
	private String tipo;
	
	private String inredientes;
	
	private String extra;
}
