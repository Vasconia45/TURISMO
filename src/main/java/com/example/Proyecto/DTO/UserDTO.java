package com.example.Proyecto.DTO;

import java.time.LocalDateTime;


import org.hibernate.validator.constraints.UniqueElements;

import com.example.Proyecto.Model.Direccion;
import com.example.Proyecto.Model.Rol;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long id;

	@NotNull
	@Size(min=4, max=8, message= "{Size.userdto.nombre}")
	private String nombre;
	
	@Null
	@Size(min=4, max=10, message= "{Size.userdto.nombre_usuario}")
	private String nombre_usuario;
	
	@Null
	private int phone;
	
	@NotNull
	@Email(message= "{Email.userdto.email}")
	private String  email;
	
	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!$¬#])[A-Za-z\\d@!$¬#]*$", message= "{Pattern.userdto.password}")
	private String password;
	
	@Null
	private LocalDateTime createdOn;
	
	@Null
	@UniqueElements
	private Direccion direccion;
	
	private Rol role;

	public UserDTO(String nombre,String nombre_usuario,int phone, String email,String password,LocalDateTime createdOn, 
			String calle, int cod_postal, String puerta, Rol role) {
		super();
		this.nombre = nombre;
		this.nombre_usuario = nombre_usuario;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
		this.direccion = new Direccion(calle, cod_postal, puerta);
		this.role = role;
	}
	
}
