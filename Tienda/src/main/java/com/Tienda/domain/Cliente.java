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
 @Column (name="id_cliente")
 private Long idCliente;
 //id_cliente ----> idCliente
 
 
private String Nombre;
private String Apellidos;
private String Correo;
private String Telefono;

@JoinColumn(name="id_credito", referencedColumnName="id_credito")
@ManyToOne
public Credito credito;

    public Cliente(Long idCliente, String Nombre, String Apellidos, String Correo, String Telefono, Credito credito) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.credito = credito;
    }

    public Cliente() {
    }


    
}
