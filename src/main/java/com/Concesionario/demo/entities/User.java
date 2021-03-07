package com.Concesionario.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	private String name;
	
	private String email;
	
	private Integer age;
	
	
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="direction_id")
	private Direction direction;
	

	@ManyToMany
	@JoinTable(name = "user_car",
	joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"))
	private List<Car> cars = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<Shopcart> shopcarts = new ArrayList<>();

public User() {}
	public User(String name, String email, Integer age, Boolean married, String password, List<Car> cars) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
		this.cars = cars;
	}
	public User(String name, String email, Integer age, Boolean married, String password) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
	}

	public List<Shopcart> getShopcarts() {
		return shopcarts;
	}
	public void setShopcarts(List<Shopcart> shopcarts) {
		this.shopcarts = shopcarts;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ","
				+ ", password=" + password +  ", direction= " + direction + "]";
	}
	
	

}