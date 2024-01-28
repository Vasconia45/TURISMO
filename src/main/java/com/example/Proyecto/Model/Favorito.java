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

@Entity(name="favoritos")
public class Favorito {
	
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
	}
	

	@EmbeddedId
    private Id id = new Id();
	
	@ManyToOne
	@JoinColumn(
	name="pintxo_id",
	insertable = false, updatable = false)
	private Pintxo pintxo;
    
	@ManyToOne
	@JoinColumn(
	name="user_id",
	insertable = false, updatable = false)
	private User user;
	
	@CreationTimestamp
    private LocalDateTime createdOn;

	public Favorito(Pintxo pintxo, User user) {
		super();
		this.pintxo = pintxo;
		this.user = user;
		this.createdOn = LocalDateTime.now();
		this.id.pintxo_id = pintxo.getId();
		this.id.user_id = user.getId();
	}

	public Favorito() {
		super();
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
}
