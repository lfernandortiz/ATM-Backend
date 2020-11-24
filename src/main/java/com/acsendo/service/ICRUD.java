package com.acsendo.service;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz generica para usada para implementar las operacion CRUD de una entidad
 * @author LuisFernando
 *
 * @param <T>
 */
public interface ICRUD<T> {
	
	T registrar(T entity);
	
	void modificar(T entity);
	
	List<T> listar();
	
	Optional<T> leerPorid( Integer id);
	
	void eliminar( Integer id );

}
