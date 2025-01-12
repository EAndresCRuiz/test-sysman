package com.example.test.sysman.model;

/**
 * DTO para encapsular los filtros de búsqueda de materiales.
 */
public class MaterialFilterDTO {

    /** Nombre del material. */
    private String nombre;

    /** Tipo del material. */
    private String tipo;

    /** Fecha mínima de compra. */
    private String fechaCompraDesde;

    /** ID de la ciudad asociada. */
    private Integer ciudadId;

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFechaCompraDesde() {
        return fechaCompraDesde;
    }

    public void setFechaCompraDesde(String fechaCompraDesde) {
        this.fechaCompraDesde = fechaCompraDesde;
    }

    public Integer getCiudadId() {
        return ciudadId;
    }

    public void setCiudadId(Integer ciudadId) {
        this.ciudadId = ciudadId;
    }
}

