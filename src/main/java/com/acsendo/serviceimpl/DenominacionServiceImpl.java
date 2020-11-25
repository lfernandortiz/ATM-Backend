package com.acsendo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsendo.dao.IDenominacionDAO;
import com.acsendo.model.Denominacion;
import com.acsendo.service.IDenominacionService;


@Service
public class DenominacionServiceImpl implements IDenominacionService {
	
	@Autowired
	private IDenominacionDAO repo;

	@Override
	public Denominacion registrar(Denominacion entity) {		
		return this.repo.save(entity);
	}

	@Override
	public void modificar(Denominacion entity) {
		
		this.repo.save(entity);
	}

	@Override
	public List<Denominacion> listar() {
		
		return this.repo.findAll();
	}

	@Override
	public Optional<Denominacion> leerPorid(Integer id) {
		
		return this.repo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.repo.deleteById(id);
		
		
	}

	@Override
	public Denominacion obtenerPorDenominacion(int idParam) {		
		return this.repo.obtenerPorDenominacion(idParam);
	}
	
	
	public boolean esMultiploDeMil(Integer valor) {
		return valor % 1000 == 0 ;
	}
	
		
	

}
