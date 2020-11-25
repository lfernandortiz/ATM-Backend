package com.acsendo.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.acsendo.model.Denominacion;

public interface IDenominacionService  extends ICRUD<Denominacion> {
	
	Denominacion obtenerPorDenominacion( int idParam);
	
	boolean esMultiploDeMil(Integer valor);

}
