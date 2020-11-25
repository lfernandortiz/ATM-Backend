package com.acsendo.serviceimpl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsendo.dto.ListDenominacionDTO;
import com.acsendo.exception.GenericException;
import com.acsendo.service.IDetalleDenominacionService;
import com.acsendo.service.IRetiroService;

@Service
public class RetiroServiceImpl implements IRetiroService {
	
	
	@Autowired
	private IDetalleDenominacionService detalleService;
	
	public Integer realizarRetiro( int valorRetiro ){
		
		
		Integer saldo = this.saldoCajero();
		
		
		
		//valida si hay saldo en el cajero para el retiro
		if( this.saldoCajero() < valorRetiro ) {			
			throw new GenericException("El cajero no cuenta con el saldo suficiente para el valor solicitado");
		}else {
			
			
		}
		
		
		
		
		
		//valida que las denominaciones existentes puedan cubrir le valor del retiro
		
		
		
		
		//genera el list de billetes a entregar
		
		
		
		return saldo;
		
	}
	
	
	
	
	
	public Integer saldoCajero() {
		
		Integer  total = 0;
		
		List<Object[]> result = this.detalleService.saldosPorDenominacion();
				
		for(Object [] e : result ) {
			total += ((BigInteger) e[1]).intValue();
		}
		
		return total;
		
	}

}
