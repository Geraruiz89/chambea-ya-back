package com.example.helloworld.chambeaya.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioCorto {
    private int idUser;
    private String nick;
    private int likes;
    private String oficio;
    private boolean habilitado;
}
