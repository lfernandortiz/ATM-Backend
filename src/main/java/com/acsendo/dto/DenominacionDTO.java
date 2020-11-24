package com.acsendo.dto;

import java.time.LocalDateTime;

import com.acsendo.model.Denominacion;

/**
 * DTO usado para la carga de nuevas denominaciones
 * contiene la denominacion y la cantidad de billetes a cargar
 * @author LuisFernando
 *
 */
public class DenominacionDTO {

	private Denominacion denominacion;
	
	private int cantidad;
	
	private LocalDateTime fechaTx;

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
