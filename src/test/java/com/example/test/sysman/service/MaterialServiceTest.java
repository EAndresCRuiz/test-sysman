package com.example.test.sysman.service;

import com.example.test.sysman.model.MaterialDTO;
import com.example.test.sysman.entity.Material;
import com.example.test.sysman.mapper.MaterialMapper;
import com.example.test.sysman.repository.MaterialRepository;
import com.example.test.sysman.service.impl.MaterialServiceImpl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MaterialServiceTest {

    @Mock
    private MaterialRepository materialRepository;

    @Mock
    private MaterialMapper materialMapper;

    @InjectMocks
    private MaterialServiceImpl materialService;

    public MaterialServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getMaterialsByName_validKeyword() {
        String keyword = "Material";
        Material material = new Material();
        material.setId(1L);
        material.setNombre("Material de prueba");

        when(materialRepository.findByNombreContainingIgnoreCase(keyword)).thenReturn(List.of(material));
        when(materialMapper.toDTO(any(Material.class))).thenReturn(new MaterialDTO());

        List<MaterialDTO> result = materialService.getMaterialsByName(keyword);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(materialRepository, times(1)).findByNombreContainingIgnoreCase(keyword);
    }

    @Test
    void getMaterialsByName_emptyKeyword() {
        String keyword = "  ";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> materialService.getMaterialsByName(keyword));

        assertEquals("El nombre no puede estar vacío", exception.getMessage());
        verifyNoInteractions(materialRepository);
    }
}

