package com.Tienda.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

 private static final long serialVersionUID = 1L;   
    
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long idCliente;
 //id_cliente ----> idCliente
 
 
private String Nombre;
private String Apellidos;
private String Correo;
private String Telefono;

    public Cliente(String Nombre, String Apellidos, String Correo, String Telefono) {
        
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Telefono = Telefono;
    }

    public Cliente() {
    }


    
}
