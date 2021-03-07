package com.Concesionario.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Acabados;
@Repository
public interface AcabadosRepository extends JpaRepository<Acabados, Long>{

}
