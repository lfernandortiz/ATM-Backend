package com.acsendo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acsendo.model.Denominacion;


public interface IDenominacionDAO extends JpaRepository <Denominacion, Integer>{
	
	@Query( "from Denominacion d where d.valorDescripcion = :idParam ")
	Denominacion validaExisteDenominacion(@Param("idParam") int idParam);

}
