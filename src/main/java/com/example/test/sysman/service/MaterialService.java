package com.example.test.sysman.service;

import com.example.test.sysman.model.MaterialDTO;

import java.time.LocalDate;
import java.util.List;

public interface MaterialService {
    List<MaterialDTO> getAllMaterials();
    List<MaterialDTO> getMaterialsByType(String tipo);
    List<MaterialDTO> getMaterialsByPurchaseDate(LocalDate fechaCompra);
    List<MaterialDTO> getMaterialsByPurchaseDateRange(LocalDate startDate, LocalDate endDate);
    List<MaterialDTO> getMaterialsByCity(Long ciudadId);
    List<MaterialDTO> getMaterialsByName(String keyword);
    MaterialDTO createMaterial(MaterialDTO materialDTO);
    MaterialDTO updateMaterial(Long id, MaterialDTO materialDTO);
}
