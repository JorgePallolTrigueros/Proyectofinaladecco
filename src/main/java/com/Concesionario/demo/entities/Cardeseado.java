package com.Concesionario.demo.entities;

import java.awt.geom.Arc2D.Double;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="Cardeseado")
public class Cardeseado implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="preciofinal")
	private Integer preciofinal;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="color_id")
    private Color color;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="acabado_id")
    private Acabados acabado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="motor_id")
    private Motor motor;

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

	public Integer getPreciofinal() {
		return preciofinal;
	}

	public void setPreciofinal(Integer preciofinal) {
		this.preciofinal = preciofinal;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Acabados getAcabado() {
		return acabado;
	}

	public void setAcabado(Acabados acabado) {
		this.acabado = acabado;
	}

	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cardeseado(Long id, String descripcion, Integer preciofinal, Color color, Acabados acabado, Motor motor) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.preciofinal = preciofinal;
		this.color = color;
		this.acabado = acabado;
		this.motor = motor;
	}

	
	public Cardeseado() {

	}
	
	
}
