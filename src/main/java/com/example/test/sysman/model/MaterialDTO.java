package com.example.test.sysman.model;

import com.example.test.sysman.entity.EstadoMaterial;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MaterialDTO {
	
	private Long id;

	@NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La descripción no puede estar vacía")
    private String descripcion;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String tipo;

    @NotNull(message = "El precio no puede ser nulo")
    private BigDecimal precio;
    
    @PastOrPresent
    @NotNull(message = "La fecha de compra no puede ser nula")
    private LocalDate fechaCompra;

    @FutureOrPresent
    @NotNull(message = "La fecha de venta no puede ser nula")
    private LocalDate fechaVenta;

    @NotNull
    private EstadoMaterial estado;

    @NotNull(message = "La ciudad no puede ser nula")
    private Long ciudadId;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public EstadoMaterial getEstado() {
		return estado;
	}

	public void setEstado(EstadoMaterial estado) {
		this.estado = estado;
	}

	public Long getCiudadId() {
		return ciudadId;
	}

	public void setCiudadId(Long ciudadId) {
		this.ciudadId = ciudadId;
	}

}
