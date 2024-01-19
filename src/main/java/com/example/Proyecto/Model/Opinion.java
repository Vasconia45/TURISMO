package com.example.Proyecto.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="opiniones")
public class Opinion {

	@Id
	private Long id;
	
	private String comentario;
	
	private double valoración;
	
	private LocalDate createdOn;
}
