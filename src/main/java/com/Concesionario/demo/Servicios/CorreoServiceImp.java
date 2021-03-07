package com.Concesionario.demo.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Concesionario.demo.Repository.CorreoRepository;
import com.Concesionario.demo.entities.Correo;


@Service
public class CorreoServiceImp implements CorreoSreviceAPI {

	@Autowired
	private CorreoRepository correoRepository;
	
	
	@Override
	public Page<Correo> gettAll(Pageable pageable) {
		return correoRepository.findAll(pageable);
	}

}
