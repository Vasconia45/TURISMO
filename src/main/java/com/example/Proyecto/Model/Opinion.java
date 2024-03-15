package com.example.Proyecto.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="opiniones")
public class Opinion {

	@Embeddable
	public static class Id implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name="pintxo_id")
		private Long pintxo_id;
		
		@Column(name="user_id")
		private Long user_id;
		
		public Id() {
			
		}

		public Id(Long pintxo_id, Long user_id) {
			super();
			this.pintxo_id = pintxo_id;
			this.user_id = user_id;
		}

		public Long getPintxo_id() {
			return pintxo_id;
		}

		public void setPintxo_id(Long pintxo_id) {
			this.pintxo_id = pintxo_id;
		}

		public Long getUser_id() {
			return user_id;
		}

		public void setUser_id(Long user_id) {
			this.user_id = user_id;
		}
		
		
	}
	

	@EmbeddedId
    private Id id = new Id();
	
	@ManyToOne
	@JoinColumn(
	name="pintxo_id",
	insertable = false, updatable = false)
	private Pintxo pintxoOp;
    
	@ManyToOne
	@JoinColumn(
	name="user_id",
	insertable = false, updatable = false)
	private User userOp;
	
	@CreationTimestamp
    private LocalDateTime createdOn;
	
	private String comentario;
	
	private int valoracion;

	public Opinion(Pintxo pintxo, User user, String comentario, int valoracion) {
		super();
		this.pintxoOp = pintxo;
		this.userOp = user;
		this.createdOn = LocalDateTime.now();
		this.comentario = comentario;
		this.valoracion = valoracion;
		this.id.pintxo_id = pintxo.getId();
		this.id.user_id = user.getId();
	}

	public Opinion() {
		super();
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public Pintxo getPintxoOp() {
		return pintxoOp;
	}

	public void setPintxoOp(Pintxo pintxoOp) {
		this.pintxoOp = pintxoOp;
	}

	public User getUserOp() {
		return userOp;
	}

	public void setUserOp(User userOp) {
		this.userOp = userOp;
	}

	public Id getId() {
		return id;
	}

	public void setId(Long pintxo_id, Long user_id) {
		this.id.setPintxo_id(pintxo_id);
		this.id.setUser_id(user_id);
	}
	
	
}
