package com.example.ppc.proyecto_final.model;

/**
 * Created by ppc on 21/06/2018.
 */

public class Descripcion {

    private String producto;
    private String cantidad;
    private String subtotal;
    private String ubicacion;
    private String precio_producto;

    public Descripcion() {
    }


    public Descripcion(String producto, String cantidad, String subtotal, String ubicacion, String precio_producto) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.ubicacion = ubicacion;
        this.precio_producto = precio_producto;
    }

    public String getProducto() {
        return producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getPrecio_producto() {
        return precio_producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setPrecio_producto(String precio_producto) {
        this.precio_producto = precio_producto;
    }
}
