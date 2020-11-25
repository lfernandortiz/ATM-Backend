package com.acsendo.service;

import java.util.List;


import com.acsendo.model.DetalleDenominacion;

public interface IDetalleDenominacionService extends ICRUD<DetalleDenominacion> {

	
	List<Object[]> lisatarDetalleDenominaciones();
	
	List<Object[]> saldosPorDenominacion();
	
	List<Object[]> inventarioSaldos();
}
