/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotpv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP Mañana A
 */
public class AccesoBD {
     private static Connection c=null;
	private static Statement stmt=null;
	public static void conectar() {
		try {
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas","root","");
			stmt=c.createStatement();
                        System.out.println("Te has conectado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        System.out.println("Error");
		}
	}
        public static boolean sacarDependientesNombres(String nombre_dependiente)
    {
        boolean aux=false;
        String sql="SELECT * FROM `dependiente` WHERE `nombre`='"+nombre_dependiente+"' ";
        try {
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
              aux=true;  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
        public static boolean sacarDependientesPassword(String password_dependiente)
    {
        boolean aux=false;
        String sql="SELECT * FROM `dependiente` WHERE `password`='"+password_dependiente+"' ";
        try {
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
              aux=true;  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
         public static boolean validarProductos(String id_producto)
    {
        boolean aux=false;
        String sql="SELECT * FROM `producto` WHERE `id_producto`='"+id_producto+"' ";
        try {
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next())
            {
              aux=true;  
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }
         public static Producto sacarProducto(String id_producto)
    {
        Producto p=new Producto();
        String sql="SELECT * FROM `producto` WHERE `id_producto`='"+id_producto+"' ";
        try {
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next())
            {
              String id_producto_bbdd=rs.getString("id_producto");
              String nombre=rs.getString("nombre");
              float precio=rs.getFloat("precio");
              int stock=rs.getInt("stock");
              p.setId_producto(id_producto_bbdd);
              p.setNombre(nombre);
              p.setPrecio(precio);
              p.setStock(stock);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
}
