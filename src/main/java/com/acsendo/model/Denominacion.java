package com.acsendo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "denominacion")
public class Denominacion {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDenominacion;
	
	
	
	@Column(name = "valordescripcion", nullable= false)
	private Integer valorDescripcion;


	public int getIdDenominacion() {
		return idDenominacion;
	}


	public void setIdDenominacion(int idDenominacion) {
		this.idDenominacion = idDenominacion;
	}


	public Integer getValorDescripcion() {
		return valorDescripcion;
	}


	public void setValorDescripcion(Integer valorDescripcion) {
		this.valorDescripcion = valorDescripcion;
	}
	
	
	

}
