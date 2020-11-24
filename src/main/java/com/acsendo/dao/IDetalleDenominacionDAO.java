package com.acsendo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acsendo.model.DetalleDenominacion;

public interface IDetalleDenominacionDAO extends JpaRepository<DetalleDenominacion, Integer> {

}
