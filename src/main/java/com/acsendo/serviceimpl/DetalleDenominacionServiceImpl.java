package com.acsendo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsendo.dao.IDetalleDenominacionDAO;
import com.acsendo.model.DetalleDenominacion;
import com.acsendo.service.IDetalleDenominacionService;


@Service
public class DetalleDenominacionServiceImpl implements IDetalleDenominacionService {
	
	@Autowired
	private IDetalleDenominacionDAO repo;
	
	

	@Override
	public DetalleDenominacion registrar(DetalleDenominacion entity) {
		
		return this.repo.save(entity);
	}

	@Override
	public void modificar(DetalleDenominacion entity) {
		this.repo.save(entity);

	}

	@Override
	public List<DetalleDenominacion> listar() {
		
		return this.repo.findAll();
	}

	@Override
	public Optional<DetalleDenominacion> leerPorid(Integer id) {
		
		return this.repo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		this.repo.deleteById(id);

	}

	@Override
	public List<Object[]> lisatarDetalleDenominaciones() {
		
		return this.repo.lisatarDetalleDenominaciones();
	}

	@Override
	public List<Object[]> saldosPorDenominacion() {		
		return this.repo.saldosPorDenominacion();
	}

	@Override
	public List<Object[]> inventarioSaldos() {		
		return this.repo.inventarioSaldos();
	}
	
	
	

}
