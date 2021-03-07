package com.Concesionario.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Direction;

@Repository
public interface DirectionRepository extends JpaRepository<Direction, Long>{

}
