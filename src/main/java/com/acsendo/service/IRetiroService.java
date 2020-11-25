package com.acsendo.service;

import java.util.List;

import com.acsendo.dto.ListDenominacionDTO;

public interface IRetiroService {
	
	Integer realizarRetiro( int valorRetiro );
	
	Integer saldoCajero();

}
