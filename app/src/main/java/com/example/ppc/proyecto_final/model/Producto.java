package com.example.ppc.proyecto_final.model;

/**
 * Created by ppc on 19/06/2018.
 */

public class Producto {
    private String nombre;
    private String disponibilidad;
    private String categoria;
    private String imagen;
    private String clave;

    public Producto(){
    }

    public Producto(String nombre, String disponibilidad,String categoria,String imagen,String clave){
        this.nombre=nombre;
        this.disponibilidad=disponibilidad;
        this.categoria=categoria;
        this.imagen=imagen;
        this.clave=clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public String getClave() {
        return clave;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
