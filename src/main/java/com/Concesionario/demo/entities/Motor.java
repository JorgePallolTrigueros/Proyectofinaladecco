




package com.Concesionario.demo.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="motor")
public class Motor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="coste")
	private String coste;
	
	@OneToOne(mappedBy="motor")
	private Cardeseado cardeseado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}

	public Cardeseado getCardeseado() {
		return cardeseado;
	}

	public void setCardeseado(Cardeseado cardeseado) {
		this.cardeseado = cardeseado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Motor(String descripcion, String coste) {
		super();
		this.descripcion = descripcion;
		this.coste = coste;
	}
	
	public Motor() {
	}
	
	
	
	
}