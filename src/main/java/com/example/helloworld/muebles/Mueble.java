package com.example.helloworld.muebles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mueble {
    private int id;
    private String nombre;
    private String color;
    private float precio;
    private boolean agotado;
    
    
}
