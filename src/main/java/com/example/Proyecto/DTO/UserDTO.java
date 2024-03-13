package com.example.Proyecto.DTO;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

	/*@NotNull
	@Size(min=4, max=8, message= "{Size.userdto.nombre}")*/
	private String nombre;
	
	//@NotNull
	private String username;

	private Integer phone;
	
	//@NotNull
	//@Email(message= "{Email.userdto.email}")
	private String  email;
	
	//@NotNull
	//@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@!$¬#])[A-Za-z\\d@!$¬#]*$", message= "{Pattern.userdto.password}")
	private String password;
	
	//@CreationTimestamp
	//@Null
	private LocalDateTime createdOn;
	
	private Direccion direccion;
	
	//@NotNull
	private Rol role;

	public UserDTO(String nombre,String username,Integer phone, String email,String password) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public UserDTO(String username) {
		super();
		this.username = username;
	}
	
	
	
}
