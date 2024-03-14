package com.example.Proyecto.Model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	private String username;

	private Integer phone;
	
	private String  email;
	
	private String password;
	
	private LocalDateTime createdOn;
	
	@Embedded
	private Direccion direccion;
	
	@ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_roles", 
	             joinColumns = @JoinColumn(name = "user_id"),
	             inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Rol> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade =  CascadeType.REMOVE)
	private Set<Favorito> favoritos = new HashSet<>();
	
	@OneToMany(mappedBy = "userOp", cascade =  CascadeType.REMOVE)
	private Set<Opinion> opiniones = new HashSet<>();
	
	public User() {
		
	}

	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}



	public User(String nombre, String username, Integer phone, String email, String password) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public User(String nombre, String username, Integer phone, String email, String password, LocalDateTime createdOn,
			Direccion direccion) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
		this.direccion = direccion;
	}
	
	public User(String nombre, String username, Integer phone, String email, String password, LocalDateTime createdOn) {
		super();
		this.nombre = nombre;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
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

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
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
