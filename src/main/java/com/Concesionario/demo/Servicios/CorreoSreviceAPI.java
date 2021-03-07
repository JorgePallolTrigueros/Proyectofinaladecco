package com.Concesionario.demo.Servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Concesionario.demo.entities.Car;
import com.Concesionario.demo.entities.Correo;

public interface CorreoSreviceAPI {
	Page<Correo> gettAll (Pageable pageable);
}
