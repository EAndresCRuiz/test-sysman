package com.example.test.sysman.repository;

import com.example.test.sysman.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findByTipo(String tipo);
    List<Material> findByFechaCompraBetween(LocalDate start, LocalDate end);
    List<Material> findByCiudadNombre(String ciudadNombre);
}
