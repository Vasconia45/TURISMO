package com.example.Proyecto.Model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "establecimiento_bebida")
public class EstablecimientoBebida {

	@Embeddable
	public static class Id implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name="bebida_id")
		private Long bebida_id;
		
		@Column(name="establecimiento_id")
		private Long establecimiento_id;
		
		public Id() {
			
		}

		public Id(Long bebida_id, Long establecimiento_id) {
			super();
			this.bebida_id = bebida_id;
			this.establecimiento_id = establecimiento_id;
		}
	}
	
	@EmbeddedId
    private Id id = new Id();

    private Double precioEnEstablecimiento;
    
    @ManyToOne
	@JoinColumn(
	name="bebida_id",
	insertable = false, updatable = false)
	private Bebida bebida;
    
	@ManyToOne
	@JoinColumn(
	name="establecimiento_id",
	insertable = false, updatable = false)
	private Establecimiento establecimiento;

	public EstablecimientoBebida() {
		super();
	}

	public EstablecimientoBebida(Double precioEnEstablecimiento, Bebida bebida,
			Establecimiento establecimiento) {
		super();
		this.precioEnEstablecimiento = precioEnEstablecimiento;
		this.bebida = bebida;
		this.establecimiento = establecimiento;
		this.id.establecimiento_id = establecimiento.getId();
		this.id.bebida_id = bebida.getId();
	}

	public Double getPrecioEnEstablecimiento() {
		return precioEnEstablecimiento;
	}

	public void setPrecioEnEstablecimiento(Double precioEnEstablecimiento) {
		this.precioEnEstablecimiento = precioEnEstablecimiento;
	}
	
	
}
