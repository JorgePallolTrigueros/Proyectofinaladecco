package com.Concesionario.demo.Servicios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.Concesionario.demo.entities.Cardeseado;



public interface CardeseadoSreviceAPI {
	Page<Cardeseado> gettAll (Pageable pageable);
}




