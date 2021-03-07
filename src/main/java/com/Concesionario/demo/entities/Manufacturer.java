package com.Concesionario.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



@Entity
@Table(name="manufacturer")
public class Manufacturer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String name;
	
	


	@OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL)
	private List<Car> cars = new ArrayList<Car>();
    

    
    
	
	@Column(name = "cif")
	private String cif;
	
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "num_empleados")
	private Integer numEmployees;
	
	

	
	public Manufacturer() {}
	
	public Manufacturer( String cif, String name, String direction,
			Integer numEmployees) {
		this.cif = cif;
		this.name = name;
		this.direction = direction;
		this.numEmployees = numEmployees;

	}

	
	
	
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

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}


	public Integer getNumEmployees() {
		return numEmployees;
	}

	public void setNumEmployees(Integer numEmployees) {
		this.numEmployees = numEmployees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
}