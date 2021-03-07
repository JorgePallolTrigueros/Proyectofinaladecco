package com.Concesionario.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Car;


@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
	
	
	List<Car> findAllByUsersId(Long id);
	
	List<Car> findAllByCode(Integer code);

}




