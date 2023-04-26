package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    private int idUser;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String nick;
    private int likes;
    private String fechaN;
    private int codigoPostal;
    private int oficio;
    private String telefonoP;
    private String correoP;
    private boolean habilitado;
    private boolean imagenD;
    private boolean metodoPago;
}
