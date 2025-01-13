package com.example.test.sysman.model;

import jakarta.validation.constraints.NotBlank;

public class CiudadDTO {
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    public CiudadDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public CiudadDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

