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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.acsendo.service.IRetiroService;

@RestController
@RequestMapping("/v1/retiros")
public class RetiroController  {
	
	
	
		
		Logger logger = LoggerFactory.getLogger(RetiroController.class);
		
		@Autowired
		private IRetiroService service;
		
		@PostMapping		
		public ResponseEntity<Integer> retiroDinero( @RequestBody Integer valor) {
			
			Integer saldo  = this.service.realizarRetiro(valor);
			
			logger.info("Realizadon retiro en el cajero");
			
			return new ResponseEntity<Integer>(saldo, HttpStatus.OK);
		}
		
		
		
		

}
