package com.acsendo.exception;

import java.util.Date;
import java.util.List;

public class ExceptionResponse  {
	
	private Date timestamp;
	private String mensaje;
	private String detalle;
	private List<ErrorCampoValidacion> errors;
			
	public ExceptionResponse(Date timestamp, String mensaje, String detalle) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.detalle = detalle;
	}
	
	public ExceptionResponse(Date timestamp, String mensaje, List<ErrorCampoValidacion> errors, String detalle) {
		super();
		this.timestamp = timestamp;
		this.mensaje = mensaje;
		this.errors = errors;
		this.detalle = detalle;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public List<ErrorCampoValidacion> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorCampoValidacion> errors) {
		this.errors = errors;
	}
	
	
	

}
