/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotpv;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
public class Main extends Application{
    //Pantalla validar dependiente
    TextField tf_nombre_dependiente, tf_password_dependiente;
    Label lbl_mensajes_error_dependiente,lbl_nombre_dependiente, lbl_password_dependiente;
    Button btn_validar;
    //Pantalla introducir productos
    Label lbl_producto,lbl_mensajes_error_producto;
    TextField tf_producto;
    Button btn_introducir, btn_cerrar_sesion;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        AccesoBD.conectar();
        
        tf_nombre_dependiente=new TextField();
        tf_password_dependiente=new TextField();
        lbl_mensajes_error_dependiente=new Label();
        lbl_nombre_dependiente=new Label();
        lbl_nombre_dependiente.setText("Nombre Dependiente");
        lbl_password_dependiente=new Label();
        lbl_password_dependiente.setText("Password");
        btn_validar=new Button();
        btn_validar.setText("Validar");
        lbl_producto=new Label();
        lbl_producto.setText("Introduce el código del producto");
        tf_producto=new TextField();
        btn_introducir=new Button();
        btn_introducir.setText("Introducir");
        btn_cerrar_sesion=new Button();
        btn_cerrar_sesion.setText("Cerar Sesion");
        lbl_mensajes_error_producto=new Label();
        
        VBox vBox_validar_dependiente = new VBox(20);
        vBox_validar_dependiente.getChildren().addAll(lbl_nombre_dependiente,tf_nombre_dependiente,lbl_password_dependiente,tf_password_dependiente,lbl_mensajes_error_dependiente,btn_validar);
        Scene s_validar_dependiente=new Scene(vBox_validar_dependiente,300,300);
        stage.setScene(s_validar_dependiente);	
        stage.show();
        btn_validar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
            String nombre_dependiente=tf_nombre_dependiente.getText();
            boolean aux_nombre=AccesoBD.sacarDependientesNombres(nombre_dependiente);
            String password_dependiente=tf_password_dependiente.getText();
            boolean aux_password=AccesoBD.sacarDependientesPassword(password_dependiente);
            if(aux_nombre==true)
            {
                if(aux_password==true)
                {
                    VBox vBox_introducir_producto = new VBox(20);
                    vBox_introducir_producto.getChildren().addAll(lbl_producto,tf_producto,btn_introducir,btn_cerrar_sesion,lbl_mensajes_error_producto);
                    Scene s_introducir_producto=new Scene(vBox_introducir_producto,300,300);
                    stage.setScene(s_introducir_producto);	
                    stage.show();
                }
                else
                {
                   lbl_mensajes_error_dependiente.setText("La contraseña es incorrecta"); 
                }
            }
            else
            {
                lbl_mensajes_error_dependiente.setText("Su nombre no se encuentra en la BBDD");
            }
            }
        });
        ArrayList<Producto> carrito_compra=new ArrayList<>();
        btn_introducir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                String id_producto=tf_producto.getText();
                int posicion=id_producto.indexOf("x");
                int cantidad=1;
                if(posicion!=-1)
                {
                    String[] datos=id_producto.split("x");
                    id_producto=datos[0];
                    cantidad=Integer.parseInt(datos[1]);
                }
                boolean aux_producto=AccesoBD.validarProductos(id_producto);
                if(aux_producto==true)
                {
                  Producto p=AccesoBD.sacarProducto(id_producto);
                    for (int i = 0; i < cantidad; i++) {
                       carrito_compra.add(p); 
                    } 
                }
                else
                {
                    lbl_mensajes_error_producto.setText("El producto introducido no se encuetra en la base de datos");
                }
                for (Producto p : carrito_compra) {
                   System.out.println(p); 
                }
            }
        });
        
        
        
    }
            
}
