package com.acsendo.dto;



public class ListDenominacionDTO {
	
	private Integer denominacion;
	
	private Integer total;
	
	public ListDenominacionDTO(){};
		
	public ListDenominacionDTO(Integer denominacion, Integer total) {
		super();
		this.denominacion = denominacion;
		this.total = total;
	}

	public Integer getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(Integer denominacion) {
		this.denominacion = denominacion;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	
	
	

	

	
	
	
	
	
	
	
	
	
	
	

}
