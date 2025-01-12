package com.example.test.sysman.service.impl;

import com.example.test.sysman.entity.Ciudad;
import com.example.test.sysman.repository.CiudadRepository;
import com.example.test.sysman.service.CiudadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para la gestión de ciudades.
 */
@Service
public class CiudadServiceImpl implements CiudadService {

	private final CiudadRepository ciudadRepository;
	
	@Autowired
    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    /**
     * Obtiene todas las ciudades disponibles.
     *
     * @return Lista de ciudades.
     */
	@Override
    public List<Ciudad> getAllCiudades() {
        return ciudadRepository.findAll();
    }
}

