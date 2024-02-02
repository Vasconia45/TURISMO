package com.example.Proyecto.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DireccionDTO {

	@NotNull
	private String calle;
	
	@NotNull
	private String cod_postal;
	
	@NotNull
	private String puerta;
}
