package com.Concesionario.demo.Servicios;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Concesionario.demo.entities.Car;


public interface CarSrviceAPI {

	Page<Car> gettAll (Pageable pageable);
	
}
