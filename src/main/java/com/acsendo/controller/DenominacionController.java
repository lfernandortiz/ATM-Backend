package com.acsendo.controller;

import java.net.URI;
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

import com.acsendo.exception.ModelNotFoundException;
import com.acsendo.model.Denominacion;
import com.acsendo.service.IDenominacionService;

@RestController
@RequestMapping("/v1/denominaciones")
public class DenominacionController {

	Logger logger = LoggerFactory.getLogger(DenominacionController.class);

	@Autowired
	private IDenominacionService service;

	@GetMapping
	public ResponseEntity<List<Denominacion>> listarDenominacion() {

		List<Denominacion> lista = this.service.listar();

		logger.info("Listando Denominacion");

		return new ResponseEntity<List<Denominacion>>(lista, HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Denominacion> registrar(@Valid @RequestBody Denominacion entity) {

		Denominacion obj = null;
		if (entity != null) {
			obj = this.service.registrar(entity);
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

}
