package com.acsendo.service;

import java.util.List;

import com.acsendo.dto.ListDenominacionDTO;

public interface IRetiroService {
	
	List<ListDenominacionDTO> realizarRetiro( int valorRetiro );
	
	Integer saldoCajero();

}
