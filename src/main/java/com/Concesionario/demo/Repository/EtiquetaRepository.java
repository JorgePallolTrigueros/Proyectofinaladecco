package com.Concesionario.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Etiqueta;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long>{


	

}
