package com.example.test.sysman.mapper;

import com.example.test.sysman.entity.Material;
import com.example.test.sysman.model.MaterialDTO;

import org.springframework.stereotype.Component;

import com.example.test.sysman.entity.Ciudad;

@Component
public class MaterialMapper {

    public Material toEntity(MaterialDTO dto) {
        Material material = new Material();
        material.setId(dto.getId());
        material.setNombre(dto.getNombre());
        material.setDescripcion(dto.getDescripcion());
        material.setTipo(dto.getTipo());
        material.setPrecio(dto.getPrecio());
        material.setFechaCompra(dto.getFechaCompra());
        material.setFechaVenta(dto.getFechaVenta());
        material.setEstado(dto.getEstado());
        material.setCiudad(new Ciudad());
        material.getCiudad().setId(dto.getCiudadId());
        return material;
    }

    public MaterialDTO toDTO(Material material) {
        MaterialDTO dto = new MaterialDTO();
        dto.setId(material.getId());
        dto.setNombre(material.getNombre());
        dto.setDescripcion(material.getDescripcion());
        dto.setTipo(material.getTipo());
        dto.setPrecio(material.getPrecio());
        dto.setFechaCompra(material.getFechaCompra());
        dto.setFechaVenta(material.getFechaVenta());
        dto.setEstado(material.getEstado());
        dto.setCiudadId(material.getCiudad().getId());
        return dto;
    }
}

