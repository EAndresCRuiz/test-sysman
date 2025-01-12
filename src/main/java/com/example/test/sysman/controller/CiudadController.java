package com.example.test.sysman.controller;

import com.example.test.sysman.model.CiudadDTO;
import com.example.test.sysman.service.CiudadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador para gestionar las ciudades.
 */
@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    /**
     * Obtiene todas las ciudades.
     *
     * @return Lista de ciudades.
     */
    @GetMapping
    public List<CiudadDTO> getAllCiudades() {
    	return ciudadService.getAllCiudades()
                .stream()
                .map(ciudad -> new CiudadDTO(ciudad.getId(), ciudad.getNombre()))
                .collect(Collectors.toList());
    }
}

