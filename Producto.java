/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotpv;

/**
 *
 * @author FP Mañana A
 */
class Producto {
   private String id_producto,nombre;
   private float precio;
   private int stock;

    public Producto(String id_producto, String nombre, float precio, int stock) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Producto() {
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", precio=" + precio + ", stock=" + stock + '}';
    }
   
}
