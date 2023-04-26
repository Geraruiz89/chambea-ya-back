package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Anuncio {
    private int id;
    private int idUser;
    private String descripcionCorta;
    private String descripcionLarga;
    private int estado;
    private String ubicaciones;
    private String disponibilidad;
    private String formaDeCobro;
    private String nombreC;
    private String telefonoC;
    private String correoC;
    private String facebook;
    private String instagram;
    private String twitter;
    private String youtube;
    private boolean anuncioActivo;
    private boolean anuncioRevisado;
}
