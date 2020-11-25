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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valorDescripcion == null) ? 0 : valorDescripcion.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denominacion other = (Denominacion) obj;
		if (valorDescripcion == null) {
			if (other.valorDescripcion != null)
				return false;
		} else if (!valorDescripcion.equals(other.valorDescripcion))
			return false;
		return true;
	}
	
	
	

}
