package com.acsendo.serviceimpl;

import java.math.BigInteger;
import java.util.ArrayList;
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
		}		
		
		//valida que las denominaciones existentes puedan cubrir le valor del retiro
		//
		List<Object[]> inventario = this.detalleService.inventarioSaldos();
		
		Integer saldoFinal = valorRetiro ;
		
		List<ListDenominacionDTO> efectivo = new ArrayList<>();
		
		for(Object[] denominacionActual : inventario) {
			
			//denominacionActual[0] La denominacion
			//denominacionActual[1] El inventario
			//denominacionActual[2] Saldo para la denominacion actual 			
			
			Integer nuevoSaldo= 0;
			Integer cantidadBilletes = 0;
			//El nuevo saldo se obtiene de restar al saldoFinal el saldo de la Denominacion denominacionActual[2]
			nuevoSaldo = saldoFinal - ((BigInteger)denominacionActual[2]).intValue();
			
			//si el nuevo saldo es negativo o cero obtengo las cantidad de billetes para cubrir el retircon con la denominacion actual
			if( nuevoSaldo <= 0 ) {
				cantidadBilletes = (int) Math.ceil( saldoFinal / ((BigInteger)denominacionActual[0]).intValue());
			}
			//si el nuevo saldo es positivo agregro los billestes disponibles para la denominacion actual
			if( nuevoSaldo > 0 ) {
				cantidadBilletes = ((BigInteger)denominacionActual[1]).intValue();
			}
			//obtiene el saldo final para la actual denominacion 
			saldoFinal = nuevoSaldo - ( cantidadBilletes * ((BigInteger)denominacionActual[0]).intValue());
			
			ListDenominacionDTO denominacion = new ListDenominacionDTO();
			denominacion.setDenominacion(((BigInteger)denominacionActual[0]).intValue());
			denominacion.setTotal(cantidadBilletes);			
			
		}
		
		if( saldoFinal == 0 ) {
			
		}else {
			throw new GenericException("El cajero no cuenta con las denominaciones para dispensar su retiro");
		}
		
		
		
		
		
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
