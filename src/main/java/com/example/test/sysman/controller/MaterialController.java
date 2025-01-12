package com.example.test.sysman.controller;

import com.example.test.sysman.model.MaterialDTO;
import com.example.test.sysman.service.MaterialService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/materiales")
@Validated
public class MaterialController {

    private final MaterialService materialService;

    @Autowired
    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }
    
    @GetMapping("/health")
	public ResponseEntity<String> greeting() {
		return ResponseEntity.ok("Greetings from Spring Boot!");
	}

    @GetMapping
    public ResponseEntity<List<MaterialDTO>> getAllMaterials() {
        List<MaterialDTO> materiales = materialService.getAllMaterials();
        return ResponseEntity.ok(materiales);
    }
    
    @GetMapping("/by-type")
    public ResponseEntity<List<MaterialDTO>> getMaterialsByType(@RequestParam String tipo) {
        return ResponseEntity.ok(materialService.getMaterialsByType(tipo));
    }

    @GetMapping("/by-purchase-date")
    public ResponseEntity<List<MaterialDTO>> getMaterialsByPurchaseDate(@RequestParam String fechaCompra) {
        LocalDate date = LocalDate.parse(fechaCompra);
        return ResponseEntity.ok(materialService.getMaterialsByPurchaseDate(date));
    }

    @GetMapping("/by-purchase-date-range")
    public ResponseEntity<List<MaterialDTO>> getMaterialsByPurchaseDateRange(
            @RequestParam String startDate,
            @RequestParam String endDate
    ) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ResponseEntity.ok(materialService.getMaterialsByPurchaseDateRange(start, end));
    }

    @GetMapping("/by-city")
    public ResponseEntity<List<MaterialDTO>> getMaterialsByCity(@RequestParam Long ciudadId) {
        return ResponseEntity.ok(materialService.getMaterialsByCity(ciudadId));
    }
    
    @GetMapping("/by-name")
    public ResponseEntity<List<MaterialDTO>> getMaterialsByName(@RequestParam String keyword) {
        return ResponseEntity.ok(materialService.getMaterialsByName(keyword));
    }

    @PostMapping
    public ResponseEntity<MaterialDTO> createMaterial(@Valid @RequestBody MaterialDTO materialDTO) {
        return ResponseEntity.ok(materialService.createMaterial(materialDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDTO> updateMaterial(@PathVariable Long id, @Valid @RequestBody MaterialDTO materialDTO) {
        return ResponseEntity.ok(materialService.updateMaterial(id, materialDTO));
    }

}

