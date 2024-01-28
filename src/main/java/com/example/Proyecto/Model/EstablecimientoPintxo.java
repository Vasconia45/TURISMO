package com.example.Proyecto.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "establecimiento_pintxo")
public class EstablecimientoPintxo {
	
	@Embeddable
	public static class Id implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name="pintxo_id")
		private Long pintxo_id;
		
		@Column(name="establecimiento_id")
		private Long establecimiento_id;
		
		public Id() {
			
		}

		public Id(Long pintxo_id, Long establecimiento_id) {
			super();
			this.pintxo_id = pintxo_id;
			this.establecimiento_id = establecimiento_id;
		}
	}
	

	@EmbeddedId
    private Id id = new Id();

    private Double precioEnEstablecimiento;

	@ManyToOne
	@JoinColumn(
	name="pintxo_id",
	insertable = false, updatable = false)
	private Pintxo pintxo;
    
	@ManyToOne
	@JoinColumn(
	name="establecimiento_id",
	insertable = false, updatable = false)
	private Establecimiento establecimiento;
	
	public EstablecimientoPintxo() {
		
	}

	public EstablecimientoPintxo(Double precioEnEstablecimiento,Pintxo pintxo,
			Establecimiento establecimiento) {
		super();
		this.precioEnEstablecimiento = precioEnEstablecimiento;
		this.pintxo = pintxo;
		this.establecimiento = establecimiento;
		this.id.establecimiento_id = establecimiento.getId();
		this.id.pintxo_id = pintxo.getId();
	}

	public Double getPrecioEnEstablecimiento() {
		return precioEnEstablecimiento;
	}

	public void setPrecioEnEstablecimiento(Double precioEnEstablecimiento) {
		this.precioEnEstablecimiento = precioEnEstablecimiento;
	}
	
	
}
