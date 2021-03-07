package com.Concesionario.demo.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Concesionario.demo.entities.Car;
import com.Concesionario.demo.Repository.CarRepository;


@Service
public class CarServiceImp implements CarSrviceAPI {

	@Autowired
	private CarRepository carRepository;
	
	
	@Override
	public Page<Car> gettAll(Pageable pageable) {
		return carRepository.findAll(pageable);
	}

	
	
}
