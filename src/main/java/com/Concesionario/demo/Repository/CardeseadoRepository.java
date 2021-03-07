package com.Concesionario.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Cardeseado;
@Repository
public interface CardeseadoRepository extends JpaRepository<Cardeseado, Long>{
	
	


}






