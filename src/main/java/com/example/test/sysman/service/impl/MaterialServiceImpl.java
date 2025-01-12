package com.example.test.sysman.service.impl;

import com.example.test.sysman.entity.Ciudad;
import com.example.test.sysman.entity.Material;
import com.example.test.sysman.mapper.MaterialMapper;
import com.example.test.sysman.model.MaterialDTO;
import com.example.test.sysman.model.MaterialFilterDTO;
import com.example.test.sysman.repository.MaterialRepository;
import com.example.test.sysman.service.MaterialService;
import com.example.test.sysman.specification.MaterialSpecification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio para la gestión de materiales.
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    @Autowired
    public MaterialServiceImpl(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }

    @Override
    public List<MaterialDTO> getAllMaterials() {
        return materialRepository.findAll().stream()
                .map(materialMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaterialDTO> getMaterialsByType(String tipo) {
        return materialRepository.findByTipo(tipo).stream()
                .map(materialMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaterialDTO> getMaterialsByPurchaseDate(LocalDate fechaCompra) {
        return materialRepository.findByFechaCompra(fechaCompra).stream()
                .map(materialMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaterialDTO> getMaterialsByPurchaseDateRange(LocalDate startDate, LocalDate endDate) {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La fecha inicial no puede ser posterior a la fecha final");
        }
        return materialRepository.findByFechaCompraBetween(startDate, endDate).stream()
                .map(materialMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<MaterialDTO> getMaterialsByCity(Long ciudadId) {
        return materialRepository.findByCiudadId(ciudadId).stream()
                .map(materialMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<MaterialDTO> getMaterialsByName(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        return materialRepository.findByNombreContainingIgnoreCase(keyword).stream()
                .map(materialMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Obtiene una lista de materiales según los filtros aplicados.
     *
     * @param filter DTO con los criterios de filtro.
     * @return Lista de materiales que cumplen los criterios.
     */
    public List<MaterialDTO> getMaterialsByFilters(MaterialFilterDTO filter) {
        return materialRepository.findAll(MaterialSpecification.getMaterialsByFilters(filter), Sort.by("nombre").ascending())
        		.stream()
        		.map(materialMapper::toDTO)
        		.collect(Collectors.toList());
    }
    
    @Override
    public MaterialDTO createMaterial(MaterialDTO materialDTO) {
        Material material = materialMapper.toEntity(materialDTO);

        // Validación de fechas
        if (material.getFechaCompra().isAfter(material.getFechaVenta())) {
            throw new IllegalArgumentException("La fecha de compra no puede ser superior a la fecha de venta");
        }

        Material savedMaterial = materialRepository.save(material);
        return materialMapper.toDTO(savedMaterial);
    }

    public MaterialDTO updateMaterial(Long id, MaterialDTO materialDTO) {
        Material existingMaterial = materialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Material no encontrado"));

        existingMaterial.setNombre(materialDTO.getNombre());
        existingMaterial.setDescripcion(materialDTO.getDescripcion());
        existingMaterial.setTipo(materialDTO.getTipo());
        existingMaterial.setPrecio(materialDTO.getPrecio());
        existingMaterial.setFechaCompra(materialDTO.getFechaCompra());
        existingMaterial.setFechaVenta(materialDTO.getFechaVenta());
        existingMaterial.setEstado(materialDTO.getEstado());

        if (materialDTO.getCiudadId() != null) {
            Ciudad ciudad = new Ciudad();
            ciudad.setId(materialDTO.getCiudadId());
            existingMaterial.setCiudad(ciudad);
        }

        Material updatedMaterial = materialRepository.save(existingMaterial);
        return materialMapper.toDTO(updatedMaterial);
    }
}
