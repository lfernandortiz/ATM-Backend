package com.acsendo.controller;


import java.math.BigInteger;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acsendo.dto.DenominacionDTO;
import com.acsendo.dto.ListDenominacionDTO;
import com.acsendo.exception.ModelNotFoundException;
import com.acsendo.model.Denominacion;
import com.acsendo.model.DetalleDenominacion;
import com.acsendo.service.IDenominacionService;
import com.acsendo.service.IDetalleDenominacionService;


@RestController
@RequestMapping("/v1/denominaciones")
public class DenominacionController {

	Logger logger = LoggerFactory.getLogger(DenominacionController.class);

	@Autowired
	private IDenominacionService service;
	
	@Autowired
	private IDetalleDenominacionService detalleService;
	
	


	@GetMapping
	public ResponseEntity<List<Denominacion>> listarDenominacion() {

		List<Denominacion> lista = this.service.listar();

		logger.info("Listando Denominacion");

		return new ResponseEntity<List<Denominacion>>(lista, HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Denominacion> registrar(@Valid @RequestBody DenominacionDTO entity) {

		Denominacion obj = null;
		if (entity != null) {
			
			//Validamos que exista esta denominacion
			Denominacion persist = this.service.obtenerPorDenominacion(entity.getDenominacion().getValorDescripcion()); 
			
			if( persist == null ) {
				// si no existe la creamos				
				obj = this.service.registrar(entity.getDenominacion());
				
				//luego registramos el movimiento de su inventario
				DetalleDenominacion detalle = new DetalleDenominacion();
				detalle.setDenominacion(obj);
				detalle.setCantidad(entity.getCantidad());
				detalle.setFechaTx(entity.getFechaTx());
				
				this.detalleService.registrar(detalle);
				
			}else{//si no insertamos solamente un registro en el inventario de efectivo

				obj = persist;				
				//luego registramos el movimiento de su inventario
				DetalleDenominacion detalle = new DetalleDenominacion();
				detalle.setDenominacion(obj);
				detalle.setCantidad(entity.getCantidad());
				detalle.setFechaTx(entity.getFechaTx());
				
				this.detalleService.registrar(detalle);		
								
			}
			
		}
		logger.info("Registrando Denominacion");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdDenominacion()).toUri();
		
		return new ResponseEntity<Denominacion>(obj, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Denominacion> modificar(@RequestBody Denominacion entity) {

		Denominacion obj = null;
		if (entity != null) {

			this.service.modificar(entity);
			Optional<Denominacion> optional = this.service.leerPorid(entity.getIdDenominacion());
			obj = optional.get();
		}
		logger.info("Actualizando Mina");
		return new ResponseEntity<Denominacion>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {

		Optional<Denominacion> obj = this.service.leerPorid(id);

		if (!obj.isPresent()) {
			logger.info("Denominacion no encontrada con nit: " + obj.get().getIdDenominacion());
			throw new ModelNotFoundException("ID (" + id + ") no encontrado para Eliminar");
		} else {
			logger.info("Eliminando Denominacion con id: " +obj.get().getIdDenominacion());
			this.service.eliminar(id);
		}

		return new ResponseEntity<Object>(obj.get(), HttpStatus.OK);
	}
	
	
	@GetMapping("/listardetalledenominaciones")
	public List<ListDenominacionDTO> lisatarDetalleDenominaciones() {
		List<ListDenominacionDTO> resp = new ArrayList<>();
		
		this.detalleService.lisatarDetalleDenominaciones().forEach( e -> {
			resp.add( new ListDenominacionDTO( ((Integer) e[0]).intValue(), ((BigInteger) e[1]).intValue() ));
		});
		
		return resp;
	}

}
