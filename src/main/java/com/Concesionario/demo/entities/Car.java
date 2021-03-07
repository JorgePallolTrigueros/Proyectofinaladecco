package com.Concesionario.demo.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="car")
public class Car implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	

	@ManyToMany(mappedBy="cars")
	private List<User> users = new ArrayList<>();
	

	private Integer code;
	

	

	



	
	
	@Column(name="model")
	private String model;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="description")
	private String description;
	
	
	@Column(name="urlImg")
	private String urlImg;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	


	@ManyToOne
	@JoinColumn(name = "id_manufacturer")
	private Manufacturer manufacturer;
    
    

	
	
	@ManyToMany
	@JoinTable(name = "car_etiqueta",
	joinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "etiqueta_id", referencedColumnName = "id"))
	private List<Etiqueta> etiquetas = new ArrayList<>();;
	
	@Column(name="price")
	private Double price;

	public Car() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImg() {
		return urlImg;
	}

	public void setUrlImg(String urlImg) {
		this.urlImg = urlImg;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public List<Etiqueta> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<Etiqueta> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    

	public Car(String model, String matricula,  String description, Manufacturer manufacturer) {
		super();
		this.model = model;
		this.matricula = matricula;
		this.description = description;
		this.manufacturer = manufacturer;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	 

}
