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
public class Dependiente {
    private String id_dependiente, nombre_dependiente, password_dependiente;

    public Dependiente(String id_dependiente, String nombre_dependiente, String password_dependiente) {
        this.id_dependiente = id_dependiente;
        this.nombre_dependiente = nombre_dependiente;
        this.password_dependiente = password_dependiente;
    }

    public Dependiente() {
    }

    public String getId_dependiente() {
        return id_dependiente;
    }

    public void setId_dependiente(String id_dependiente) {
        this.id_dependiente = id_dependiente;
    }

    public String getNombre_dependiente() {
        return nombre_dependiente;
    }

    public void setNombre_dependiente(String nombre_dependiente) {
        this.nombre_dependiente = nombre_dependiente;
    }

    public String getPassword_dependiente() {
        return password_dependiente;
    }

    public void setPassword_dependiente(String password_dependiente) {
        this.password_dependiente = password_dependiente;
    }

    @Override
    public String toString() {
        return "Dependiente{" + "id_dependiente=" + id_dependiente + ", nombre_dependiente=" + nombre_dependiente + ", password_dependiente=" + password_dependiente + '}';
    }
    
}
