package com.acsendo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


@Entity
@Table(name = "detalledenominacion")
public class DetalleDenominacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleDenominacion;
	
	@ManyToOne
	@JoinColumn(name = "id_denominacion", nullable = false, foreignKey = @ForeignKey(name = "fk_denominacion_detalledenominacion"))
	private Denominacion denominacion;
	
	@Column(name = "cantidad", nullable= false)
	private int cantidad;	
	
	@Column(name = "fechatx", nullable = false)
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaTx;

	public int getIdDetalleDenominacion() {
		return idDetalleDenominacion;
	}

	public void setIdDetalleDenominacion(int idDetalleDenominacion) {
		this.idDetalleDenominacion = idDetalleDenominacion;
	}

	public Denominacion getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(Denominacion denominacion) {
		this.denominacion = denominacion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFechaTx() {
		return fechaTx;
	}

	public void setFechaTx(LocalDateTime fechaTx) {
		this.fechaTx = fechaTx;
	}

	
	

}
