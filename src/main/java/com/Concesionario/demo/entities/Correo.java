package com.Concesionario.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="correo")
public class Correo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="correo_emisor")
	private String correo_emisor;
	
	@Column(name="contenido")
	private String contenido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorreo_emisor() {
		return correo_emisor;
	}

	public void setCorreo_emisor(String correo_emisor) {
		this.correo_emisor = correo_emisor;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Correo(String name, String correo_emisor, String contenido) {
		super();
		this.name = name;
		this.correo_emisor = correo_emisor;
		this.contenido = contenido;
	}	
	
	public Correo() {

	}	
	
	
}
