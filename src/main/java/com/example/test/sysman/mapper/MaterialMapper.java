package com.example.test.sysman.mapper;

import com.example.test.sysman.entity.Material;
import com.example.test.sysman.model.MaterialDTO;
import com.example.test.sysman.entity.Ciudad;

public class MaterialMapper {

    public static Material toEntity(MaterialDTO dto, Ciudad ciudad) {
        Material material = new Material();
        material.setNombre(dto.getNombre());
        material.setDescripcion(dto.getDescripcion());
        material.setTipo(dto.getTipo());
        material.setPrecio(dto.getPrecio());
        material.setFechaCompra(dto.getFechaCompra());
        material.setFechaVenta(dto.getFechaVenta());
        material.setEstado(dto.getEstado());
        material.setCiudad(ciudad);
        return material;
    }

    public static MaterialDTO toDTO(Material material) {
        MaterialDTO dto = new MaterialDTO();
        dto.setNombre(material.getNombre());
        dto.setDescripcion(material.getDescripcion());
        dto.setTipo(material.getTipo());
        dto.setPrecio(material.getPrecio());
        dto.setFechaCompra(material.getFechaCompra());
        dto.setFechaVenta(material.getFechaVenta());
        dto.setEstado(material.getEstado());
        dto.setCiudadNombre(material.getCiudad().getNombre());
        return dto;
    }
}

