package com.example.test.sysman.controller;

import com.example.test.sysman.entity.Material;
import com.example.test.sysman.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
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
    public ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> materiales = materialService.getAllMaterials();
        return ResponseEntity.ok(materiales);
    }

}

