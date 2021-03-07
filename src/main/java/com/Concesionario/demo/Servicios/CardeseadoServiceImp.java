package com.Concesionario.demo.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Concesionario.demo.Repository.CardeseadoRepository;
import com.Concesionario.demo.Repository.CorreoRepository;
import com.Concesionario.demo.entities.Cardeseado;
import com.Concesionario.demo.entities.Correo;


@Service
public class CardeseadoServiceImp implements CardeseadoSreviceAPI {

	@Autowired
	private CardeseadoRepository cardeseadoRepository;
	
	
	@Override
	public Page<Cardeseado> gettAll(Pageable pageable) {
		return cardeseadoRepository.findAll(pageable);
	}

}
