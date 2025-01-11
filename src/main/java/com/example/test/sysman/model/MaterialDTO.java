package com.example.test.sysman.model;

import com.example.test.sysman.entity.EstadoMaterial;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class MaterialDTO {

    @NotBlank
    private String nombre;

    private String descripcion;

    @NotNull
    private String tipo;

    @NotNull
    private BigDecimal precio;

    @NotNull
    @PastOrPresent
    private LocalDate fechaCompra;

    @FutureOrPresent
    private LocalDate fechaVenta;

    @NotNull
    private EstadoMaterial estado;

    @NotBlank
    private String ciudadNombre;

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

	public String getCiudadNombre() {
		return ciudadNombre;
	}

	public void setCiudadNombre(String ciudadNombre) {
		this.ciudadNombre = ciudadNombre;
	}

}
