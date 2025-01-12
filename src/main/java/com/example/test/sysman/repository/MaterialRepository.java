package com.example.test.sysman.repository;

import com.example.test.sysman.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio para gestionar operaciones CRUD y consultas personalizadas sobre la entidad {@link Material}.
 */
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>, JpaSpecificationExecutor<Material> {

    /**
     * Encuentra materiales por su tipo.
     *
     * @param tipo el tipo del material a buscar.
     * @return una lista de materiales que coinciden con el tipo proporcionado.
     */
    List<Material> findByTipo(String tipo);

    /**
     * Encuentra materiales por la fecha de compra.
     *
     * @param fechaCompra la fecha exacta de compra del material.
     * @return una lista de materiales comprados en la fecha especificada.
     */
    List<Material> findByFechaCompra(LocalDate fechaCompra);

    /**
     * Encuentra materiales comprados dentro de un rango de fechas.
     *
     * @param startDate la fecha de inicio del rango.
     * @param endDate   la fecha de fin del rango.
     * @return una lista de materiales comprados dentro del rango de fechas especificado.
     */
    List<Material> findByFechaCompraBetween(LocalDate startDate, LocalDate endDate);

    /**
     * Encuentra materiales por el ID de la ciudad donde están asociados.
     *
     * @param ciudadId el ID de la ciudad asociada al material.
     * @return una lista de materiales asociados a la ciudad especificada.
     */
    List<Material> findByCiudadId(Long ciudadId);
    
    /**
     * Encuentra materiales por el nombre del material, sin distinción entre mayúcula o minúscula.
     *
     * @param keyword el nombre o palabra clave del material.
     * @return una lista de materiales con el nombre dado.
     */
    List<Material> findByNombreContainingIgnoreCase(String keyword);
}
