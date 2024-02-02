package com.example.Proyecto.Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	private String nombre_usuario;
	
	private int phone;
	
	private String  email;
	
	private String password;
	
	private LocalDateTime createdOn;
	
	@Embedded
	private Direccion direccion;
	
	@ManyToOne()
	@JoinColumn(name="role_id")
	private Rol role;
	
	@OneToMany(mappedBy = "user", cascade =  CascadeType.REMOVE)
	private Set<Favorito> favoritos = new HashSet<>();
	
	@OneToMany(mappedBy = "userOp", cascade =  CascadeType.REMOVE)
	private Set<Opinion> opiniones = new HashSet<>();
	
	public User() {
		
	}

	public User(String nombre, String nombre_usuario, int phone, String email, String password) {
		super();
		this.nombre = nombre;
		this.nombre_usuario = nombre_usuario;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public User(String nombre, String nombre_usuario, int phone, String email, String password, LocalDateTime createdOn,
			Direccion direccion, Rol role) {
		super();
		this.nombre = nombre;
		this.nombre_usuario = nombre_usuario;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
		this.direccion = direccion;
		this.role = role;
	}
	
	public User(String nombre, String nombre_usuario, int phone, String email, String password, LocalDateTime createdOn,
			 Rol role) {
		super();
		this.nombre = nombre;
		this.nombre_usuario = nombre_usuario;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
		this.direccion = direccion;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Rol getRole() {
		return role;
	}

	public void setRole(Rol role) {
		this.role = role;
	}

	public Set<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Set<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public Set<Opinion> getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(Set<Opinion> opiniones) {
		this.opiniones = opiniones;
	}
}
