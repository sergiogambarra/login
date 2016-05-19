package com.mitocode.model;
// default package
// Generated 24/01/2014 09:58:50 PM by Hibernate Tools 3.4.0.CR1

/**
 * Usuario generated by hbm2java
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usuario")  //mudança para conectar com a tabela correta
public class Usuario implements Serializable {
	
        @Id
        @GeneratedValue
	private int codUsuario;
	private String nombre;
	private String clave;	

	public Usuario() {
	}

	public Usuario(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	public Usuario(String nombre, String clave, Empleado empleado) {
		this.nombre = nombre;
		this.clave = clave;		
	}

	public int getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(Byte codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {		
		this.nombre = nombre;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
