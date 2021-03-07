package com.Concesionario.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Concesionario.demo.entities.Correo;
@Repository
public interface CorreoRepository  extends JpaRepository<Correo, Long>{

}





	