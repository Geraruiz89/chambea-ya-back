package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDatosP {
    private int idUser;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String fechaN;
    private int codigoPostal;
    private String oficio;
    private String telefonoP;
    private String correoP;
}
