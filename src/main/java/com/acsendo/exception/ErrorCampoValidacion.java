package com.acsendo.exception;

/**
 * Esta clase auxiliar permite conocer el campo
 * que genero la excepcion y su correspondiente mensaje.
 * Es usado en la clase ResponseExceptionHandler para 
 * crear las respuesta de las excepciones en la API.
 * @author Luis Fernando Ortiz Vera
 *
 */
public class ErrorCampoValidacion {
	
	private String campo;
	private String mensaje;
	
	public ErrorCampoValidacion(String campo, String mensaje) {
		super();
		this.campo = campo;
		this.mensaje = mensaje;
	}
	
	public String getCampo() {
		return campo;
	}
	
	public void setCampo(String campo) {
		this.campo = campo;
	}
	
	public String getMensaje() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
