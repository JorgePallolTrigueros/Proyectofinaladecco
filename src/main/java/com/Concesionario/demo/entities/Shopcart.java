package com.Concesionario.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shopcart")
public class Shopcart implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany
	@JoinTable(name = "shopcart_car",
	joinColumns = @JoinColumn(name = "shopcart_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
	private List<Car> cars = new ArrayList<>();
	

	public Shopcart() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Car> getCars() {
		return cars;
	}


	public void setCars(List<Car> cars) {
		this.cars = cars;
	}


	@Override
	public String toString() {
		return "Shopcart [id=" + id + ", user=" + user + ", cars=" + cars + "]";
	}
	
}