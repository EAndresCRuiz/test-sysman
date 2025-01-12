package com.example.test.sysman.specification;

import com.example.test.sysman.model.MaterialFilterDTO;

import jakarta.persistence.criteria.Predicate;

import com.example.test.sysman.entity.Material;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * Especificación para consultas dinámicas de materiales.
 */
public class MaterialSpecification {

	/**
	 * Crea una especificación JPA basada en los filtros proporcionados.
	 *
	 * @param filter DTO con los filtros aplicables.
	 * @return Especificación JPA para la consulta.
	 */
	public static Specification<Material> getMaterialsByFilters(MaterialFilterDTO filter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (filter.getNombre() != null && !filter.getNombre().isEmpty()) {
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")),
						"%" + filter.getNombre().toLowerCase() + "%"));
			}

			if (filter.getTipo() != null && !filter.getTipo().isEmpty()) {
				predicates.add(criteriaBuilder.equal(root.get("tipo"), filter.getTipo()));
			}

			if (filter.getFechaCompraDesde() != null) {
				predicates.add(
						criteriaBuilder.greaterThanOrEqualTo(root.get("fechaCompra"), filter.getFechaCompraDesde()));
			}

			if (filter.getCiudadId() != null) {
				predicates.add(criteriaBuilder.equal(root.get("ciudad").get("id"), filter.getCiudadId()));
			}

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
