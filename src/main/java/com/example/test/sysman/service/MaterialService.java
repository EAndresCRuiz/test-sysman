package com.example.test.sysman.service;

import com.example.test.sysman.model.MaterialDTO;

import java.util.List;

public interface MaterialService {
    List<MaterialDTO> getAllMaterials();
    MaterialDTO createMaterial(MaterialDTO materialDTO);
    MaterialDTO updateMaterial(Long id, MaterialDTO materialDTO);
}
