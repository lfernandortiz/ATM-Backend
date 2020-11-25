package com.acsendo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.acsendo.model.DetalleDenominacion;

public interface IDetalleDenominacionDAO extends JpaRepository<DetalleDenominacion, Integer> {
	
	
	@Query( value = "select denominacion.valordescripcion, sum(detalledenominacion.cantidad) "
			+ "FROM\r\n " + 
			"  denominacion\r\n " + 
			"  INNER JOIN detalledenominacion ON (denominacion.id_denominacion = detalledenominacion.id_denominacion) group by 1 order by 1 ASC", nativeQuery = true)
	List<Object[]> lisatarDetalleDenominaciones();
	
	//Obtiene los saldos por denominacion
	@Query( value = " SELECT\r\n" + 
			"denominacion.valordescripcion,\r\n" + 
			"CASE when  sum(detalledenominacion.cantidad) > 0 then sum(detalledenominacion.cantidad) * denominacion.valordescripcion else 0 end  \r\n" + 
			"FROM\r\n" + 
			"denominacion\r\n" + 
			"  INNER JOIN detalledenominacion ON (denominacion.id_denominacion = detalledenominacion.id_denominacion)  \r\n" + 
			"GROUP by 1\r\n" + 
			"ORDER by 1 asc ", nativeQuery = true)
	List<Object[]> saldosPorDenominacion();
	
	
	
	//Obtener las denominaciones de mayor a menor CON inventario con su saldo 
	@Query( value = "SELECT\r\n" + 
			"denominacion.valordescripcion as denominacion,\r\n" + 
			"SUM (detalledenominacion.cantidad ) as inventario,\r\n" + 
			"denominacion.valordescripcion * SUM (detalledenominacion.cantidad ) as saldo\r\n" + 
			"  \r\n" + 
			"FROM\r\n" + 
			"denominacion\r\n" + 
			"  INNER JOIN detalledenominacion ON (denominacion.id_denominacion = detalledenominacion.id_denominacion)  \r\n" + 
			"GROUP by 1\r\n" + 
			"HAVING SUM(detalledenominacion.cantidad ) >0\r\n" + 
			"ORDER by 1 DESC", nativeQuery = true)
	List<Object[]> inventarioSaldos();
	
	
	
	
	
}
