package com.acsendo.service;

import java.util.List;

import com.acsendo.dto.ListDenominacionDTO;
import com.acsendo.model.DetalleDenominacion;

public interface IDetalleDenominacionService extends ICRUD<DetalleDenominacion> {

	
	List<Object[]> lisatarDetalleDenominaciones();
	
	List<Object[]> saldosPorDenominacion();
}
