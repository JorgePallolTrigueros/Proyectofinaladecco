package com.Concesionario.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Motor;
@Repository
public interface MotorRepository extends JpaRepository<Motor, Long>{

}
