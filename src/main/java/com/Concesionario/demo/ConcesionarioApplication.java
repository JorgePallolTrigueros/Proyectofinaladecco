package com.Concesionario.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Concesionario.demo.Repository.AcabadosRepository;
import com.Concesionario.demo.Repository.CarRepository;
import com.Concesionario.demo.Repository.ColorRepository;
import com.Concesionario.demo.Repository.DirectionRepository;
import com.Concesionario.demo.Repository.EtiquetaRepository;
import com.Concesionario.demo.Repository.ManufacturerRepository;
import com.Concesionario.demo.Repository.MotorRepository;
import com.Concesionario.demo.Repository.ShopcartRepository;
import com.Concesionario.demo.Repository.UserRepository;
import com.Concesionario.demo.entities.Acabados;
import com.Concesionario.demo.entities.Car;
import com.Concesionario.demo.entities.Color;
import com.Concesionario.demo.entities.Direction;
import com.Concesionario.demo.entities.Etiqueta;
import com.Concesionario.demo.entities.Manufacturer;
import com.Concesionario.demo.entities.Motor;
import com.Concesionario.demo.entities.Shopcart;
import com.Concesionario.demo.entities.User;







@SpringBootApplication
public class ConcesionarioApplication  {

	
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShopcartRepository shopcartRepository;
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private AcabadosRepository acabadosRepository;
	@Autowired
	private DirectionRepository directionRepository;
	@Autowired
	private	MotorRepository motorRepository;
	@Autowired
	private	EtiquetaRepository etiquetaRepository;
	
	
	
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(ConcesionarioApplication.class, args);
	}

	
}
